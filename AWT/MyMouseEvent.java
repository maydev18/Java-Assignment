import java.awt.*;
import java.awt.event.*;
public class MyMouseEvent extends Frame implements MouseListener,MouseMotionListener{
    String msg = "";
    int mouseX = 0 , mouseY =  0;
    public MyMouseEvent(){
        addMouseListener(this);
        addMouseMotionListener(this);
        addWindowListener(new MyWindowAdapter());
    }
    public void mouseClicked(MouseEvent e){
        msg += "----click received";
        repaint();
    }
    public void mouseEntered(MouseEvent e){
        mouseX = 100;
        mouseY = 100;
        msg = "mouse entered";
        repaint();
    }
    public void mouseExited(MouseEvent e){
        mouseY = 100;
        mouseX = 100;
        msg = "Mouse exited";
        repaint();
    }
    public void mousePressed(MouseEvent e){
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "Button Down";
        repaint();
    }
    public void mouseReleased(MouseEvent e){
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "Button Released";
        repaint();
    }
    public void mouseDragged(MouseEvent e){
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "Dragging" + "mouse at: " + e.getX() + " , " + e.getY();
        repaint();
    }
    public void mouseMoved(MouseEvent e){
        msg = "mouse moving at : " + e.getX() + " , " + e.getY();
        repaint();
    }
    public void paint(Graphics g){
        g.drawString(msg ,mouseX , mouseY);
    }
    public static void main(String args []){
        MyMouseEvent win = new MyMouseEvent();
        win.setSize(new Dimension(300,300));
        win.setTitle("Mouse Events handling");
        win.setVisible(true);
    }
}
class MyWindowAdapter extends WindowAdapter{
    public void windowClosing(WindowEvent ob){
        System.exit(0);
    }
}
