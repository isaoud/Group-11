import sun.rmi.runtime.Log;

import java.awt.*;
import java.awt.event.*;

public class Robot extends Frame {
    Graphics g;
    /* Offset for painting area, such that (0,0) is in the middle  */
    final static int offset = 360;
    //    final static int xoffset = 510;
    final static int scalefactor = 100;

    /* Constructor */
    public Robot() {
        setTitle("Picture-Drawing Robot");
        setSize(700, 700);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    private int convert(double x) {
        return new Double(offset + x * scalefactor).intValue();
    }

    private void drawL(double x1, double y1, double x2, double y2) {
        g.drawLine(convert(x1), convert(y1 * -1), convert(x2), convert(y2 * -1));
    }


    /* State of the Picture-Drawing Robot */
    private double orientation = 0;
    private double xpos = 0;
    private double ypos = 0;
    private boolean down = false;

    /* Operations on the Robot */
    public double orientation() {
        return orientation;
    }

    public double xpos() {
        return xpos;
    }

    public double ypos() {
        return ypos;
    }

    public void move(double x) {
        double newx, newy;
        newx = xpos + Math.cos(orientation * Math.PI / 180) * x;
        newy = ypos + Math.sin(orientation * Math.PI / 180) * x;
        if (down) {
            drawL(xpos, ypos, newx, newy);
        }
        xpos = newx;
        ypos = newy;
    }

    public void left(double x) {
        orientation += x;
        if (orientation >= 360)
            orientation -= 360;
        //System.out.println("New Orientation is: "+orientation);
    }

    public void right(double x) {
        orientation -= x;
        if (orientation < 0)
            orientation += 360;
        //System.out.println("New Orientation is: "+orientation);
    }

    public void raisepen() {
        down = false;
    }

    public void lowerpen() {
        down = true;
    }

    /* In the methods below we will only make use 
       of the following methods and methods defined 
       using them.
       - orientation()
       - xpos()
       - ypos()
       - move(double x)
       - left(double x)
       - right(double x)
       - raisepen()
       - lowerpen()
    */

    /* Drawpolygon example from the lecture */
    public void drawpolygon(double size, int n) {
        lowerpen();
        for (int i = 0; i < n; i++) {
            move(size);
            left(360 / n);
        }
        raisepen();
    }

    /* Implementation of the algorithm of exercise task 3.1 (1) */
    /*
     * First of make x between 0 and 360, then check the difference in degrees
     * between the current state and the end state, and turn accordingly.
     * to make it less time consuming (considering it is a real robot) we consider two cases
     * Either it is faster to turn to the left or right.
     */
    public void changeorientation(double x) {
        x %= 360;
        if ((x - orientation) % 360 < 180)
            left((x - orientation) % 360);
        else
            right((x - orientation) % 360);
    /*
        double current = orientation();
        System.out.println("change Orientation from " + current + " to " + x + "resulted with " + orientation());
    */
    }

    /* Implementation of the algorithm of exercise task 3.1 (2) */
    /*
     * This function is supposed to let the point move to the given coordinates without
     * changing orientation.
     * First of we set it facing the X coordinates and we move to the desired point, then
     * we do the same for the Y coordinates. (P.S. this would work even if the point is lower).
     */
    public void movetopoint(double x, double y) {
        double currentOrientation = orientation();
        double currentX = xpos(), currentY = ypos();
        changeorientation(0);
        move(x - currentX);
        changeorientation(90);
        move(y - currentY);
        changeorientation(currentOrientation);
        //    System.out.println("new coordinates are: " + xpos() + ", " + ypos() + " with or: " + currentOrientation);
    }

    /* Implementation of the algorithm of tutorial task 2.1 */
    public void nikolaus(double x) {
        /* TODO: Enter your solution here */
    }


    @Override
    public void paint(Graphics g) {
        /* Initialize Robot */
        this.g = g;
        orientation = 0;
        xpos = 0;
        ypos = 0;
        down = false;
        /* Initialize Coordinate System*/
        drawL(-3.1, 0, 3.1, 0);
        drawL(0, -3.1, 0, 3.1);
        for (int i = -3; i <= 3; i++) {
            drawL(i, 0.05, i, -0.05);
            drawL(0.05, i, -0.05, i);
        }

        /* Test programm, drawing one shape in each sector of 
           the coordinate system. */
        movetopoint(1, 1);
        drawpolygon(1, 5);

        movetopoint(-2, 1);
        drawpolygon(1.5, 3);

        movetopoint(-2, -2);
        drawpolygon(1.5, 4);

        movetopoint(1, -2);
        drawpolygon(1, 6);
    }

    public static void main(String[] args) {
        new Robot().setVisible(true);
    }
}
