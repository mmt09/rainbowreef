package rainbowreef;

class RRShellfish extends RRObject {
    private int speed = 5;
    RRShellfish() {
        super(300, 420, "/RRresources/Katch.gif");
    }
    void left() {
        if (x > 20) {
            x -= speed;
        }
    }
    void right() {
        if (x < (RainbowReef.DIMENSION[0] - img.getWidth() - 20)) {
            x += speed;
        }
    }
}
