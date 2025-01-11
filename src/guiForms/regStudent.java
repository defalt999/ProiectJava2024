package guiForms;

import claseBaza.Student;
import claseFunctionalitate.FileDataManager;
import claseFunctionalitate.FileDisplay;

import javax.swing.*;
import java.util.List;

public class regStudent extends JFrame {
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JLabel label1;
    private JButton registerButton;
    private JPanel mainPanel;

    public regStudent(){
        setTitle("ProiectJava");
        setContentPane(mainPanel);

        setSize(600, 600);
        setVisible(true);
        setResizable(false);
        FileDataManager fileDataManager = new FileDataManager();
        FileDisplay fileDisplay = new FileDisplay();
        List<Student> studs = fileDataManager.createStudentsData();

    }
}
