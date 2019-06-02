package rainbowreef;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.io.IOException;
import java.util.ArrayList;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RainbowReef extends JFrame implements KeyListener {
    private JPanel main;
    private ArrayList<RRObject> objects;
    private static RRScore score;
    private RRShellfish shell;
    private boolean randommove;
    static int[] DIMENSION = new int[]{640, 480};
    private Random rd;
    private RainbowReef() throws HeadlessException {
        main = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < objects.size(); i++) {
                    RRObject go = objects.get(i);
                    go.draw(g);
                }
            }
        };
        add(main);
        rd = new Random();
        addKeyListener(this);
        objects = new ArrayList<>();
        score = new RRScore(objects, 0);
        RRStage.init();
        this.setSize(DIMENSION[0], DIMENSION[1]);
        this.setResizable(false);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        RainbowReef rainbowReef = new RainbowReef();
        try {
            rainbowReef.loadStage(0);
        } catch (IOException e) {
            System.out.println("There some problem with ");
            e.printStackTrace();
        }
        try {
            while (true) {
                rainbowReef.update();
                Thread.sleep(1000 / 144);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    private void loadStage(int i) throws IOException {
        objects.clear();
        score = new RRScore(objects, score.getScore());
        objects.add(new RRBackground(i));
        shell = new RRShellfish();
        objects.add(shell);

        /*Addong rectangle*/
        for (int i1 = 20; i1 < DIMENSION[0]; i1 = i1 + 40) {
            objects.add(new RRStone(i1, 0));
        }
        for (int i1 = 0; i1 < DIMENSION[1]; i1 = i1 + 20) {
            objects.add(new RRStone(-20, i1));
            objects.add(new RRStone(DIMENSION[0] - 20, i1));
        }
        for (int col = 0; col < RRStage.stages[i].length; col++) {
            for (int row = 0; row < RRStage.stages[i][col].length; row++) {
                RRObject obj = RRConstructor.getElement(score, RRStage.stages[i][col][row], col, row);
                if (obj != null) {
                    objects.add(obj);
                }
            }
        }
        objects.add(new RRLive(30, 420, score));
        objects.add(new RRStar(objects, score));
    }
    private void update() {
        repaint();
        revalidate();
        setTitle("Count: " + score.getScore());
        if (score.isEndStage()) {
            try {
                int u = score.getNextStage();
                System.out.println(u);
                loadStage(u);
            } catch (IOException e) {
                System.out.println("There problem with loading game stage");
                e.printStackTrace();
            }
        }
        if (score.isWin()) {
            try {
                loadStage(score.getWinStage());
            } catch (IOException e) {
                System.out.println("There problem with loading win stage");
                e.printStackTrace();
            }
        }
        if (score.isLoose()) {
            try {
                loadStage(score.getLooseStage());
                randommove = true;
            } catch (IOException e) {
                System.out.println("There problem with loading loose stage");
                e.printStackTrace();
            }
        }
        if (randommove) {
            int g = rd.nextInt(8);
            if (g == 5) {
                shell.left();
            }
            if (g == 3) {
                shell.right();
            }
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (!randommove) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                shell.left();
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                shell.right();
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
}
