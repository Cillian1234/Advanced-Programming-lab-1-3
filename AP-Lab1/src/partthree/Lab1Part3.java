package partthree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import partone.Lab1Part1;
public class Lab1Part3 extends Frame implements ActionListener {
        JTextField field = new JTextField();
        JButton button = new JButton("Retrieve student initials from name");
        JLabel label1 = new JLabel("Input student name here", SwingConstants.CENTER);
        JLabel label2 = new JLabel("Result will appear here", SwingConstants.CENTER);
    Lab1Part3() {

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
        button.addActionListener(this);
        panel.add(button, c);

        setVisible(true);
    }
    public static void main(String[] args) {
        Lab1Part3 run = new Lab1Part3();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        label2.setText(Lab1Part1.getStudentNameFromInitial(field.getText()));
    }
}
