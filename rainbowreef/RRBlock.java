package rainbowreef;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.ArrayList;

public class RRBlock extends RRObject {
    private RRScore rrscore;
    private int score;

    RRBlock(int x, int y, int type, RRScore score) {
        super(x, y);
        this.rrscore = score;
        this.score = type;
        try {
            this.img = ImageIO.read(this.getClass().getResource("/RRresources/Block" + type + ".gif"));
        } catch (IOException e) {
            System.out.println("Problem with loading image of " + this.getClass());
        }
    }

    void collide() {
        rrscore.removeObj(this);
    }
    int getScore() {
        return score;
    }
}
