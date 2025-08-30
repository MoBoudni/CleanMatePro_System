package app.cleanmate.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Repräsentiert ein Bodenreiniger-Produkt im Lagerverwaltungssystem.
 * 
 * Diese Klasse modelliert alle relevanten Eigenschaften und Verwaltungsinformationen
 * für Bodenreiniger im Rahmen eines Warenwirtschaftssystems. 
 * 
 * @author mboudni
 * @version 2.0
 * @since 2025-05-17
 */
public class Bodenreiniger {
	
	// Produktidentifikation
	private String artikelID;
    private String produktName;
    private String kategorie;
    private String hersteller;
    private String ean;
    
    // Physische Eigenschaften
    private BigDecimal gewicht;  // in KG
    
    // Lagerinformationen
    private String lagerOrt;
    private LocalDate haltbarkeitsDatum;
    private int aktuellerBestand;
    private int mindestBestand;
    private int meldeBestand;
    private boolean lagerKritisch;
    private int maxLieferZeit;  // in Tagen
    
    // Finanzielle Informationen
    private BigDecimal einkaufsPreis;  // in EUR
    private BigDecimal verkaufsPreis;  // in EUR
    
    // Chronologische Informationen
    private LocalDate letzterEinkauf;
    private LocalDate letzteInventur;
    
    // Standard-Datumsformat
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    
    /**
     * Erzeugt einen Bodenreiniger mit Standardwerten.
     * 
     * Initialisiert ein Beispiel-Bodenreiniger-Produkt mit vordefinierten Werten,
     * die als Referenz oder für Testzwecke genutzt werden können.
     */
    public Bodenreiniger() {
        this.produktName = "Torvan-Konzentrat";
        this.kategorie = "Unterhaltsreiniger";
        this.hersteller = "KIEHL";
        this.ean = "4031255000152";
        this.gewicht = new BigDecimal("1").setScale(3, RoundingMode.HALF_UP);
        this.lagerOrt = "A-01-01";
        this.haltbarkeitsDatum = LocalDate.parse("01.04.2030", DATE_FORMATTER);
        this.aktuellerBestand = 800;
        this.mindestBestand = 866;
        this.meldeBestand = 833;
        this.maxLieferZeit = 4;
        this.einkaufsPreis = new BigDecimal("4.55").setScale(2, RoundingMode.HALF_UP);
        this.verkaufsPreis = new BigDecimal("7.55").setScale(2, RoundingMode.HALF_UP);
        this.letzterEinkauf = LocalDate.parse("01.04.2025", DATE_FORMATTER);
        this.letzteInventur = LocalDate.parse("31.12.2024", DATE_FORMATTER);
        
        aktualisiereBestandsstatus();
    }

    /**
     * Erzeugt einen Bodenreiniger mit benutzerdefinierten Werten.
     * 
     * @param produktName     Name des Produkts
     * @param kategorie       Produktkategorie
     * @param hersteller      Herstellername
     * @param ean             European Article Number (eindeutiger Produktcode)
     * @param gewicht         Gewicht in kg
     * @param lagerOrt        Position im Lager (z.B. Regal-Koordinaten)
     * @param aktuellerBestand Aktuell verfügbare Menge
     * @param mindestBestand  Minimale Menge, die vorrätig sein sollte
     * @param meldeBestand    Menge, bei der eine Nachbestellung ausgelöst wird
     * @param maxLieferZeit   Maximale Lieferzeit in Tagen
     * @param haltbarkeitsDatum Ablaufdatum des Produkts
     * @param einkaufsPreis   Einkaufspreis in EUR
     * @param verkaufsPreis   Verkaufspreis in EUR
     * @param letzterEinkauf  Datum des letzten Einkaufs
     * @param letzteInventur  Datum der letzten Bestandsaufnahme
     */
    public Bodenreiniger(String produktName, String kategorie, String hersteller, String ean, 
                        BigDecimal gewicht, String lagerOrt, int aktuellerBestand, 
                        int mindestBestand, int meldeBestand, int maxLieferZeit, 
                        LocalDate haltbarkeitsDatum, BigDecimal einkaufsPreis, 
                        BigDecimal verkaufsPreis, LocalDate letzterEinkauf, 
                        LocalDate letzteInventur) {
        this.produktName = produktName;
        this.kategorie = kategorie;
        this.hersteller = hersteller;
        this.ean = ean;
        this.gewicht = gewicht.setScale(3, RoundingMode.HALF_UP);
        this.lagerOrt = lagerOrt;
        this.aktuellerBestand = aktuellerBestand;
        this.mindestBestand = mindestBestand;
        this.meldeBestand = meldeBestand;
        this.maxLieferZeit = maxLieferZeit;
        this.haltbarkeitsDatum = haltbarkeitsDatum;
        this.einkaufsPreis = einkaufsPreis.setScale(2, RoundingMode.HALF_UP);
        this.verkaufsPreis = verkaufsPreis.setScale(2, RoundingMode.HALF_UP);
        this.letzterEinkauf = letzterEinkauf;
        this.letzteInventur = letzteInventur;
        
        aktualisiereBestandsstatus();
    }
    
    /**
     * Aktualisiert den Lagerstatuswert basierend auf dem aktuellen und Mindestbestand.
     * Sollte nach jeder Änderung des Bestands aufgerufen werden.
     */
    private void aktualisiereBestandsstatus() {
        this.lagerKritisch = (this.aktuellerBestand <= this.mindestBestand);
    }

    // Getter und Setter mit Validierung und Seiteneffektbehandlung

    public String getArtikelID() {
        return artikelID;
    }

    public void setArtikelID(String artikelID) {
        this.artikelID = artikelID;
    }

    public String getProduktName() {
        return produktName;
    }

    public void setProduktName(String produktName) {
        this.produktName = produktName;
    }

    public String getKategorie() {
        return kategorie;
    }

    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }

    public String getHersteller() {
        return hersteller;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public BigDecimal getGewicht() {
        return gewicht;
    }

    public void setGewicht(BigDecimal gewicht) {
        this.gewicht = gewicht.setScale(3, RoundingMode.HALF_UP);
    }
    
    public LocalDate getHaltbarkeitsDatum() {
        return haltbarkeitsDatum;
    }
    
    public void setHaltbarkeitsDatum(LocalDate haltbarkeitsDatum) {
        this.haltbarkeitsDatum = haltbarkeitsDatum;
    }

    public String getLagerOrt() {
        return lagerOrt;
    }

    public void setLagerOrt(String lagerOrt) {
        this.lagerOrt = lagerOrt;
    }

    public int getAktuellerBestand() {
        return aktuellerBestand;
    }

    public void setAktuellerBestand(int aktuellerBestand) {
        this.aktuellerBestand = aktuellerBestand;
        aktualisiereBestandsstatus();
    }

    public int getMindestBestand() {
        return mindestBestand;
    }

    public void setMindestBestand(int mindestBestand) {
        this.mindestBestand = mindestBestand;
        aktualisiereBestandsstatus();
    }

    public int getMeldeBestand() {
        return meldeBestand;
    }

    public void setMeldeBestand(int meldeBestand) {
        this.meldeBestand = meldeBestand;
    }
    
    public boolean isLagerKritisch() {
        return lagerKritisch;
    }

    /**
     * Setzt den Lagerstatuswert manuell.
     * In der Regel sollte stattdessen {@link #aktualisiereBestandsstatus()} verwendet werden.
     * 
     * @param lagerKritisch Der zu setzende Status
     */
    public void setLagerKritisch(boolean lagerKritisch) {
        this.lagerKritisch = lagerKritisch;
    }

    public int getMaxLieferZeit() {
        return maxLieferZeit;
    }

    public void setMaxLieferZeit(int maxLieferZeit) {
        this.maxLieferZeit = maxLieferZeit;
    }

    public BigDecimal getEinkaufsPreis() {
        return einkaufsPreis;
    }

    public void setEinkaufsPreis(BigDecimal einkaufsPreis) {
        this.einkaufsPreis = einkaufsPreis.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getVerkaufsPreis() {
        return verkaufsPreis;
    }

    public void setVerkaufsPreis(BigDecimal verkaufsPreis) {
        this.verkaufsPreis = verkaufsPreis.setScale(2, RoundingMode.HALF_UP);
    }

    public LocalDate getLetzterEinkauf() {
        return letzterEinkauf;
    }

    public void setLetzterEinkauf(LocalDate letzterEinkauf) {
        this.letzterEinkauf = letzterEinkauf;
    }

    public LocalDate getLetzteInventur() {
        return letzteInventur;
    }

    public void setLetzteInventur(LocalDate letzteInventur) {
        this.letzteInventur = letzteInventur;
    }

    @Override
    public String toString() {
        return "Bodenreiniger [artikelID=" + artikelID + 
               ", produktName=" + produktName + 
               ", kategorie=" + kategorie +
               ", hersteller=" + hersteller + 
               ", ean=" + ean + 
               ", gewicht=" + gewicht + 
               ", lagerOrt=" + lagerOrt +
               ", haltbarkeitsDatum=" + haltbarkeitsDatum + 
               ", aktuellerBestand=" + aktuellerBestand + 
               ", mindestBestand=" + mindestBestand + 
               ", meldeBestand=" + meldeBestand + 
               ", lagerKritisch=" + lagerKritisch +
               ", maxLieferZeit=" + maxLieferZeit + 
               ", einkaufsPreis=" + einkaufsPreis + 
               ", verkaufsPreis=" + verkaufsPreis +
               ", letzterEinkauf=" + letzterEinkauf + 
               ", letzteInventur=" + letzteInventur + "]";
    }
}

