import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FavMusic extends Frame implements ActionListener {
    JButton button = new JButton("Get text");
    JLabel label = new JLabel("Result will appear here", SwingConstants.CENTER);
    FavMusic() {
        c.gridy = 1;
        button.addActionListener(this);
        panel.add(button, c);

        c.gridy = 2;
        panel.add(label, c);

        setVisible(true);
    }

    public static void main(String[] args) {
        FavMusic run = new FavMusic();
    }

    public static String readFileContent() {
        String fullText = "";
        try (FileReader fr = new FileReader("AP-Lab3/myFavMusic.txt");
             BufferedReader br = new BufferedReader(fr))
        {
            String nextLine = br.readLine();
            while (nextLine!=null)
            {
                fullText+= nextLine+" ";
                nextLine = br.readLine();
            }
            return fullText;
        } catch (IOException e)
        {
            e.printStackTrace();
            return "An error has occurred";
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        label.setText(readFileContent());
    }
}
