package claseFunctionalitate;

import claseBaza.Curs;
import claseBaza.Profesor;
import claseBaza.Student;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

;

public class FileDisplay {
    public void displayStudents(Student[] students){
        File fisier=new File("D:\\IntelijProiecte\\ProiectJava2024\\src\\csvuri\\Studenti.txt");
        try {
            BufferedWriter bw=new BufferedWriter(new FileWriter(fisier,false));
            bw.write("Id,Nume,Prenume,An,Username,Password\n");
            for(Student student : students){
                bw.write(student.getId()+","+student.getNume()+","+student.getPrenume()+","+student.getGrupa()+","+student.getAn()+","+student.getUsername()+","+student.getPassword()+"\n");
            }
            bw.flush();
        } catch (Exception e) {

        }
    }
    public void displayTeachers(Profesor[] profesors){
        File fisier=new File("D:\\IntelijProiecte\\ProiectJava2024\\src\\csvuri\\Profesori.txt");
        try {
            BufferedWriter bw=new BufferedWriter(new FileWriter(fisier,false));
            bw.write("Id,Nume,Prenume,Username,Password\n");
            for(Profesor profesor : profesors){
                bw.write(profesor.getId()+","+profesor.getNume()+","+profesor.getPrenume()+","+profesor.getUsername()+","+profesor.getPassword()+"\n");

            }
            bw.flush();
        } catch (Exception e) {

        }

    }
    public void displayNote(Curs[] cursuri){
        File fisier=new File("D:\\IntelijProiecte\\ProiectJava2024\\src\\csvuri\\Note.txt");
        FileDataManager fileDataManager=new FileDataManager();
        List<Curs> cursList=fileDataManager.createCoursesData();
        try {
            BufferedWriter bw=new BufferedWriter(new FileWriter(fisier,false));
            bw.write("IdCurs,IdStudent,Nota\n");
            for(Curs curs : cursuri){
                Set<Student> sList= curs.getStudenti();
                Map<Student,Integer> note=curs.getNote();
                for(Student student : sList){
                    bw.write(curs.getId()+","+student.getId()+","+ note.get(student)+"\n");
                }


            }
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void registerToCourses(Student s){
        File fisier=new File("D:\\IntelijProiecte\\ProiectJava2024\\src\\csvuri\\Note.txt");
        FileDataManager fileDataManager=new FileDataManager();
        List<Curs> cursList=fileDataManager.createCoursesData();

        try {
            BufferedWriter bw=new BufferedWriter(new FileWriter(fisier,true));
            for(Curs curs : cursList){
                if(curs.getAn() == s.getAn()){
                    bw.write(curs.getId()+","+s.getId()+","+"null"+"\n");
                }
            }
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
