package claseBaza;

public class Profesor {
    private int id;
    private String nume;
    private String prenume;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "Profesor{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Profesor(int id, String nume, String prenume, String username, String password) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
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

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}