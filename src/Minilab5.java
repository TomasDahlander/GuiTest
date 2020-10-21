import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Minilab5 extends JFrame implements ActionListener {

    private JPanel panel = new JPanel();
    private JCheckBox red = new JCheckBox("Röd",false);
    private JCheckBox yellow = new JCheckBox("Gul",false);
    private JCheckBox blue = new JCheckBox("Blå",false);
    private JLabel label = new JLabel("Show me the colors!");

    public Minilab5(){
        panel.setLayout(new GridLayout(4,1));
        panel.add(red);
        panel.add(yellow);
        panel.add(blue);
        panel.add(label);
        add(panel);

        red.addActionListener(this);
        yellow.addActionListener(this);
        blue.addActionListener(this);

        setSize(300,300);
        setLocation(300,300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Minilab5 m5 = new Minilab5();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(red.isSelected() && yellow.isSelected() && blue.isSelected()){
            panel.setBackground(new Color(171, 122, 24));
            label.setText("Brun");
        }
        else if(yellow.isSelected() && blue.isSelected()){
            panel.setBackground(Color.GREEN);
            label.setText("Grönt");
        }
        else if(red.isSelected() && blue.isSelected()){
            panel.setBackground(Color.MAGENTA);
            label.setText("Lila");
        }
        else if(red.isSelected() && yellow.isSelected()){
            panel.setBackground(Color.ORANGE);
            label.setText("Orange");
        }
        else if(red.isSelected()){
            panel.setBackground(Color.RED);
            label.setText("Rött");
        }
        else if(yellow.isSelected()){
            panel.setBackground(Color.YELLOW);
            label.setText("Gul");
        }
        else if(blue.isSelected()){
            panel.setBackground(Color.BLUE);
            label.setText("Blå");
        }
        else if(!red.isSelected() && !blue.isSelected() && !yellow.isSelected()){
            panel.setBackground(null);
            label.setText("Du har inte valt någon färg...");
        }

    }
}
