import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuiDemo extends JFrame implements ActionListener {

    JPanel groundPanel = new JPanel();
    JPanel northPanel = new JPanel();
    JPanel southPanel = new JPanel();
    JPanel westPanel = new JPanel();
    JPanel eastPanel = new JPanel();

    JLabel label1 = new JLabel("En label");
    JLabel label2 = new JLabel("En label till");
    JLabel label3 = new JLabel("En tredje label");
    JLabel label4 = new JLabel("Här kommer nåt att hända");
    JButton button1 = new JButton("Knapp nr 1");
    JButton button2 = new JButton("Knapp nr 2");
    JButton button3 = new JButton("Knapp nr 3");
    JButton button4 = new JButton("Knapp nr 4");
    JButton button5 = new JButton("Knapp nr 5");
    JButton button6 = new JButton("Knapp nr 6");
    JButton button7 = new JButton("Knapp nr 7");
    JButton button8 = new JButton("Knapp nr 8");
    JButton button9 = new JButton("Knapp nr 9");
    JLabel image1 = new JLabel(new ImageIcon("mose.jpg"));
    JLabel image2 = new JLabel(new ImageIcon("svin.jpg"));


    public GuiDemo() {

        class MyListiner implements ActionListener{
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == button1){
                    label4.setText("Knapp 1 trycktes");
                }
                else if(e.getSource() == button2){
                    label4.setText("Knapp 2 trycktes");
                }
                else if(e.getSource() == button3){
                    label4.setText("Knapp 3 trycktes");
                }
                else if(e.getSource() == button4){
                    label4.setText("Knapp 4 trycktes");
                }
                else if(e.getSource() == button5){
                    label4.setText("Knapp 5 trycktes");
                }
                else if(e.getSource() == button6){
                    label4.setText("Knapp 6 trycktes");
                }
                else if(e.getSource() == button7){
                    label4.setText("Knapp 7 trycktes");
                }
                else if(e.getSource() == button8){
                    label4.setText("Knapp 8 trycktes");
                }
                else if(e.getSource() == button9){
                    label4.setText("Knapp 9 trycktes");
                }
            }
        }

        MyListiner listiner = new MyListiner();
        setTitle("Testprogram!");
        add(groundPanel);
        groundPanel.setLayout(new BorderLayout());
        northPanel.setLayout(new FlowLayout());
        southPanel.setLayout(new FlowLayout());
        westPanel.setLayout(new GridLayout(1,1));
        eastPanel.setLayout(new GridLayout(3,1));

        groundPanel.add(northPanel, BorderLayout.NORTH);
        groundPanel.add(southPanel, BorderLayout.SOUTH);
        groundPanel.add(westPanel, BorderLayout.WEST);
        groundPanel.add(eastPanel, BorderLayout.EAST);

        northPanel.add(button1);
        northPanel.add(button2);
        northPanel.add(button3);

        southPanel.add(button4);
        southPanel.add(button5);
        southPanel.add(button6);

        eastPanel.add(button7);
        eastPanel.add(button8);
        eastPanel.add(button9);

//        westPanel.add(label1);
//        westPanel.add(label2);
//        westPanel.add(label3);

        westPanel.add(image1);

        groundPanel.add(label4,BorderLayout.CENTER);

        button1.addActionListener(listiner);
        button2.addActionListener(listiner);
        button3.addActionListener(listiner);
        button4.addActionListener(listiner);
        button5.addActionListener(listiner);
        button6.addActionListener(listiner);
        button7.addActionListener(listiner);
        button8.addActionListener(listiner);
        button9.addActionListener(listiner);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        GuiDemo GD = new GuiDemo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button1){
            label4.setText("Knapp 1 trycktes");
        }
        else if(e.getSource() == button2){
            label4.setText("Knapp 2 trycktes");
        }
        else if(e.getSource() == button3){
            label4.setText("Knapp 3 trycktes");
        }
        else if(e.getSource() == button4){
            label4.setText("Knapp 4 trycktes");
        }
        else if(e.getSource() == button5){
            label4.setText("Knapp 5 trycktes");
        }
        else if(e.getSource() == button6){
            label4.setText("Knapp 6 trycktes");
        }
        else if(e.getSource() == button7){
            label4.setText("Knapp 7 trycktes");
        }
        else if(e.getSource() == button8){
            label4.setText("Knapp 8 trycktes");
        }
        else if(e.getSource() == button9){
            label4.setText("Knapp 9 trycktes");
        }
    }
}
