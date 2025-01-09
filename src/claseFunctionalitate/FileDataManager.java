package claseFunctionalitate;

import claseBaza.Curs;
import claseBaza.Profesor;
import claseBaza.Student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class FileDataManager {

    public String studPath="D:\\IntelijProiecte\\ProiectJava2024\\src\\csvuri\\Studenti.txt";
    public String profPath="D:\\IntelijProiecte\\ProiectJava2024\\src\\csvuri\\Profesori.txt";
    public String cursPath="D:\\IntelijProiecte\\ProiectJava2024\\src\\csvuri\\Cursuri.txt";
    public String notePath="D:\\IntelijProiecte\\ProiectJava2024\\src\\csvuri\\Note.txt";




    public List<Student> createStudentsData(){
        List<Student> students = new ArrayList<Student>();
        File fisier=new File(studPath);
        try {
            BufferedReader br=new BufferedReader(new FileReader(fisier));
            String linie=br.readLine();
            if(linie != null){
                linie=br.readLine();
            }
            while(linie != null){
                String[] splituri=linie.split(",");
                Student deAdaugat=new Student(Integer.parseInt(splituri[0]),splituri[1],splituri[2],splituri[3],Integer.parseInt(splituri[4]),splituri[5],splituri[6]);
                students.add(deAdaugat);
                linie=br.readLine();
            }
            return students;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public List<Profesor> createProfesorData(){
        List<Profesor> profesors = new ArrayList<Profesor>();
        File fisier=new File(profPath);
        try {
            BufferedReader br=new BufferedReader(new FileReader(fisier));
            String linie= br.readLine();
            if(linie != null){
                linie=br.readLine();
            }
            while(linie != null){
                String[] splituri=linie.split(",");
                Profesor deAdaugat=new Profesor(Integer.parseInt(splituri[0]),splituri[1],splituri[2],splituri[3],splituri[4]);
                profesors.add(deAdaugat);
                linie=br.readLine();
            }
            return profesors;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public List<Curs> createCoursesData(){
        List<Curs> cursuri=new ArrayList<Curs>();
        List<Profesor> profesors = createProfesorData();
        List<Student> students = createStudentsData();
        try {
            BufferedReader brcurs = new BufferedReader(new FileReader(cursPath));
            String linie=brcurs.readLine();
            if(linie != null){
                linie=brcurs.readLine();
            }
            while(linie != null){
                String[] splituri=linie.split(",");
                int id=Integer.parseInt(splituri[0]);
                String nume=splituri[1];
                String desc=splituri[2];
                Profesor deAdaugat = null;
                int idprof=Integer.parseInt(splituri[3]);
                int an=Integer.parseInt(splituri[4]);

                for(Profesor p : profesors){
                    if(p.getId()==idprof){
                        deAdaugat=p;
                        break;
                    }
                }

                Curs cursAdaugat=new Curs(id,nume,desc,deAdaugat,an);
                cursuri.add(cursAdaugat);
                linie=brcurs.readLine();
            }
            brcurs.close();
            BufferedReader brnote=new BufferedReader(new FileReader(notePath));
            String liniee=brnote.readLine();
            if(liniee != null){
                liniee=brnote.readLine();
            }
            while(liniee != null){
                String[] splituri=liniee.split(",");
                int idcurs=Integer.parseInt(splituri[0]);
                int idstud=Integer.parseInt(splituri[1]);
                Student deAdaugat=null;
                for (Student s: students){
                    if(s.getId()==idstud){
                        deAdaugat=s;
                    }
                }
                for(Curs c : cursuri){
                    if(c.getId()==idcurs){
                        c.adaugaStudenti(deAdaugat);
                        if(splituri[2] != null && !splituri[2].equals("null")){
                            c.noteazaStudent(deAdaugat,Integer.parseInt(splituri[2]));
                        }
                    }
                }
                liniee=brnote.readLine();
            }
            brnote.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return cursuri;
    }
}
