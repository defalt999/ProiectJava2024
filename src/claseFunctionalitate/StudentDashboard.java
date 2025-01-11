package claseFunctionalitate;

import claseBaza.Curs;
import claseBaza.Student;

import java.util.*;

public class StudentDashboard {

    public FileDataManager fileDataManager;
    String name;
    String surname;

    public StudentDashboard(String nume,String prenume){
        fileDataManager = new FileDataManager();
        name = nume;
        surname = prenume;
        run();
    }
    public void run(){
        List<Curs> cursList=fileDataManager.createCoursesData();
        System.out.println();
        System.out.println();
        System.out.println("Welcome " + surname+"!");
        System.out.println();
        System.out.println("1.Lista cursuri");
        System.out.println("2.Note");
        System.out.println("3.Calculeaza media");
        System.out.println("4.Lista restante");
        Scanner sc=new Scanner(System.in);
        String choice=sc.nextLine();
        switch(choice){
            case "1":
                System.out.println("Specifica an");
                choice=sc.nextLine();
                //Eram mort cand am fct switchu asta si vreau sa il las asa
                switch(choice){
                    case "1":
                        for(Curs curs:cursList){
                            if(curs.getAn()==1)
                                System.out.println(curs.toString());

                        }
                        run();


                    case "2":
                        for(Curs curs:cursList){
                            if(curs.getAn()==2)
                                System.out.println(curs.toString());

                        }
                        run();
                    case "3":
                        for(Curs curs:cursList){
                            if(curs.getAn()==3)
                                System.out.println(curs.toString());

                        }
                        run();
                    case "4":
                        for(Curs curs:cursList){
                            if(curs.getAn()==4)
                                System.out.println(curs.toString());

                        }
                        run();
                }


            case "2":
                for(Curs curs:cursList){
                    Set<Student> studenti=curs.getStudenti();
                    Map<Student,Integer> noteDeAfisat;
                    for(Student student : studenti){
                        if(Objects.equals(student.getNume(), name) && Objects.equals(student.getPrenume(), surname)) {
                            noteDeAfisat=curs.getNote();
                            System.out.println(curs.getNume()+" "+curs.getDescriere()+" "+noteDeAfisat.get(student));
                        }
                    }
                }
                run();


            case "3":
                double medie=0;
                double contor=0;
                for(Curs curs:cursList){
                    Set<Student> studenti=curs.getStudenti();
                    Map<Student,Integer> noteDeAfisat;
                    for(Student student : studenti){
                        if(Objects.equals(student.getNume(), name) && Objects.equals(student.getPrenume(), surname)) {
                            noteDeAfisat=curs.getNote();
                            if(noteDeAfisat.get(student)!=null){
                                medie=medie+noteDeAfisat.get(student);
                                contor++;
                            }
                        }
                    }
                }
                System.out.println("Media notelor este: "+medie/contor);
                run();

            case "4":
                int contorr=0;
                for(Curs curs:cursList){
                    Set<Student> studenti=curs.getStudenti();
                    Map<Student,Integer> noteDeAfisat;
                    for(Student student : studenti){
                        if(Objects.equals(student.getNume(), name) && Objects.equals(student.getPrenume(), surname)) {
                            noteDeAfisat=curs.getNote();
                            try {
                                if (noteDeAfisat.get(student) < 5) {
                                    System.out.println("Esti restant la cursul " + curs.getNume());
                                    contorr++;
                                }
                                ;
                            } catch (Exception e) {
                                System.out.println("");
                            }

                        }
                    }
                }
                if(contorr==0){
                    System.out.println("Nu ai nicio restanta!");
                }
                run();
        }
    }

}
