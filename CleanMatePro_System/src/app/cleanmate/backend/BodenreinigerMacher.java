package app.cleanmate.backend;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import app.cleanmate.model.Bodenreiniger;

/**
 * Verwaltet und erstellt Bodenreiniger-Objekte für das Lagermanagement.
 * 
 * Diese Klasse übernimmt die Erstellung und Verwaltung von Bodenreiniger-Produkten
 * mit verschiedenen Attributen wie Produktnamen, Kategorien, Herstellern,
 * Preisen und Bestandsinformationen.
 */
public class BodenreinigerMacher {

    private final List<Bodenreiniger> alleBodenreiniger = new ArrayList<>();

    // Product data collections
    private final String[] produktNamen = {
            "Torvan-Konzentrat", "Schnell Forol", "Parketto-clean-Konzentrat",
            "Alkoholglanzreiniger blau", "Lemon Duft-Neutralreiniger", "Clarida Uni", "Veriprop",
            "Keradet-Konzentrat-Aktiv", "Losoxinat-blau", "Econa-Konzentrat", "Blue Kleen", "Holstador", "Blitz Citro",
            "Superalosol", "Forex", "Profless-Konzentrat", "ISO-Klarglanz", "Schirocco clean", "Expressreiniger",
            "Premium No 3"
    };

    private final String[] kategorien = {
            "Unterhaltsreiniger", "Universalreiniger", "Parkett- und Laminatreiniger",
            "Unterhaltsreiniger", "Universalreiniger", "Unterhaltsreiniger", "Universalreiniger", "Unterhaltsreiniger",
            "Allround-Reiniger", "Allzweckreiniger", "A 315 Alkoholduftreiniger", "neutraler Allesreiniger",
            "Neutralreiniger", "Boden-Intensivreiniger", "Oberflächenreiniger", "Alkoholreiniger",
            "Intensiv-Bodenschnellreiniger", "Allzweckreiniger", "Mehrzweckreiniger", "Universalreiniger"
    };

    private final String[] hersteller = {
            "KIEHL", "Dr. Schnell", "KIEHL", "Linker", "Dr. Schnell", "KIEHL", "KIEHL",
            "KIEHL", "Linker", "KIEHL", "Kleen Purgatis", "Holste Profi", "Buzil", "Linker", "Dr. Schnell", "KIEHL",
            "Linker", "Dr. Schnell", "Linker", "Kleen Purgatis"
    };

    private final String[] eanNummern = {
            "4031255000152", "4008439001144", "4031255023892", "", "4008439001731", "4031255026930",
            "4031255003382", "4031255000237", "", "4031255032542", "4250224500831", "4000401315105", "4100660005103",
            "", "4008439302531", "4031255002897", "", "4008439007245", "", "4250224501265"
    };

    private final BigDecimal[] gewichte = {
            new BigDecimal("1.00"), new BigDecimal("1.00"), new BigDecimal("1.00"),
            new BigDecimal("11.00"), new BigDecimal("1.00"), new BigDecimal("1.00"), new BigDecimal("1.00"),
            new BigDecimal("10.00"), new BigDecimal("10.00"), new BigDecimal("1.00"), new BigDecimal("1.00"),
            new BigDecimal("1.00"), new BigDecimal("10.00"), new BigDecimal("11.00"), new BigDecimal("1.00"),
            new BigDecimal("1.00"), new BigDecimal("1.00"), new BigDecimal("10.00"), new BigDecimal("10.00"),
            new BigDecimal("1.00")
    };

    private final String[] lagerOrte = {
            "A-01-01", "A-02-01", "A-03-01", "B-01-02", "B-02-02", "B-03-02", "C-01-03",
            "C-02-03", "C-03-03", "D-01-04", "D-02-04", "D-03-04", "E-01-05", "E-02-05", "E-03-05", "F-01-06",
            "F-02-06", "F-03-06", "G-01-07", "G-02-07"
    };

    private final LocalDate[] haltbarkeitsDaten = {
            LocalDate.of(2030, 4, 1), LocalDate.of(2030, 3, 30), LocalDate.of(2030, 3, 26),
            LocalDate.of(2030, 3, 31), LocalDate.of(2030, 3, 28), LocalDate.of(2030, 2, 15), LocalDate.of(2030, 1, 12),
            LocalDate.of(2029, 12, 20), LocalDate.of(2029, 12, 5), LocalDate.of(2029, 11, 15),
            LocalDate.of(2029, 10, 22), LocalDate.of(2029, 11, 10), LocalDate.of(2030, 1, 18), LocalDate.of(2030, 2, 7),
            LocalDate.of(2030, 2, 25), LocalDate.of(2030, 3, 5), LocalDate.of(2029, 10, 19), LocalDate.of(2030, 1, 11),
            LocalDate.of(2030, 3, 8), LocalDate.of(2030, 2, 20)
    };

    private final Integer[] aktuelleBestaende = {
            800, 1200, 500, 1100, 700, 680, 900, 1200, 850, 1600, 1300, 890, 600, 900,
            950, 1150, 700, 900, 1200, 980
    };

    private final Integer[] mindestBestaende = {
            866, 593, 400, 1200, 800, 766, 666, 580, 800, 653, 866, 593, 700, 600, 1000,
            766, 800, 780, 1300, 653
    };

    private final Integer[] meldeBestaende = {
            833, 896, 450, 1150, 750, 723, 783, 890, 825, 1126, 1083, 742, 650, 750, 975,
            958, 683, 885, 1250, 816
    };

//  private final boolean[] lagerKritisch = {
//          true, false, false, true, true, true, false, false, false, false, false,
//          false, false, false, true, false, true, false, true, false
//    };

    private final Integer[] maxLieferZeiten = {
            4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4
    };

    private final BigDecimal[] einkaufsPreise = {
            new BigDecimal("4.55"), new BigDecimal("3.24"), new BigDecimal("4.24"),
            new BigDecimal("14.65"), new BigDecimal("2.97"), new BigDecimal("2.44"), new BigDecimal("4.09"),
            new BigDecimal("43.43"), new BigDecimal("16.53"), new BigDecimal("3.98"), new BigDecimal("3.59"),
            new BigDecimal("2.68"), new BigDecimal("24.25"), new BigDecimal("17.93"), new BigDecimal("9.89"),
            new BigDecimal("9.67"), new BigDecimal("1.94"), new BigDecimal("6.13"), new BigDecimal("17.23"),
            new BigDecimal("14.65")
    };

    private final BigDecimal[] verkaufsPreise = {
            new BigDecimal("7.55"), new BigDecimal("5.37"), new BigDecimal("7.03"),
            new BigDecimal("24.42"), new BigDecimal("4.95"), new BigDecimal("4.07"), new BigDecimal("6.82"),
            new BigDecimal("72.39"), new BigDecimal("27.55"), new BigDecimal("6.63"), new BigDecimal("5.99"),
            new BigDecimal("4.46"), new BigDecimal("40.42"), new BigDecimal("29.89"), new BigDecimal("16.48"),
            new BigDecimal("16.11"), new BigDecimal("3.24"), new BigDecimal("10.22"), new BigDecimal("28.71"),
            new BigDecimal("39.37")
    };

    private final LocalDate[] letzteEinkaufsDaten = {
            LocalDate.of(2025, 4, 1), LocalDate.of(2025, 3, 30),
            LocalDate.of(2025, 3, 26), LocalDate.of(2025, 3, 31), LocalDate.of(2025, 3, 28),
            LocalDate.of(2025, 2, 15), LocalDate.of(2025, 1, 12), LocalDate.of(2024, 12, 20),
            LocalDate.of(2024, 12, 5), LocalDate.of(2024, 11, 15), LocalDate.of(2024, 10, 22),
            LocalDate.of(2024, 11, 10), LocalDate.of(2025, 1, 18), LocalDate.of(2025, 2, 7),
            LocalDate.of(2025, 2, 25), LocalDate.of(2025, 3, 5), LocalDate.of(2024, 10, 19),
            LocalDate.of(2025, 1, 11), LocalDate.of(2025, 3, 8), LocalDate.of(2025, 2, 20)
    };

    private final LocalDate[] letzteInventurDaten = new LocalDate[20];

    {
        LocalDate inventurDatum = LocalDate.of(2024, 12, 31);
        Arrays.fill(letzteInventurDaten, inventurDatum);
    }

    /**
     * Erstellt eine bestimmte Anzahl von Bodenreiniger-Objekten.
     *
     * @param anzahl Die Anzahl der zu erstellenden Bodenreiniger-Objekte. Wenn 0 oder negativ,
     *              werden stattdessen drei Standard-Bodenreiniger erstellt.
     */
    public BodenreinigerMacher(int anzahl) {
        if (anzahl <= 0) {
            erstelleStandardBodenreiniger();
        } else {
            erstelleZufaelligeBodenreiniger(anzahl);
        }
    }

    /**
     * Standardkonstruktor, der Bodenreiniger-Objekte erstellt, bis ein Duplikat gefunden wird.
     * Verwendet ein Vergleichsobjekt, um zu erkennen, wann ein Duplikat generiert wurde.
     */
    public BodenreinigerMacher() {
        Bodenreiniger vergleichsObjekt = new Bodenreiniger();
        Random rand = new Random();

        while (true) {
            Bodenreiniger neuerBodenreiniger = erzeugeZufaelligenBodenreiniger(rand);
            alleBodenreiniger.add(neuerBodenreiniger);

            if (vergleichsObjekt.equals(alleBodenreiniger.get(alleBodenreiniger.size() - 1))) {
                break;
            }
        }
    }

    /**
     * Erstellt drei vordefinierte Standard-Bodenreiniger-Objekte.
     */
    private void erstelleStandardBodenreiniger() {
        alleBodenreiniger.add(new Bodenreiniger(
            "Standard-Reiniger-1", "Unterhaltsreiniger", "Standard GmbH",
            "1234567890123", new BigDecimal("1.00"), "A-00-00",
            500, 300, 400, 3,
            LocalDate.of(2030, 1, 1),
            new BigDecimal("5.99"), new BigDecimal("9.99"),
            LocalDate.of(2025, 1, 1), LocalDate.of(2024, 12, 31)));

        alleBodenreiniger.add(new Bodenreiniger(
            "Standard-Reiniger-2", "Universalreiniger", "Standard GmbH",
            "2345678901234", new BigDecimal("1.50"), "A-00-01",
            600, 400, 500, 3,
            LocalDate.of(2030, 2, 1),
            new BigDecimal("6.99"), new BigDecimal("10.99"),
            LocalDate.of(2025, 1, 15), LocalDate.of(2024, 12, 31)));

        alleBodenreiniger.add(new Bodenreiniger(
            "Standard-Reiniger-3", "Allzweckreiniger", "Standard GmbH",
            "3456789012345", new BigDecimal("2.00"), "A-00-02",
            700, 500, 600, 3,
            LocalDate.of(2030, 3, 1),
            new BigDecimal("7.99"), new BigDecimal("11.99"),
            LocalDate.of(2025, 1, 30), LocalDate.of(2024, 12, 31)));
    }


    /**
     * Erstellt eine bestimmte Anzahl zufällig generierter Bodenreiniger-Objekte.
     *
     * @param anzahl Die Anzahl der zu erstellenden Bodenreiniger-Objekte.
     */
    private void erstelleZufaelligeBodenreiniger(int anzahl) {
        Random rand = new Random();
        for (int i = 0; i < anzahl; i++) {
            Bodenreiniger neuerBodenreiniger = erzeugeZufaelligenBodenreiniger(rand);
            alleBodenreiniger.add(neuerBodenreiniger);
        }
    }
    
    /**
     * Erstellt ein einzelnes zufälliges Bodenreiniger-Objekt mit dem bereitgestellten Zufallsgenerator.
     * 
     * @param rand Zufallszahlengenerator
     * @return Ein neues, zufällig generiertes Bodenreiniger-Objekt
     */
    private Bodenreiniger erzeugeZufaelligenBodenreiniger(Random rand) {
        String name = produktNamen[rand.nextInt(produktNamen.length)];
        String kategorie = kategorien[rand.nextInt(kategorien.length)];
        String herst = hersteller[rand.nextInt(hersteller.length)];
        String barcode = eanNummern[rand.nextInt(eanNummern.length)];
        BigDecimal gewicht = gewichte[rand.nextInt(gewichte.length)];
        String lagerplatz = lagerOrte[rand.nextInt(lagerOrte.length)];
        LocalDate haltbarkeit = haltbarkeitsDaten[rand.nextInt(haltbarkeitsDaten.length)];
        Integer bestand = aktuelleBestaende[rand.nextInt(aktuelleBestaende.length)];
        Integer mindestBestand = mindestBestaende[rand.nextInt(mindestBestaende.length)];
        Integer meldeBestand = meldeBestaende[rand.nextInt(meldeBestaende.length)];
        Integer lieferzeit = maxLieferZeiten[rand.nextInt(maxLieferZeiten.length)];
        BigDecimal einkauf = einkaufsPreise[rand.nextInt(einkaufsPreise.length)];
        BigDecimal verkauf = verkaufsPreise[rand.nextInt(verkaufsPreise.length)];
        LocalDate einkaufsDatum = letzteEinkaufsDaten[rand.nextInt(letzteEinkaufsDaten.length)];
        LocalDate inventur = letzteInventurDaten[rand.nextInt(letzteInventurDaten.length)];

        return new Bodenreiniger(
            name, kategorie, herst, barcode, gewicht, lagerplatz,
            bestand, mindestBestand, meldeBestand, lieferzeit,
            haltbarkeit, einkauf, verkauf, einkaufsDatum, inventur);
    }


    /**
     * Gibt die Liste aller von dieser Instanz verwalteten Bodenreiniger-Objekte zurück.
     *
     * @return Eine unveränderliche Liste aller Bodenreiniger-Objekte
     */
    public List<Bodenreiniger> getAlleBodenreiniger() {
        return new ArrayList<>(alleBodenreiniger);
    }
}
