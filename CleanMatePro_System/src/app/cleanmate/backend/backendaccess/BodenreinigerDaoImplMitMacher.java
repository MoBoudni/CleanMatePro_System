package app.cleanmate.backend.backendaccess;

import java.util.ArrayList;
import java.util.List;
import app.cleanmate.backend.BodenreinigerMacher;
import app.cleanmate.model.Bodenreiniger;

/**
 * Implementierung des BodenreinigerDao-Interfaces mit einem BodenreinigerMacher.
 * Simuliert persistente Datenhaltung durch die Verwendung eines Objektgenerators.
 */
public class BodenreinigerDaoImplMitMacher implements BodenreinigerDao {
    
    /** Datenhaltungsschicht für Bodenreiniger-Objekte */
    private final BodenreinigerMacher datenhaltung;
    
    /**
     * Standardkonstruktor, der einen BodenreinigerMacher mit Standardeinstellungen initialisiert.
     */
    public BodenreinigerDaoImplMitMacher() {
        this.datenhaltung = new BodenreinigerMacher();
    }
    
    /**
     * Konstruktor mit Angabe der Anfangsanzahl von Bodenreiniger-Objekten.
     * 
     * @param anzahl Die Anzahl der initial zu erstellenden Bodenreiniger-Objekte
     */
    public BodenreinigerDaoImplMitMacher(int anzahl) {
        this.datenhaltung = new BodenreinigerMacher(anzahl);
    }
    
    /**
     * Erstellt eine Kopie der aktuellen Bodenreiniger-Liste aus der Datenhaltung.
     * Es werden keine neuen Bodenreiniger-Objekte erzeugt, sondern nur eine neue Liste
     * mit Referenzen auf die bestehenden Objekte.
     *
     * @return Eine neue Liste mit allen Bodenreiniger-Objekten
     */
    @Override
    public List<Bodenreiniger> getAllBodenreiniger() {
        return new ArrayList<>(datenhaltung.getAlleBodenreiniger());
    }
    
    /**
     * Fügt ein Bodenreiniger-Objekt zur Datenhaltung hinzu.
     *
     * @param bodenreiniger Das hinzuzufügende Bodenreiniger-Objekt
     */
    @Override
    public void addBodenreiniger(Bodenreiniger bodenreiniger) {
        datenhaltung.getAlleBodenreiniger().add(bodenreiniger);
    }
    
    /**
     * Entfernt ein Bodenreiniger-Objekt aus der Datenhaltung.
     * Das erste Objekt, das dem übergebenen Bodenreiniger entspricht, wird entfernt.
     *
     * @param bodenreiniger Das zu löschende Bodenreiniger-Objekt
     */
    @Override
    public void deleteBodenreiniger(Bodenreiniger bodenreiniger) {
        // TODO: Implementierung zum Entfernen eines Bodenreinigers aus der Liste
    }
    
    /**
     * Aktualisiert ein bestehendes Bodenreiniger-Objekt in der Datenhaltung.
     * Da wir mit direkten Objektreferenzen arbeiten, ist diese Operation möglicherweise
     * nicht notwendig, wenn die Objekte bereits aktualisiert wurden.
     *
     * @param bodenreiniger Das zu aktualisierende Bodenreiniger-Objekt
     */
    @Override
    public void updateBodenreiniger(Bodenreiniger bodenreiniger) {
        // TODO: Implementierung zum Aktualisieren eines Bodenreinigers in der Liste
    }
    
    /**
     * Liest ein spezifisches Bodenreiniger-Objekt aus der Datenhaltung und aktualisiert
     * gegebenenfalls das übergebene Objekt mit den gefundenen Daten.
     *
     * @param bodenreiniger Bodenreiniger-Objekt mit Suchkriterien
     */
    @Override
    public void readBodenreiniger(Bodenreiniger bodenreiniger) {
        // TODO: Implementierung zum Lesen eines spezifischen Bodenreinigers aus der Liste
    }
}