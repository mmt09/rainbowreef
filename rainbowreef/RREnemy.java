package rainbowreef;

import java.util.ArrayList;

public class RREnemy extends RRObject {
    private RRScore rrscore;
    RREnemy(int x, int y, RRScore score) {
        super(x, y, "/RRresources/Bigleg_small.gif");
        score.addEnemy();
        this.rrscore = score;
    }
    public int getScore() {
        return 15;
    }
    void collide() {
        rrscore.removeEnemy(this);
    }
}
