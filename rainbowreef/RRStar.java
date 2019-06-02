package rainbowreef;

import java.awt.*;
import java.util.ArrayList;

public class RRStar extends RRObject {
    double speed = 0.5652;
    double[] coord = new double[]{0, 0};
    int r;
    ArrayList<RRObject> objects;
    RRScore score;
    RRStar(ArrayList<RRObject> objects, RRScore score) {
        super(320, 385, "/RRresources/Pop.gif");
        r = 225;
        this.objects = objects;
        this.score = score;
    }

    void draw(Graphics g) {
        checkCollide();
        speed = 0.65 + (score.getScore() / 25.0);
        coord[0] += (speed * Math.cos(Math.toRadians(r)));
        coord[1] += (speed * Math.sin(Math.toRadians(r)));
        double tX = Math.round(coord[0]);
        double tY = Math.round(coord[1]);
        coord[0] = coord[0] - tX;
        x += (int) tX;
        coord[1] = coord[1] - tY;
        y += (int) tY;
        if ((y + img.getHeight()) >RainbowReef.DIMENSION[1]) {
            score.dieStar();
            x = 320;
            y = 385;
            r = 225;
        }
        Graphics2D graphic2D = (Graphics2D) g;
        graphic2D.drawImage(img, x, y, null);
    }
    private void checkCollide() {
        boolean free = true;
        for (int i = 0; i < objects.size(); i++) {
            if (!objects.get(i).equals(this)) {
                if (objects.get(i).isIntersect(this)) {
                    objects.get(i).collide();
                    if (free) {
                        RRObject obj = objects.get(i);
                        Rectangle intersectionA = obj.getBoxRectange();
                        double[] center = new double[]{(intersectionA.width / 2) + intersectionA.x, intersectionA.y + (intersectionA.height / 2)};
                        Rectangle r2 = this.getBoxRectange();
                        int where = 0;
                        if (center[0] > r2.x) {
                            where += 1;
                        }
                        if (center[1] > r2.y) {
                            where += 10;
                        }
                        if (center[0] > (r2.x + r2.width)) {
                            where += 100;
                        }
                        if (center[1] > (r2.y + r2.height)) {
                            where += 1000;
                        }
                        switch (where) {
                            case 0:
                                switch (r) {
                                    case 225:
                                        r = 135;
                                        break;
                                    case 135:
                                        r = 45;
                                        break;
                                    case 45:
                                        r = 225;
                                        break;
                                    case 315:
                                        r = 45;
                                        break;
                                }
                                break;
                            case 1:
                                switch (r) {
                                    case 225:
                                        r = 135;
                                        break;
                                    case 135:
                                        r = 315;
                                        break;
                                    case 45:
                                        r = 225;
                                        break;
                                    case 315:
                                        r = 45;
                                        break;
                                }
                                break;
                            case 101:
                                switch (r) {
                                    case 225:
                                        r = 135;
                                        break;
                                    case 135:
                                        r = 315;
                                        break;
                                    case 45:
                                        r = 135;
                                        break;
                                    case 315:
                                        r = 225;
                                        break;
                                }
                                break;
                            case 10:
                                switch (r) {
                                    case 225:
                                        r = 315;
                                        break;
                                    case 135:
                                        r = 45;
                                        break;
                                    case 45:
                                        r = 315;
                                        break;
                                    case 315:
                                        r = 315;
                                        break;
                                }
                                break;
                            case 11:
                                switch (r) {
                                    case 225:
                                        r = 135;
                                        break;
                                    case 135:
                                        r = 225;
                                        break;
                                    case 45:
                                        r = 315;
                                        break;
                                    case 315:
                                        r = 45;
                                        break;
                                }
                                break;
                            case 111:
                                switch (r) {
                                    case 225:
                                        r = 225;
                                        break;
                                    case 135:
                                        r = 135;
                                        break;
                                    case 45:
                                        r = 135;
                                        break;
                                    case 315:
                                        r = 225;
                                        break;
                                }
                                break;
                            case 1010:
                                switch (r) {
                                    case 225:
                                        r = 225;
                                        break;
                                    case 135:
                                        r = 45;
                                        break;
                                    case 45:
                                        r = 45;
                                        break;
                                    case 315:
                                        r = 315;
                                        break;
                                }
                                break;
                            case 1011:
                                switch (r) {
                                    case 225:
                                        r = 225;
                                        break;
                                    case 135:
                                        r = 225;
                                        break;
                                    case 45:
                                        r = 315;
                                        break;
                                    case 315:
                                        r = 315;
                                        break;
                                }
                                break;
                            case 1111:
                                switch (r) {
                                    case 225:
                                        r = 225;
                                        break;
                                    case 135:
                                        r = 225;
                                        break;
                                    case 45:
                                        r = 315;
                                        break;
                                    case 315:
                                        r = 225;
                                        break;
                                }
                                break;
                            default:
                                break;
                        }
                        free = false;
                    }
                }
            }
        }
    }
}
