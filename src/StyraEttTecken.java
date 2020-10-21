import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class StyraEttTecken extends JFrame implements KeyListener {

    List<Point> points = new ArrayList<>();
    List<JLabel> labels = new ArrayList<>();
    int gameSideSize = 10;
    int length = gameSideSize * gameSideSize;  // 64
    Point position = new Point(3,3);

    public StyraEttTecken(){
        setLayout(new GridLayout(gameSideSize, gameSideSize));
        addPoints();
        addLabels();
        addLabelsToFrame();
        writeStartPosition();
        addKeyListener(this);

        setLocation(500,200);
        setSize(300,300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void addPoints(){
        for(int i = 0; i < gameSideSize; i++){
            for(int j = 0; j < gameSideSize; j++){
                points.add(new Point(i,j));
            }
        }
    }

    public void addLabels(){
        for(int i = 0; i < length; i++){
            labels.add(new JLabel("",SwingConstants.CENTER));
            labels.get(i).setBorder(new EtchedBorder());
        }
    }

    public void addLabelsToFrame(){
        for(int i = 0; i < length; i++){
            add(labels.get(i));
        }
    }

    public void writeStartPosition(){
        for(int i = 0; i < length; i++){
            if(points.get(i).equals(position)){
                labels.get(i).setText("@");
            }
        }
    }

    public void move(int keyStroke){
        Point previous = new Point(position);

        if(keyStroke == KeyEvent.VK_DOWN){
            position.x +=1;
        }
        if(keyStroke == KeyEvent.VK_UP){
            position.x -=1;
        }
        if(keyStroke == KeyEvent.VK_RIGHT){
            position.y +=1;
        }
        if(keyStroke == KeyEvent.VK_LEFT){
            position.y -=1;
        }

        if(checkIfOnMap()){
            writePosition(previous);
        }
        else{
            position.x = previous.x;
            position.y = previous.y;
        }
    }

    public void writePosition(Point previous){
        for(int i = 0; i < length; i++){
            if(points.get(i).equals(previous)) labels.get(i).setText("");
            if(points.get(i).equals(position)) labels.get(i).setText("@");
        }
    }

    public boolean checkIfOnMap(){
        if(position.x < 0 || position.y < 0) return false;
        else if(position.x >= gameSideSize || position.y >= gameSideSize) return false;
        else return true;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            move(KeyEvent.VK_DOWN);
        }
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            move(KeyEvent.VK_UP);
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            move(KeyEvent.VK_RIGHT);
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            move(KeyEvent.VK_LEFT);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public static void main(String[] args) {
        StyraEttTecken start = new StyraEttTecken();

    }
}
