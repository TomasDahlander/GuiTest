import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TickTackToe extends JFrame implements ActionListener {

    JButton button1_1 = new JButton("");
    JButton button1_2 = new JButton(" ");
    JButton button1_3 = new JButton("  ");
    JButton button2_1 = new JButton("   ");
    JButton button2_2 = new JButton("    ");
    JButton button2_3 = new JButton("");
    JButton button3_1 = new JButton(" ");
    JButton button3_2 = new JButton("  ");
    JButton button3_3 = new JButton("   ");
    public final String X = "X";
    public final String O = "O";
    public int toggler = 1;
    public int movesLeft = 9;
    Font font = new Font("Verdana",Font.BOLD,40);

    public TickTackToe(){
        setTitle("Det är "+X+" tur.");

        setLayout(new GridLayout(3,3));
        add(button1_1);
        add(button1_2);
        add(button1_3);
        add(button2_1);
        add(button2_2);
        add(button2_3);
        add(button3_1);
        add(button3_2);
        add(button3_3);

        button1_1.setFont(font);
        button1_2.setFont(font);
        button1_3.setFont(font);
        button2_1.setFont(font);
        button2_2.setFont(font);
        button2_3.setFont(font);
        button3_1.setFont(font);
        button3_2.setFont(font);
        button3_3.setFont(font);

        button1_1.addActionListener(this);
        button1_2.addActionListener(this);
        button1_3.addActionListener(this);
        button2_1.addActionListener(this);
        button2_2.addActionListener(this);
        button2_3.addActionListener(this);
        button3_1.addActionListener(this);
        button3_2.addActionListener(this);
        button3_3.addActionListener(this);

        setVisible(true);
        setLocation(300,300);
        setSize(300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void reset(){
        button1_1.setText(""); button1_1.setBackground(null);
        button1_2.setText(" "); button1_2.setBackground(null);
        button1_3.setText("  "); button1_3.setBackground(null);
        button2_1.setText("   "); button2_1.setBackground(null);
        button2_2.setText("    "); button2_2.setBackground(null);
        button2_3.setText(""); button2_3.setBackground(null);
        button3_1.setText(" "); button3_1.setBackground(null);
        button3_2.setText("  "); button3_2.setBackground(null);
        button3_3.setText("   "); button3_3.setBackground(null);
        movesLeft = 9;
    }

    public void performChoice(JButton button){
        if(toggler == 1) {
            button.setText(X);
            movesLeft--;
            toggler = 0;
            setTitle("Det är "+O+" tur.");
        }
        else{
            button.setText(O);
            movesLeft--;
            toggler = 1;
            setTitle("Det är "+X+" tur.");
        }
    }

    public void setWin(JButton one, JButton two, JButton three){
        one.setBackground(Color.GREEN); two.setBackground(Color.GREEN); three.setBackground(Color.GREEN);
        JOptionPane.showMessageDialog(null, "Winner = " + one.getText());
        reset();
    }

    public boolean checkIfWin(JButton one, JButton two, JButton three){
        return (one.getText().equals(two.getText()) && one.getText().equals(three.getText()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Kollar vilken knapp som blivit tryckt
        if(e.getSource() == button1_1 && button1_1.getText().equals("")) performChoice(button1_1);
        else if(e.getSource() == button1_2 && button1_2.getText().equals(" ")) performChoice(button1_2);
        else if(e.getSource() == button1_3 && button1_3.getText().equals("  ")) performChoice(button1_3);
        else if(e.getSource() == button2_1 && button2_1.getText().equals("   ")) performChoice(button2_1);
        else if(e.getSource() == button2_2 && button2_2.getText().equals("    ")) performChoice(button2_2);
        else if(e.getSource() == button2_3 && button2_3.getText().equals("")) performChoice(button2_3);
        else if(e.getSource() == button3_1 && button3_1.getText().equals(" ")) performChoice(button3_1);
        else if(e.getSource() == button3_2 && button3_2.getText().equals("  ")) performChoice(button3_2);
        else if(e.getSource() == button3_3 && button3_3.getText().equals("   ")) performChoice(button3_3);

        // Kollar om vinst har inträffat
        if(checkIfWin(button1_1,button1_2, button1_3)) setWin(button1_1,button1_2,button1_3);
        else if(checkIfWin(button2_1,button2_2, button2_3)) setWin(button2_1,button2_2,button2_3);
        else if(checkIfWin(button3_1,button3_2, button3_3)) setWin(button3_1,button3_2,button3_3);
        else if(checkIfWin(button1_1,button2_1, button3_1)) setWin(button1_1,button2_1,button3_1);
        else if(checkIfWin(button1_2,button2_2, button3_2)) setWin(button1_2,button2_2,button3_2);
        else if(checkIfWin(button1_3,button2_3, button3_3)) setWin(button1_3,button2_3,button3_3);
        else if(checkIfWin(button1_1,button2_2, button3_3)) setWin(button1_1,button2_2,button3_3);
        else if(checkIfWin(button1_3,button2_2, button3_1)) setWin(button1_3,button2_2,button3_1);

        // kollar om det finns drag kvar
        if(movesLeft == 0) {
            JOptionPane.showMessageDialog(null,"It's a tie!");
            reset();
        }
    }

    public static void main(String[] args) {
        TickTackToe start = new TickTackToe();
    }
}
