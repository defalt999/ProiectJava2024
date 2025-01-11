package guiForms;

import claseBaza.Curs;
import claseBaza.Profesor;
import claseFunctionalitate.FileDataManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class profDash  extends JFrame {
    private JPanel mainPanel;
    private JButton afiseazaCursuriPredateButton;
    private JButton logoutButton;
    private JButton afiseazaStudentiiUnuiCursButton;
    private JButton noteazaUnStudentButton;
    private JLabel welcomeLabel;

    public profDash(Profesor profesor) {

        setTitle("ProiectJava");
        setContentPane(mainPanel);
        setSize(600, 600);
        setVisible(true);
        setResizable(false);
        FileDataManager fileDataManager = new FileDataManager();
        List<Curs> cursList = fileDataManager.createCoursesData();
        welcomeLabel.setText("Welcome " + profesor.getPrenume() + "!");
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                authenticate authenticate = new authenticate();
            }
        });
        afiseazaCursuriPredateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Curs curs:cursList){
                    if(curs.getProfesor().getId()==profesor.getId()){

                    }

                }

            }
        });
    }

}
