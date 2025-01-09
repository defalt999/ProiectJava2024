package claseFunctionalitate;

import claseBaza.Profesor;
import claseBaza.Student;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class authHandler {

    private static FileDataManager fileDataManager;

    public authHandler(FileDataManager fileDataManager) {
        this.fileDataManager = fileDataManager;
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
                TeacherDashboard dash=new TeacherDashboard();
            }
        }

    }
}
