package einkaufsliste;

import java.util.ArrayList;
import java.util.Scanner;

public class Einkaufliste {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Artikel> einkaufliste = new ArrayList<>();
        ArrayList<String> firmenListe = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("Einkaufsliste - Wähle eine Option:");
            System.out.println("1. Artikel hinzufügen");
            System.out.println("2. Artikel entfernen");
            System.out.println("3. Einkaufsliste anzeigen");
            System.out.println("4. Gesamtsumme anzeigen");
            System.out.println("5. Firma hinzufügen");
            System.out.println("6. Firmen anzeigen");
            System.out.println("7. Programm beenden");
            System.out.print("Eingabe: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Artikelname eingeben: ");
                    String name = scanner.nextLine();
                    System.out.print("Artikelmenge eingeben: ");
                    int menge = scanner.nextInt();
                    System.out.print("Preis pro Einheit eingeben: ");
                    double preis = scanner.nextDouble();
                    scanner.nextLine(); // consume newline

                    einkaufliste.add(new Artikel(name, menge, preis));
                    System.out.println(name + " wurde hinzugefügt.");
                    break;

                case 2:
                    System.out.print("Artikelname eingeben, um zu entfernen: ");
                    name = scanner.nextLine();
                    boolean entfernt = false;

                    for (Artikel artikel : einkaufliste) {
                        if (artikel.getName().equals(name)) {
                            einkaufliste.remove(artikel);
                            entfernt = true;
                            System.out.println(name + " wurde entfernt.");
                            break;
                        }
                    }

                    if (!entfernt) {
                        System.out.println(name + " ist nicht in der Liste.");
                    }
                    break;

                case 3:
                    System.out.println("Einkaufsliste:");
                    for (Artikel artikel : einkaufliste) {
                        System.out.println("- " + artikel);
                    }
                    break;

                case 4:
                    double gesamtpreis = 0;
                    for (Artikel artikel : einkaufliste) {
                        gesamtpreis += artikel.getGesamtpreis();
                    }
                    System.out.println("Gesamtsumme: " + gesamtpreis + "€");
                    break;

                case 5:
                    System.out.print("Firmennamen eingeben: ");
                    String firma = scanner.nextLine();
                    firmenListe.add(firma);
                    System.out.println(firma + " wurde hinzugefügt.");
                    break;

                case 6:
                    System.out.println("Firmenliste:");
                    for (String f : firmenListe) {
                        System.out.println("- " + f);
                    }
                    break;

                case 7:
                    running = false;
                    System.out.println("Programm wird beendet.");
                    break;

                default:
                    System.out.println("Ungültige Eingabe, bitte erneut versuchen.");
                    break;
            }
        }

        scanner.close();
    }
}
