package pl.pjatk.maczag.sandbox.Models;

public class Car {
    private String name;
    private Integer id;

    public Car(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Gettery i Settery muszą być, bo pola konstruktora są prywatne; gdyby były publiczne, to by działało
}

