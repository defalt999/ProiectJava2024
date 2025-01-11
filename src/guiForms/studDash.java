package guiForms;

import claseBaza.Student;

import javax.swing.*;

public class studDash extends JFrame {


    private JPanel mainPanel;
    private JLabel welcomeLabel;

    public studDash(Student student) {
        setTitle("ProiectJava");
        setContentPane(mainPanel);
        setSize(600, 600);
        setVisible(true);
        setResizable(false);
        welcomeLabel.setText("Welcome "+student.getPrenume()+"!");
    }
}
