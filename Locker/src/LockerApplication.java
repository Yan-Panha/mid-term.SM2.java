
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LockerApplication extends JFrame implements ActionListener {
    private JPasswordField passwordField;
    private JButton[] numberButtons;
    private JButton enterButton, clearButton;
    private JLabel statusLabel;
    private String savedPassword = null;

    public LockerApplication() {
        setTitle("Lock");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 250);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new GridLayout(3, 2));
        numberButtons = new JButton[9];

        for (int i = 0; i < 9; i++) {
            numberButtons[i] = new JButton(String.valueOf(i + 1));
            numberButtons[i].addActionListener(this);
            mainPanel.add(numberButtons[i]);
        }

        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(100, 30));
        passwordField.setEditable(false);

        enterButton = new JButton("Enter");
        enterButton.addActionListener(this);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);

        statusLabel = new JLabel("Enter Password");
        statusLabel.setHorizontalAlignment(SwingConstants.LEFT);

        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 8));
        inputPanel.add(clearButton);
        inputPanel.add(passwordField);
        inputPanel.add(enterButton);
        inputPanel.add(statusLabel);

        add(mainPanel, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enterButton) {
            String enteredPassword = new String(passwordField.getPassword());
            if (savedPassword == null) {
                savedPassword = enteredPassword;
                statusLabel.setText("Password Set");
            } else {
                if (enteredPassword.equals(savedPassword)) {
                    statusLabel.setText("Correct Password");
                } else {
                    statusLabel.setText("Incorrect Password");
                }
            }
            passwordField.setText("");
        } else if (e.getSource() == clearButton) {
            passwordField.setText("");
            statusLabel.setText("Enter Password");
        } else {
            for (int i = 0; i < 9; i++) {
                if (e.getSource() == numberButtons[i]) {
                    passwordField.setText(passwordField.getText() + (i + 1));
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LockerApplication());
    }
}
