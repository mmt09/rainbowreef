package rainbowreef;

import java.awt.*;

public class RRLive extends RRObject {
    private RRScore score;
    RRLive(int x, int y, RRScore score) {
        super(x, y, "/RRresources/Katch_small.gif");
        this.score = score;
    }
    boolean isIntersect(RRObject object) {
        return false;
    }
    void draw(Graphics g) {
        Graphics2D graphic2D = (Graphics2D) g;
        for (int ia = 0; ia < score.getLive(); ia++) {
            graphic2D.drawImage(img, x + (ia * 35), y, null);
        }
    }
}
