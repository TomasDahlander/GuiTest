import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseListernerTest extends JFrame  {

    JPanel panel = new JPanel();
    JButton button = new JButton("En knapp");
//    JButton buttonToMove;
//    JLabel label = new JLabel("label");

    public MouseListernerTest(){
        MouseAdapter myListener = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.RED);
            }
            @Override
            public void mouseExited(MouseEvent e){
                button.setBackground(null);
            }
        };

        button.addMouseListener(myListener);

        setSize(250,100);
        add(panel);
        button.setSize(50,50);
        panel.add(button,CENTER_ALIGNMENT);

        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        MouseListernerTest start = new MouseListernerTest();
    }
}
