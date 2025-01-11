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

public class authenticate extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel switchLabel;
    private JButton switchButton;
    private JLabel usernameLabel;
    private JLabel paswordLabel;
    private JPanel mainPanel;
    private JButton registerButton;
    public boolean isProf;


    public authenticate() {
        setTitle("ProiectJava");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600,600);
        setVisible(true);
        setResizable(false);
        isProf = false;
        FileDataManager fileDataManager = new FileDataManager();
        FileDisplay fileDisplay = new FileDisplay();
        List<Student> studs=fileDataManager.createStudentsData();
        List<Profesor> profs=fileDataManager.createProfesorData();



        switchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isProf == false) {
                    isProf = true;
                    switchLabel.setText("Logging in as TEACHER");
                } else {
                    isProf = false;
                    switchLabel.setText("Logging in as STUDENT");

                }

            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isProf == false) {
                    authHandler.loginStud(usernameField.getText(), passwordField.getText());
                    dispose();
                }
                if (isProf == true) {
                    authHandler.loginProf(usernameField.getText(), passwordField.getText());
                    dispose();
                }
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isProf == false){
                    regStudent reg = new regStudent();
                }
                if(isProf == true){
                    regProfesor reg = new regProfesor();
                }

            }
        });
    }
}
