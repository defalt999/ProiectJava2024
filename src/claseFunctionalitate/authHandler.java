package claseFunctionalitate;

import claseBaza.Profesor;
import claseBaza.Student;
import guiForms.profDash;
import guiForms.studDash;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class authHandler {

    private static FileDataManager fileDataManager;
    private static FileDisplay fileDisplay;

    public authHandler(FileDataManager fileDataManager,FileDisplay fileDisplay) {

        this.fileDataManager = fileDataManager;
        this.fileDisplay = fileDisplay;
    }


    public static void loginStud() {
        List<Student> studentList=fileDataManager.createStudentsData();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your STUDENT username");
        String username=scanner.nextLine();
        System.out.println("Enter your STUDENT password");
        String password=scanner.nextLine();
        for(Student student:studentList){
            if(student.getUsername().equals(username) && student.getPassword().equals(password)){
                System.out.println("Login Successful as "+student.getNume()+" "+student.getPrenume());
                StudentDashboard dash=new StudentDashboard(student.getNume(),student.getPrenume());
            }
        }
    }
    public static void loginStud(String user,String paswd ) {
        List<Student> studentList=fileDataManager.createStudentsData();
        for(Student student:studentList){
            if(student.getUsername().equals(user) && student.getPassword().equals(paswd)){
                studDash dash=new studDash(student);

            }
        }

    }
    public static void loginProf() {
        List<Profesor> profesorsList=fileDataManager.createProfesorData();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your PROFESOR username");
        String username=scanner.nextLine();
        System.out.println("Enter your PROFESOR password");
        String password=scanner.nextLine();
        for(Profesor profesor:profesorsList){
            if(profesor.getUsername().equals(username) && profesor.getPassword().equals(password)){
                System.out.println("Login Successful as "+profesor.getNume()+" "+profesor.getPrenume());
                TeacherDashboard dash=new TeacherDashboard(profesor.getNume(),profesor.getPrenume());
            }
        }

    }
    public static void loginProf(String user,String paswd ) {
        List<Profesor> profesorsList=fileDataManager.createProfesorData();
        for(Profesor profesor:profesorsList){
            if(profesor.getUsername().equals(user) && profesor.getPassword().equals(paswd)){
                profDash dash=new profDash(profesor);


            }
        }


    }

    public static void registerStud() {
        List<Student> studentList=fileDataManager.createStudentsData();
        int studCount=studentList.size()+1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your STUDENT name");
        String name=scanner.nextLine();
        System.out.println("Enter your STUDENT surname");
        String surname=scanner.nextLine();
        System.out.println("Enter your STUDENT group");
        String group=scanner.nextLine();
        System.out.println("Enter your STUDENT year");
        int year=Integer.parseInt(scanner.nextLine());
        System.out.println("Enter your STUDENT username");
        String username=scanner.nextLine();
        System.out.println("Enter your STUDENT password");
        String password=scanner.nextLine();
        Student deAdaugat=new Student(studCount,name,surname,group,year,username,password);
        studentList.add(deAdaugat);
        Student[] aux = new Student[studentList.size()];
        int contor=0;
        for(Student student:studentList){
            aux[contor]=student;
            contor++;
        }
        fileDisplay.displayStudents(aux);
        fileDisplay.registerToCourses(deAdaugat);
        loginStud();





    }
    public static void registerStud(String name,String surname,String group,int year,String username,String password) {
        List<Student> studentList=fileDataManager.createStudentsData();
        int studCount=studentList.size()+1;
        Student deAdaugat=new Student(studCount,name,surname,group,year,username,password);
        studentList.add(deAdaugat);
        Student[] aux = new Student[studentList.size()];
        int contor=0;
        for(Student student:studentList){
            aux[contor]=student;
            contor++;
        }
        fileDisplay.displayStudents(aux);
        fileDisplay.registerToCourses(deAdaugat);
    }

    public static void registerProf(){
        List<Profesor> profList=fileDataManager.createProfesorData();
        int profCount=profList.size()+1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your PROFESOR name");
        String name=scanner.nextLine();
        System.out.println("Enter your PROFESOR surname");
        String surname=scanner.nextLine();
        System.out.println("Enter your PROFESOR username");
        String username=scanner.nextLine();
        System.out.println("Enter your PROFESOR password");
        String password=scanner.nextLine();
        Profesor deAdaugat=new Profesor(profCount,name,surname,username,password);
        profList.add(deAdaugat);
        Profesor[] aux = new Profesor[profList.size()];
        int contor=0;
        for(Profesor profesor:profList){
            aux[contor]=profesor;
            contor++;
        }
        fileDisplay.displayTeachers(aux);
        loginProf();
    }
    public static void registerProf(String nume,String prenume,String username,String password) {
        List<Profesor> profList=fileDataManager.createProfesorData();
        int profCount=profList.size()+1;
        Profesor deAdaugat=new Profesor(profCount,nume,prenume,username,password);
        profList.add(deAdaugat);
        Profesor[] aux = new Profesor[profList.size()];
        int contor=0;
        for(Profesor profesor:profList){
            aux[contor]=profesor;
            contor++;
        }
        fileDisplay.displayTeachers(aux);


    }
}
