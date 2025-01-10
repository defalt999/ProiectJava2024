package claseFunctionalitate;

import claseBaza.Curs;
import claseBaza.Profesor;
import claseBaza.Student;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
    public void displayCourses(Curs[] cursuri){

    }



}
