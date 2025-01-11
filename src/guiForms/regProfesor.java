package guiForms;

import claseBaza.Profesor;
import claseBaza.Student;
import claseFunctionalitate.FileDataManager;
import claseFunctionalitate.FileDisplay;
import claseFunctionalitate.authHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class regProfesor extends JFrame {
    private JPanel mainPanel;
    private JTextField nameField;
    private JTextField usernameField;
    private JTextField surnameField;
    private JTextField passwordField;
    private JButton registerButton;

    public regProfesor() {
        setTitle("ProiectJava");
        setContentPane(mainPanel);

        setSize(600, 600);
        setVisible(true);
        setResizable(false);
        FileDataManager fileDataManager = new FileDataManager();
        FileDisplay fileDisplay = new FileDisplay();
        List<Profesor> profesors = fileDataManager.createProfesorData();

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String surname= surnameField.getText();
                String username= usernameField.getText();
                String password= passwordField.getText();
                authHandler.registerProf(name,surname,username,password);
                JOptionPane.showMessageDialog(null,"Registered succesfuly!");
                dispose();

            }
        });
    }
}
