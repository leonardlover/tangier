package tangier;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.JPanel;

class Rack extends JPanel {
    private ArrayList<Ball> rack;

    public Rack() {
        rack = new ArrayList<Ball>();
        Ball b;

        for (int i = 0; i < 16; i++) {
            b = new Ball(i);
            rack.add(b);
        }

        int dx = 31;
        int dy = 20;

        rack.get(0).setPos(300, 400);
        rack.get(9).setPos(600, 400);
        rack.get(12).setPos(600 + dx, 400 - dy);
        rack.get(1).setPos(600 + 2 * dx, 400 - 2 * dy);
        rack.get(14).setPos(600 + 3 * dx, 400 - 3 * dy);
        rack.get(5).setPos(600 + 4 * dx, 400 - 4 * dy);
        rack.get(7).setPos(600 + dx, 400 + dy);
        rack.get(15).setPos(600 + 2 * dx, 400 + 2 * dy);
        rack.get(6).setPos(600 + 3 * dx, 400 + 3 * dy);
        rack.get(11).setPos(600 + 4 * dx, 400 + 4 * dy);
        rack.get(8).setPos(600 + 2 * dx, 400);
        rack.get(3).setPos(600 + 3 * dx, 400 - dy);
        rack.get(10).setPos(600 + 3 * dx, 400 + dy);
        rack.get(4).setPos(600 + 4 * dx, 400 - 2 * dy);
        rack.get(13).setPos(600 + 4 * dx, 400);
        rack.get(2).setPos(600 + 4 * dx, 400 + 2 * dy);
    }

    public Ball getCueBall() {
        return rack.get(0);
    }

    public void hitWithCue(Cue cue) {
        Ball cueball = this.getCueBall();

        if (!cueball.isMoving()) {
            double angle = cue.getAngle();
            cueball.setMoving(10, angle);
        }
    }

    public void move(int ticks, Player p, Player q) {
        if (ticks >= 120) {
            for (int i = 0; i < rack.size(); i++) {
                rack.get(i).unsetMoving();
            }
        }
        else {
            for (int i = 0; i < rack.size(); i++) {
                Ball b = rack.get(i);

                double dx = b.getX() - b.getVX();
                double dy = b.getY() - b.getVY();

                if (dx >= 100 && dx <= 870) {
                    b.setX((int) dx);
                }
                else {
                    b.setVX(-b.getVX());
                }

                if (dy >= 100 && dy <= 670) {
                    b.setY((int) dy);
                }
                else {
                    b.setVY(-b.getVY());
                }

                for (int j = 0; j < rack.size(); j++) {
                    if (i == j) {
                        continue;
                    }

                    Ball c = rack.get(j);
                    int delx = b.getX() - c.getX();
                    int dely = b.getY() - c.getY();

                    if (Math.hypot(delx, dely) <= 30) {
                        double speed1 = b.getSpeed();
                        double speed2 = c.getSpeed();

                        double angle = Math.atan2(dely, delx);
                        double angle1 = b.getAngle();
                        double angle2 = c.getAngle();

                        b.setMoving(1, angle1);
                        c.setMoving(1, angle2);

                        b.setVX(speed2 * Math.cos(angle2 - angle) * Math.cos(angle) +
                                speed1 * Math.sin(angle1 - angle) * Math.cos(angle + Math.PI / 2));

                        b.setVY(speed2 * Math.cos(angle2 - angle) * Math.sin(angle) +
                                speed1 * Math.sin(angle1 - angle) * Math.sin(angle + Math.PI / 2));

                        c.setVX(speed1 * Math.cos(angle1 - angle) * Math.cos(angle) +
                                speed2 * Math.sin(angle2 - angle) * Math.cos(angle + Math.PI / 2));

                        c.setVY(speed1 * Math.cos(angle1 - angle) * Math.sin(angle) +
                                speed2 * Math.sin(angle2 - angle) * Math.sin(angle + Math.PI / 2));
                    }
                }

                int n = b.getNumber();

                if (n != 0 && n != 8) {
                    int xc = b.getX() + 15;
                    int yc = b.getY() + 15;

                    if (Math.hypot(xc - 100, yc - 100) <= 25 ||
                        Math.hypot(xc - 500, yc - 100) <= 25 ||
                        Math.hypot(xc - 900, yc - 100) <= 25 ||
                        Math.hypot(xc - 100, yc - 700) <= 25 ||
                        Math.hypot(xc - 500, yc - 700) <= 25 ||
                        Math.hypot(xc - 900, yc - 700) <= 25) {
                        b.unsetMoving();

                        if (n < 8) {
                            p.pocketBall(b);
                        }
                        else {

                            q.pocketBall(b);
                        }
                    }
                }
            }
        }
    }

    public void paintComponent(Graphics g) {
        for (int i = 0; i < rack.size(); i++) {
            rack.get(i).paintComponent(g);
        }
    }
}
