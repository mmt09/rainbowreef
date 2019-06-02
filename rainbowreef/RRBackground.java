package rainbowreef;

import javax.imageio.ImageIO;

import java.io.IOException;

class RRBackground extends RRObject {
    RRBackground(int stage) throws IOException {
        super(0, 0);
        if (stage > 2) {
            this.img = ImageIO.read(this.getClass().getResource("/RRresources/Background1.bmp"));
        } else {
            this.img = ImageIO.read(this.getClass().getResource("/RRresources/Background2.bmp"));
        }
    }
    boolean isIntersect(RRObject object) {
        return false;
    }
}
