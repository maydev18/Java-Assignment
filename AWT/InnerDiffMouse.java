import java.awt.*;
import java.awt.event.*;
public class InnerDiffMouse extends Frame {
    String msg = "";
    int mouseX = 0, mouseY = 0;
    public InnerDiffMouse() {
        addMouseListener(new MyMouse());
        addMouseMotionListener(new MyMouse());
        addWindowListener(new MyWindowAdapter());
    }

    public void paint(Graphics g) {
        g.drawString(msg, mouseX, mouseY);
    }

    public static void main(String args[]) {
        InnerDiffMouse win = new InnerDiffMouse();
        win.setSize(new Dimension(300, 300));
        win.setTitle("Different source and listener Mouse Events handling");
        win.setVisible(true);
    }
    class MyMouse extends MouseAdapter{
        public void mouseClicked(MouseEvent e){
            mouseX = e.getX();
            mouseY = e.getY();
            msg += "----click received";
            repaint();
        }
        public void mouseMoved(MouseEvent e){
            mouseX = e.getX();
            mouseY = e.getY();
            msg = "mouse at : " + e.getX() + " , " + e.getY();
            repaint();
        }
    }
    class MyWindowAdapter extends WindowAdapter{
        public void windowClosing(WindowEvent ob){
            System.exit(0);
        }
    }

}
