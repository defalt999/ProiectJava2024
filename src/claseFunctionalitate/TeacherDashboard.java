package claseFunctionalitate;

import claseBaza.Curs;
import claseBaza.Profesor;
import claseBaza.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherDashboard {
    public FileDataManager fileDataManager;
    public FileDisplay fileDisplay;
    String name;
    String surname;
    int idProf;
    List<Curs> cursList;
    List<Profesor> profesorList;

    public TeacherDashboard(String nume,String prenume){
        fileDataManager = new FileDataManager();
        fileDisplay = new FileDisplay();
        List<Curs> cursList=fileDataManager.createCoursesData();
        List<Profesor> profesorList=fileDataManager.createProfesorData();
        name = nume;
        surname = prenume;
        populate();
        run();
    }
    public void populate(){
        cursList=fileDataManager.createCoursesData();
        profesorList=fileDataManager.createProfesorData();
    }

    public void run(){
        for(Profesor profesor:profesorList){
            if(profesor.getNume().equals(name)&&profesor.getPrenume().equals(surname)){
                idProf=profesor.getId();
            }
        }
        System.out.println("Welcome " + name+" "+surname+"!");
        System.out.println();
        System.out.println("1.Afiseaza cursuri predate");
        System.out.println("2.Afiseaza studentii unui curs");
        System.out.println("3.Noteaza student");

        Scanner sc=new Scanner(System.in);
        String choice=sc.nextLine();
        switch(choice){
            case "1":
                for(Curs curs:cursList){
                    if(curs.getProfesor().getId()==idProf)
                        System.out.println(curs.toString());
                }
                run();

            case "2":
                for(Curs curs:cursList){
                    if(curs.getProfesor().getId()==idProf)
                        System.out.println(curs.toString());
                }
                System.out.println("Precizati ID-ul cursului");
                String alegere=sc.nextLine();
                for(Curs curs:cursList){
                    if(String.valueOf(curs.getId()).equals(alegere)){
                        for(Student s: curs.getStudenti()){
                            System.out.println(s+" Nota: "+curs.getNote().get(s));
                        }

                    }
                }
                run();



            case "3":
                for(Curs curs:cursList){
                    if(curs.getProfesor().getId()==idProf)
                        System.out.println(curs.toString());
                };
                System.out.println("Precizati ID-ul cursului");
                String deNota=sc.nextLine();
                String cursId=deNota;
                for(Curs curs:cursList){
                    if(String.valueOf(curs.getId()).equals(deNota)){
                        for(Student s: curs.getStudenti()){
                            System.out.println(s);
                        }

                    }
                }
                System.out.println("Precizati ID-ul studentului DE NOTAT");
                deNota=sc.nextLine();
                for(Curs curs:cursList){
                    if(String.valueOf(curs.getId()).equals(cursId)){
                        for(Student s: curs.getStudenti()){
                            if(String.valueOf(s.getId()).equals(deNota)){
                                System.out.println("Precizati nota:");
                                int nota= Integer.parseInt(sc.nextLine());
                                curs.getNote().put(s,nota);



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

                run();

        }
    }
}
