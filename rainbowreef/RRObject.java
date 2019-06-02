package rainbowreef;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class RRObject {
    protected int x;
    protected int y;
    protected BufferedImage img;
    RRObject(int x, int y, String img) {
        this.x = x;
        this.y = y;
        try {
            this.img = ImageIO.read(this.getClass().getResource(img));
        } catch (IOException e) {
            System.out.println("Problem with loading image of " + this.getClass());
        }
    }
    RRObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    boolean isIntersect(RRObject object) {
        return getBoxRectange().intersects(object.getBoxRectange());
    }
     Rectangle getBoxRectange() {
        return new Rectangle(x, y, img.getWidth(null), img.getHeight(null));
    }

    void draw(Graphics g) {
        Graphics2D graphic2D = (Graphics2D) g;
        graphic2D.drawImage(img, x, y, null);
    }
    void collide() {
    }
}
