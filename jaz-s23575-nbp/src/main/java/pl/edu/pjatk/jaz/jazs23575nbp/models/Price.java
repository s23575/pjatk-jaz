package pl.edu.pjatk.jaz.jazs23575nbp.models;

public class Price {
    private String data;
    private double cena;

    public Price(String data, double cena) {
        this.data = data;
        this.cena = cena;
    }

    public Price() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }
}