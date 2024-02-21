package partthree;

import javax.swing.*;
import java.awt.*;

public class Lab1Part3 extends Frame {
    Lab1Part3() {
        JTextField field = new JTextField();
        JButton button = new JButton("Retrieve student initials from name");
        JLabel label1 = new JLabel("Input student name here", SwingConstants.CENTER);
        JLabel label2 = new JLabel("Result will appear here", SwingConstants.CENTER);

        c.gridy = 1;
        c.weighty = 0;
        c.anchor = GridBagConstraints.NORTH;
        panel.add(field, c);

        c.gridy = 2;
        panel.add(label2, c);

        c.gridx = 0;
        c.gridy = 0;
        panel.add(label1, c);

        c.gridy = 3;
        panel.add(button, c);



        setVisible(true);
    }
    public static void main(String[] args) {
        Lab1Part3 run = new Lab1Part3();
    }
}
