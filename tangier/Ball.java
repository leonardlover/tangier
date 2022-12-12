package tangier;

import java.awt.*;
import javax.swing.JPanel;

class Ball extends JPanel {
    private int x;
    private int y;
    private double vx;
    private double vy;
    private Boolean isMoving;
    private int number;

    public Ball(int n) {
        super();
        x = 0;
        y = 0;
        vx = 0.0;
        vy = 0.0;
        isMoving = false;
        number = n;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setPos(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public double getAngle() {
        if (!isMoving) {
            return 0.0;
        }

        return Math.atan2(vy, vx);
    }

    public double getSpeed() {
        return Math.hypot(vx, vy);
    }

    public void setSpeed(double s) {
        double speed = this.getSpeed();
        double newVX = s * vx / speed;
        double newVY = s * vy / speed;

        this.setVX(newVX);
        this.setVY(newVY);
    }

    public double getVX() {
        return vx;
    }

    public void setVX(double vx) {
        this.vx = vx;
    }

    public double getVY() {
        return vy;
    }

    public void setVY(double vy) {
        this.vy = vy;
    }

    public void setVel(double vx, double vy) {
        this.setVX(vx);
        this.setVY(vy);
    }

    public Boolean isMoving() {
        return isMoving;
    }

    public void setMoving(double speed, double angle) {
        this.setVX(Math.cos(angle));
        this.setVY(Math.sin(angle));
        this.setSpeed(speed);
        isMoving = true;
    }

    public void unsetMoving() {
        this.setVX(0.0);
        this.setVY(0.0);
        isMoving = false;
    }

    public int getNumber() {
        return number;
    }

    public Color getColor() {
        switch (number) {
            case 0:
                return new Color(0xFFFFFF);
            case 1:
            case 9:
                return new Color(0xFED531);
            case 2:
            case 10:
                return new Color(0x0B24FB);
            case 3:
            case 11:
                return new Color(0xFC0D1B);
            case 4:
            case 12:
                return new Color(0x7F0E7F);
            case 5:
            case 13:
                return new Color(0xFDA428);
            case 6:
            case 14:
                return new Color(0x298A29);
            case 7:
            case 15:
                return new Color(0x7F0208);
            default:
                return new Color(0x000000);
        }
    }

    public void paintComponent(Graphics g) {
        g.setColor((number <= 8) ? this.getColor() : Color.white);
        g.fillOval(x, y, 30, 30);

        if (number > 8) {
            g.setColor(this.getColor());
            g.fillRect(x + 1, y + 6, 29, 18);
        }

        g.setColor(Color.white);
        g.fillOval(x + 8, y + 8, 14, 14);
        g.setColor(Color.black);
        g.drawOval(x, y, 30, 30);

        int disp = (number <= 9) ? 12 : 8;
        if (number != 0) {
            g.drawString(String.valueOf(number), x + disp, y + 20);
        }
    }
}