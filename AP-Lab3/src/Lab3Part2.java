import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab3Part2 extends Frame implements ActionListener {
    JButton inputButton = new JButton("Enter");
    JTextField inputField = new JTextField();
    JLabel label = new JLabel("Please enter the array index you wish to output: ");
    JLabel outputLabel = new JLabel("Result will appear here", SwingConstants.CENTER);
    String[] stringArray = {"Munster", "Ulster", "Connacht", "Leinster"};
    Lab3Part2() {
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        inputButton.addActionListener(this);
        panel.add(inputButton, c);

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        panel.add(label, c);

        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        panel.add(inputField, c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        panel.add(outputLabel, c);


        setVisible(true);
    }

    /**
     * Handles changing of outputLabel text to requested item
     */
    public void changeLabelText() {
        try {
            outputLabel.setText(stringArray[Integer.parseInt(inputField.getText())]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            outputLabel.setText("Request beyond array size");
        }
    }

    public static void main(String[] args) {
        Lab3Part2 run = new Lab3Part2();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        changeLabelText();
    }
}
