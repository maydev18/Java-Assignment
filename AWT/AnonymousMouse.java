import java.awt.*;
import java.awt.event.*;
public class AnonymousMouse extends Frame {
    String msg = "";
    int mouseX = 0, mouseY = 0;
    public AnonymousMouse() {
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                mouseX = e.getX();
                mouseY = e.getY();
                msg += "----click received";
                repaint();
            }
        });
        addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent e){
                mouseX = e.getX();
                mouseY = e.getY();
                msg = "mouse at : " + e.getX() + " , " + e.getY();
                repaint();
            }
        });
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ob){
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {
        g.drawString(msg, mouseX, mouseY);
    }

    public static void main(String args[]) {
        AnonymousMouse win = new AnonymousMouse();
        win.setSize(new Dimension(300, 300));
        win.setTitle("Anonymous Mouse Events handling");
        win.setVisible(true);
    }
}
