import java.awt.*;
import java.awt.event.*;
//listener class
public class AnonymousKey extends Frame {
    String msg = "",keyState = "";
    public AnonymousKey(){
        addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                msg += e.getKeyChar();
                repaint();
            }
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
        });
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }
    public void paint(Graphics g){
        g.drawString(msg,50,50);
        g.drawString(keyState , 100 , 100);
    }
    public static void main(String args[]){
        AnonymousKey win = new AnonymousKey();
        win.setSize(new Dimension(300,300));
        win.setTitle(" Inner key");
        win.setVisible(true);
    }
}
