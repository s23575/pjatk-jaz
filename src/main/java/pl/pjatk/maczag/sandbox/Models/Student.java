package pl.pjatk.maczag.sandbox.Models;

public class Student {
    private Integer id;
    private String indeks;
    private String imie;
    private String nazwisko;

    public Student(Integer id, String indeks, String imie, String nazwisko) {
        this.id = id;
        this.indeks = indeks;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public int getId() {
        return id;
    }

    public String getIndeks() {
        return indeks;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIndeks(String indeks) {
        this.indeks = indeks;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
}
