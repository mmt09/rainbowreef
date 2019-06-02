package rainbowreef;

import java.util.ArrayList;

public class RRConstructor {
    public static RRObject getElement(RRScore score, int i, int col, int row) {
        switch (i) {
            case 0:
                return new RRStone(10 + (40 * col), 20 + (20 * row));
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return new RRBlock(10 + (40 * col), 20 + (20 * row), i, score);
            case 8:
                return new RREnemy(10 + (40 * col), 20 + (20 * row), score);
            case -1:
                return null;
            case 98:
                return new RRObject(10 + (40 * col), 20 + (20 * row), "/RRresources/Congratulation.gif") {
                    @Override
                    void collide() {
                        super.collide();
                    }
                };
            case 99:
                return new RRObject(10 + (40 * col), 20 + (20 * row), "/RRresources/Button_quit.gif") {
                    @Override
                    void collide() {
                        super.collide();
                    }
                };
            default:
                return new RRStone(10 + (40 * col), 20 + (20 * row));
        }
    }
}
