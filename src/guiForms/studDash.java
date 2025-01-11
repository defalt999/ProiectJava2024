package guiForms;

import claseBaza.Curs;
import claseBaza.Student;
import claseFunctionalitate.FileDataManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class studDash extends JFrame {


    private JPanel mainPanel;
    private JLabel welcomeLabel;
    private JButton logoutButton;
    private JButton arataCursuriButton;
    private JButton verificaRestanteButton;
    private JButton calculeazaMediaButton;
    private JButton vizualizeazaNoteButton;

    public studDash(Student student) {
        setTitle("ProiectJava");
        setContentPane(mainPanel);
        setSize(600, 600);
        setVisible(true);
        setResizable(false);
        FileDataManager fileDataManager = new FileDataManager();
        List<Curs> cursList=fileDataManager.createCoursesData();
        welcomeLabel.setText("Welcome "+student.getPrenume()+"!");
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                authenticate authenticate = new authenticate();
            }
        });
        arataCursuriButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String an=JOptionPane.showInputDialog(null, "Specifica an:", "Specifica an", JOptionPane.PLAIN_MESSAGE);
                int ann=Integer.parseInt(an);

                        StringBuilder cursuriDeAfisat = new StringBuilder();
                        for(Curs curs:cursList){
                            if(curs.getAn()==ann){
                                cursuriDeAfisat.append(curs.getNume()+","+curs.getDescriere()+","+curs.getProfesor().getNume()+" "+curs.getProfesor().getPrenume()+"\n");
                            }
                        }
                        JOptionPane.showMessageDialog(null,cursuriDeAfisat.toString(),"Cursuri",JOptionPane.PLAIN_MESSAGE);

            }
        });
        vizualizeazaNoteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder cursuriDeAfisat = new StringBuilder();
                for(Curs curs:cursList){
                    Set<Student> studenti=curs.getStudenti();
                    Map<Student,Integer> noteDeAfisat;
                    for(Student s : studenti){
                        if(s.getId()==student.getId()){
                            noteDeAfisat=curs.getNote();
                            cursuriDeAfisat.append(curs.getNume()+" "+curs.getProfesor().getNume()+" "+curs.getProfesor().getPrenume()+" Nota:"+noteDeAfisat.get(s)+"\n");
                        }

                    }
                }
                JOptionPane.showMessageDialog(null,cursuriDeAfisat.toString(),"Cursuri",JOptionPane.PLAIN_MESSAGE);

            }
        });
        calculeazaMediaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double medie=0;
                int contor=0;
                for(Curs curs:cursList){
                    Set<Student> studenti=curs.getStudenti();
                    Map<Student,Integer> noteDeAfisat;
                    for(Student s : studenti){
                        if(s.getId()==student.getId()){
                            noteDeAfisat=curs.getNote();
                            medie=medie+noteDeAfisat.get(s);
                            contor++;
                        }

                    }
                }
                JOptionPane.showMessageDialog(null,"Media este: "+medie/contor);


            }
        });
        verificaRestanteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int contor=0;
                StringBuilder deAfis=new StringBuilder();
                deAfis.append("Esti restant la cursurile: \n");
                for(Curs curs:cursList){
                    Set<Student> studenti=curs.getStudenti();
                    Map<Student,Integer> noteDeAfisat;
                    for(Student s : studenti){
                        if(s.getId()==student.getId()){
                            noteDeAfisat=curs.getNote();
                            if(noteDeAfisat.get(s)<5){
                                contor++;
                                deAfis.append(curs.getNume()+" Profesor "+curs.getProfesor().getNume()+" "+curs.getProfesor().getPrenume()+"\n");
                            }

                        }

                    }
                }
                if(contor==0){
                    deAfis.append("Nu ai restante!");
                }
                JOptionPane.showMessageDialog(null,deAfis);

            }
        });
    }
}
