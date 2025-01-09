package claseBaza;

public class Student {
    private int id;
    private String nume;
    private String prenume;
    private String grupa;
    private int an;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", grupa='" + grupa + '\'' +
                ", an=" + an +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Student(int id, String nume, String prenume, String grupa, int an, String username, String password) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.grupa = grupa;
        this.an = an;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getGrupa() {
        return grupa;
    }

    public int getAn() {
        return an;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}