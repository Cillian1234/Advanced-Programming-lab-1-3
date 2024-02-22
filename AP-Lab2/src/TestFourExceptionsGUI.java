import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class TestFourExceptionsGUI extends Frame implements ActionListener {
    JButton button1 = new JButton("Test IOException");
    JButton button2 = new JButton("Test Null Pointer Exception");
    JButton button3 = new JButton("Test URL Exception");
    JButton button4 = new JButton("Test General Exception");
    TestFourExceptionsGUI() {
        Frame.c.gridx = 0;
        Frame.c.gridy = 0;
        button1.addActionListener(this);
        Frame.panel.add(button1, Frame.c);

        Frame.c.gridx = 1;
        Frame.c.gridy = 0;
        button2.addActionListener(this);
        Frame.panel.add(button2, Frame.c);

        Frame.c.gridx = 0;
        Frame.c.gridy = 1;
        button3.addActionListener(this);
        Frame.panel.add(button3, Frame.c);

        Frame.c.gridx = 1;
        Frame.c.gridy = 1;
        button4.addActionListener(this);
        Frame.panel.add(button4, Frame.c);

        setVisible(true);
    }

    /**
     * This method will test and demonstrate 4 different types of exceptions
     *
     * @param string Any string
     * @param fileName Path to file in project
     * @param url Any valid URL
     * @param generalExceptionActivated True or false
     */
    public void testException(String string, String fileName, String url, boolean generalExceptionActivated) {
        try {
            string.toCharArray(); //Null string potential error
            new FileReader(fileName); //Unknown filename potential error
            new URL(url); //Badly written URL potential error
            if(generalExceptionActivated) { //Potential error
                this.clone(); //Will be caught as a general error!
            }
        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(null, "The URL passed is not correctly formatted " + e.getMessage(), "uh oh", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "There has been an input/output error " + e.getMessage(), "uh oh", JOptionPane.INFORMATION_MESSAGE);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "A null object has been passed to the method " + e.getMessage(), "uh oh", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An unidentified error has occurred " + e.getMessage(), "uh oh", JOptionPane.INFORMATION_MESSAGE);
        } finally {
            JOptionPane.showMessageDialog(null, "The finally block has been called", "Yippee", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        TestFourExceptionsGUI run = new TestFourExceptionsGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == button1) {
            testException("Hi", "Whatever.txt","http://www.itb.ie", false);
        } else if (source == button2) {
            testException(null, "AP-Lab2/src/Real.txt","http://www.itb.ie", false);
        } else if (source == button3) {
            testException("Hi", "AP-Lab2/src/Real.txt","ht//www.itb.ie", false);
        } else if (source == button4) {
            testException("Hi", "AP-Lab2/src/Real.txt","http://www.itb.ie", true);
        }
    }
}
