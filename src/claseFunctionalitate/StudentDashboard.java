package claseFunctionalitate;

public class StudentDashboard {

    public FileDataManager fileDataManager;
    String name;
    String surname;

    public StudentDashboard(String nume,String prenume){
        fileDataManager = new FileDataManager();
        name = nume;
        surname = prenume;
    }

}
