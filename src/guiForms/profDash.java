package guiForms;

import claseBaza.Curs;
import claseBaza.Profesor;
import claseBaza.Student;
import claseFunctionalitate.FileDataManager;
import claseFunctionalitate.FileDisplay;

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
        FileDisplay fileDisplay = new FileDisplay();
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
                StringBuilder deAfis=new StringBuilder();
                deAfis.append("Cursurile Predate de dvs: \n");
                for(Curs curs:cursList){
                    if(curs.getProfesor().getId()==profesor.getId()){
                        deAfis.append(curs.getId()+" "+curs.getNume()+" "+curs.getDescriere());
                    }

                }
                JOptionPane.showMessageDialog(null,deAfis.toString(),"Cursuri",JOptionPane.PLAIN_MESSAGE);

            }
        });
        afiseazaStudentiiUnuiCursButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder deAfis=new StringBuilder();
                deAfis.append("Cursurile Predate de dvs: \n");
                for(Curs curs:cursList){
                    if(curs.getProfesor().getId()==profesor.getId()){
                        deAfis.append(curs.getId()+" "+curs.getNume()+" "+curs.getDescriere());
                    }

                }
                String id =JOptionPane.showInputDialog(null,deAfis.toString(),"Alege id-ul cursului",JOptionPane.PLAIN_MESSAGE);
                int idd=Integer.parseInt(id);
                StringBuilder deAfiss=new StringBuilder();
                for(Curs curs : cursList){
                    if(curs.getId()==idd){
                        for(Student student : curs.getStudenti()){
                            deAfiss.append(student.getId()+" "+student.getNume()+" "+student.getPrenume()+" "+curs.getNote().get(student)+"\n");

                        }

                    }
                }
                JOptionPane.showMessageDialog(null,deAfiss.toString());



            }
        });
        noteazaUnStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder deAfis=new StringBuilder();
                deAfis.append("Cursurile Predate de dvs: \n");
                for(Curs curs:cursList){
                    if(curs.getProfesor().getId()==profesor.getId()){
                        deAfis.append(curs.getId()+" "+curs.getNume()+" "+curs.getDescriere());
                    }

                }
                String id =JOptionPane.showInputDialog(null,deAfis.toString(),"Alege id-ul cursului",JOptionPane.PLAIN_MESSAGE);
                int idd=Integer.parseInt(id);
                StringBuilder deAfiss=new StringBuilder();
                for(Curs curs : cursList){
                    if(curs.getId()==idd){
                        for(Student student : curs.getStudenti()){
                            deAfiss.append(student.getId()+" "+student.getNume()+" "+student.getPrenume()+" "+curs.getNote().get(student)+"\n");

                        }

                    }
                }
                String iddd=JOptionPane.showInputDialog(null,deAfiss.toString(),"Introdu ID-ul studentului",JOptionPane.PLAIN_MESSAGE);
                int iddd1=Integer.parseInt(iddd);
                String nota=JOptionPane.showInputDialog(null,"Introdu nota","Introdu nota",JOptionPane.PLAIN_MESSAGE);
                int notaa=Integer.parseInt(nota);
                for(Curs curs:cursList){
                    if(String.valueOf(curs.getId()).equals(id)){
                        for(Student s: curs.getStudenti()){
                            if(String.valueOf(s.getId()).equals(iddd)){
                                curs.getNote().put(s,notaa);
                            }
                        }
                    }
                }
                Curs[] aux=new Curs[cursList.size()];
                int contorrr=0;
                for(Curs curs:cursList){
                    aux[contorrr]=curs;
                    contorrr++;
                }
                fileDisplay.displayNote(aux);




            }
        });
    }


}
