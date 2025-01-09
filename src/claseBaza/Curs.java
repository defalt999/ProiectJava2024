package claseBaza;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Curs {
    private int id;
    private String nume;
    private String descriere;
    private Profesor profesor;
    private Set<Student> studenti;
    private Map<Student, Integer> note;
    private int an;

    @Override
    public String toString() {
        return id+" "+nume+" "+descriere+" | Profesor: "+profesor.getNume()+" "+profesor.getPrenume();
    }

    public Curs(int id, String nume, String descriere, Profesor profesor,int an) {
        this.id = id;
        this.nume = nume;
        this.descriere = descriere;
        this.profesor = profesor;
        this.studenti = new HashSet<>();
        this.note = new HashMap<>();
        this.an = an;
    }

    public void adaugaStudenti(Student s) {
        studenti.add(s);
    }
    public void noteazaStudent(Student s,int nota) {
        note.put(s, nota);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Set<Student> getStudenti() {
        return studenti;
    }

    public void setStudenti(Set<Student> studenti) {
        this.studenti = studenti;
    }

    public Map<Student, Integer> getNote() {
        return note;
    }

    public void setNote(Map<Student, Integer> note) {
        this.note = note;
    }

    public int getAn() {
        return an;
    }

    public void setAn(int an) {
        this.an = an;
    }
}


