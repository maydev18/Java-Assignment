import java.awt.*;
import java.awt.event.*;
//listener class
public class InnerKey extends Frame {
    String msg = "",keyState = "";
    public InnerKey(){
        addKeyListener(new MyKey());
        addWindowListener(new MyWindowAdapter());
    }
    public void paint(Graphics g){
        g.drawString(msg,50,50);
        g.drawString(keyState , 100 , 100);
    }
    public static void main(String args[]){
        InnerKey win = new InnerKey();
        win.setSize(new Dimension(300,300));
        win.setTitle(" Inner key");
        win.setVisible(true);
    }
    class MyKey implements KeyListener {
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
    }
    class MyWindowAdapter extends WindowAdapter{
        public void windowClosing(WindowEvent e){
            System.exit(0);
        }
    }
}
