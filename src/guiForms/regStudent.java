package guiForms;

import claseBaza.Student;
import claseFunctionalitate.FileDataManager;
import claseFunctionalitate.FileDisplay;
import claseFunctionalitate.authHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class regStudent extends JFrame {
    private JTextField nameField;
    private JTextField usernameField;
    private JTextField yearField;
    private JTextField passwordField;
    private JTextField surnameField;
    private JLabel label1;
    private JButton registerButton;
    private JPanel mainPanel;
    private JTextField groupField;

    public regStudent(){
        setTitle("ProiectJava");
        setContentPane(mainPanel);

        setSize(600, 600);
        setVisible(true);
        setResizable(false);
        FileDataManager fileDataManager = new FileDataManager();
        FileDisplay fileDisplay = new FileDisplay();
        List<Student> studs = fileDataManager.createStudentsData();

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nume=nameField.getText();
                String surname=surnameField.getText();
                String group=groupField.getText();
                String year=yearField.getText();
                int an=Integer.parseInt(year);
                String username=usernameField.getText();
                String password=passwordField.getText();
                authHandler.registerStud(nume,surname,group,an,username,password);
                JOptionPane.showMessageDialog(null,"Registered succesfuly!");
                dispose();
            }
        });
    }
}
