import java.awt.*;
import java.awt.event.*;
public class DiffMouse extends Frame {
    String msg = "";
    int mouseX = 0, mouseY = 0;
    public DiffMouse() {
        addMouseListener(new MyMouse(this));
        addMouseMotionListener(new MyMouse(this));
        addWindowListener(new MyWindowAdapter());
    }

    public void paint(Graphics g) {
        g.drawString(msg, mouseX, mouseY);
    }

    public static void main(String args[]) {
        DiffMouse win = new DiffMouse();
        win.setSize(new Dimension(300, 300));
        win.setTitle("Different source and listener Mouse Events handling");
        win.setVisible(true);
    }
}
class MyMouse extends MouseAdapter{
    DiffMouse diff;
    MyMouse(DiffMouse diff){
        this.diff = diff;
    }
    public void mouseClicked(MouseEvent e){
        diff.mouseX = e.getX();
        diff.mouseY = e.getY();
        diff.msg += "----click received";
        diff.repaint();
    }
    public void mouseMoved(MouseEvent e){
        diff.msg = "mouse at : " + e.getX() + " , " + e.getY();
        diff.repaint();
    }
}
class MyWindowAdapter extends WindowAdapter{
    public void windowClosing(WindowEvent ob){
        System.exit(0);
    }
}
