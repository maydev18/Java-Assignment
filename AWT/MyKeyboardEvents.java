import java.awt.*;
import java.awt.event.*;
public class MyKeyboardEvents extends Frame implements KeyListener{
    String msg = "";
    String keyState = "";
    public MyKeyboardEvents(){
        addKeyListener(this);
        addWindowListener(new MyWindowAdapter());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        msg += e.getKeyChar();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyState = "key pressed";
        int key = e.getKeyCode();
        switch (key){
            case KeyEvent.VK_F1:
                msg += "F1";
                break;
            case KeyEvent.VK_ALT:
                msg += "ALT";
                break;
            case KeyEvent.VK_PAGE_UP:
                msg += "pageup";

                break;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyState = "key released";
        repaint();
    }
    @Override
    public void paint(Graphics g) {
        g.drawString(msg , 20 , 40);
        g.drawString(keyState , 50 , 100);
    }
    public static void main(String args[]){
        MyKeyboardEvents win = new MyKeyboardEvents();
        win.setSize(new Dimension(300,300));
        win.setTitle("Key Listener");
        win.setVisible(true);
    }
}
class MyWindowAdapter extends WindowAdapter{
    public void windowClosing(WindowEvent ob){
        System.exit(0);
    }
}