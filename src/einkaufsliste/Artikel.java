package einkaufsliste;

public class Artikel {
    private String name;
    private int menge;
    private double preis;

    public Artikel(String name, int menge, double preis) {
        this.name = name;
        this.menge = menge;
        this.preis = preis;
    }

    public String getName() {
        return name;
    }

    public int getMenge() {
        return menge;
    }

    public double getPreis() {
        return preis;
    }

    public double getGesamtpreis() {
        return menge * preis;
    }

    @Override
    public String toString() {
        return menge + " x " + name + " (Einzelpreis: " + preis + "€, Gesamtpreis: " + getGesamtpreis() + "€)";
    }
}
