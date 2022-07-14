import java.awt.*;
import java.awt.event.*;
//listener class
public class DiffKey extends Frame {
    String msg = "",keyState = "";
    public DiffKey(){
        addKeyListener(new MyKey(this));
        addWindowListener(new MyWindowAdapter());
    }
    public void paint(Graphics g){
        g.drawString(msg,50,50);
        g.drawString(keyState , 100 , 100);
    }
    public static void main(String args[]){
        DiffKey win = new DiffKey();
        win.setSize(new Dimension(300,300));
        win.setTitle("DIfference source and listener key");
        win.setVisible(true);
    }
}
//source
class MyKey implements KeyListener {
    DiffKey diffkey;
    public MyKey(DiffKey diff) {
        this.diffkey = diff;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        diffkey.msg += e.getKeyChar();
        diffkey.repaint();
    }
    @Override
    public void keyPressed(KeyEvent e) {
        diffkey.keyState = "key pressed";
        int key = e.getKeyCode();
        switch (key){
            case KeyEvent.VK_F1:
                diffkey.msg += "F1";
                break;
            case KeyEvent.VK_ALT:
                diffkey.msg += "ALT";
                break;
            case KeyEvent.VK_PAGE_UP:
                diffkey.msg += "pageup";
                break;
        }
        diffkey.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        diffkey.keyState = "key released";
        diffkey.repaint();
    }
}
class MyWindowAdapter extends WindowAdapter{
    public void windowClosing(WindowEvent ob){
        System.exit(0);
    }
}
