import claseBaza.Curs;
import claseBaza.Profesor;
import claseBaza.Student;
import claseFunctionalitate.FileDataManager;
import claseFunctionalitate.FileDisplay;
import claseFunctionalitate.authHandler;


import java.util.List;
import java.util.Scanner;

class consoleThread extends Thread{
     @Override
     public void run() {
         FileDataManager fileDataManager = new FileDataManager();
         FileDisplay fileDisplay = new FileDisplay();
         List<Student> studentList = fileDataManager.createStudentsData();
         List<Profesor> profesorList=fileDataManager.createProfesorData();
         List<Curs> cursList=fileDataManager.createCoursesData();
         authHandler auth=new authHandler(fileDataManager);
         Scanner scanner = new Scanner(System.in);
         Boolean prof=false;
         Boolean stud=false;

         System.out.println("1.Student");
         System.out.println("2.Profesor");

         String response=scanner.nextLine();
         if(response.equals("1")){
             stud=true;
         }
         if(response.equals("2")){
             prof=true;
         }

         System.out.println("1.Login");
         System.out.println("2.Register");
         System.out.println("3.Exit");

         response=scanner.nextLine();
         if(response.equals("1")&&stud==true){
             authHandler.loginStud();
         }
        if(response.equals("1")&&prof==true) {
            authHandler.loginProf();
//        }
//         if(response.equals("2")&&stud==true){
//             authHandler.registerStud();
//         }
//         if(response.equals("2")&&prof==true){
//             authHandler.registerProf();
//         }
            if (response.equals("3")) {
                System.exit(0);
            }


        }

     }
}
