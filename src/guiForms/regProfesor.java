package guiForms;

import claseBaza.Student;
import claseFunctionalitate.FileDataManager;
import claseFunctionalitate.FileDisplay;

import javax.swing.*;
import java.util.List;

public class regProfesor extends JFrame {
    private JPanel mainPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton registerButton;

    public regProfesor() {
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
