package app.cleanmate.pro;

import java.math.BigDecimal;
import java.time.LocalDate;

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

}
