import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BouncingBall extends JFrame implements ActionListener {

    private int x = 0;
    private int y = 0;
    private int dx = 5;
    private int dy = 5;
    private Timer timer;
    private Image dbImage;
    private Graphics dbg;

    public BouncingBall() {
        setTitle("Bouncing Ball");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        timer = new Timer(10, this);
        timer.start();

        setVisible(true);
    }

    public void paint(Graphics g) {
        if (dbImage == null) {
            dbImage = createImage(getWidth(), getHeight());
            dbg = dbImage.getGraphics();
        }

        dbg.setColor(getBackground());
        dbg.fillRect(0, 0, getWidth(), getHeight());

        dbg.setColor(Color.RED);
        dbg.fillOval(x, y, 50, 50);

        g.drawImage(dbImage, 0, 0, this);
    }

    public void actionPerformed(ActionEvent e) {
        x += dx;
        y += dy;

        if (x < 0) {
            x = 0;
            dx = -dx;
        } else if (x + 50 > getWidth()) {
            x = getWidth() - 50;
            dx = -dx;
        }

        if (y < 0) {
            y = 0;
            dy = -dy;
        } else if (y + 50 > getHeight()) {
            y = getHeight() - 50;
            dy = -dy;
        }

        repaint();
    }

    public static void main(String[] args) {
        new BouncingBall();
    }
}
