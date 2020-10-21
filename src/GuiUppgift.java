import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.List;

public class GuiUppgift extends JFrame {

    JPanel groundPanel = new JPanel();
    JLabel image;
    JButton button = new JButton("Växla bild");

    Path imageDir = Paths.get("Bilder");
    List<String> imageFileNames = new ArrayList<>();
    int imageIndex = 0;
    int imageCount= 0;

    protected List <String> loadImageNames(Path imageDir){
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(imageDir)) {
            for (Path file: stream) {
                imageFileNames.add(file.toString());
            }
        } catch (IOException | DirectoryIteratorException x) {
            x.printStackTrace();
        }
        return imageFileNames;
    }


    public GuiUppgift(){
        imageFileNames = loadImageNames(imageDir);
        imageCount = imageFileNames.size();
        setTitle("Bildväxlare");
        image = new JLabel(new ImageIcon(imageFileNames.get(imageIndex)));

        add(groundPanel);
        groundPanel.setLayout(new FlowLayout());
        groundPanel.add(image);
        groundPanel.add(button);
        image.setPreferredSize(new Dimension(700,700));

        button.addActionListener(ae -> changeImage());

        setVisible(true);
        setLocation(10,10);
        setSize(850,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
     GuiUppgift start = new GuiUppgift();
    }

    public void changeImage(){
        imageIndex = (imageIndex + 1) % imageCount;
        image.setIcon(new ImageIcon( imageFileNames.get(imageIndex)));
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        imageIndex = (imageIndex + 1) % imageCount;
//        image.setIcon(new ImageIcon( imageFileNames.get(imageIndex)));
//    }
}
