package app.cleanmate.backend.backendaccess;

import java.util.List;
import app.cleanmate.model.Bodenreiniger;

/**
 * JSON-basierte Implementierung des BodenreinigerDao-Interfaces.
 * Ermöglicht die Verwaltung von Bodenreiniger-Objekten in einer JSON-Datenquelle.
 */
public class BodenreinigerDaoImplMitJson implements BodenreinigerDao {
    
    /**
     * Ruft alle Bodenreiniger aus der JSON-Datenquelle ab.
     *
     * @return Liste mit allen Bodenreiniger-Objekten oder null, falls nicht implementiert
     */
    @Override
    public List<Bodenreiniger> getAllBodenreiniger() {
        // TODO: Implementierung zum Abrufen aller Bodenreiniger aus JSON
        return null;
    }
    
    /**
     * Fügt einen neuen Bodenreiniger zur JSON-Datenquelle hinzu.
     *
     * @param bodenreiniger Der hinzuzufügende Bodenreiniger
     */
    @Override
    public void addBodenreiniger(Bodenreiniger bodenreiniger) {
        // TODO: Implementierung zum Hinzufügen eines Bodenreinigers zu JSON
    }
    
    /**
     * Löscht einen Bodenreiniger aus der JSON-Datenquelle.
     *
     * @param bodenreiniger Der zu löschende Bodenreiniger
     */
    @Override
    public void deleteBodenreiniger(Bodenreiniger bodenreiniger) {
        // TODO: Implementierung zum Löschen eines Bodenreinigers aus JSON
    }
    
    /**
     * Aktualisiert einen Bodenreiniger in der JSON-Datenquelle.
     *
     * @param bodenreiniger Der zu aktualisierende Bodenreiniger
     */
    @Override
    public void updateBodenreiniger(Bodenreiniger bodenreiniger) {
        // TODO: Implementierung zum Aktualisieren eines Bodenreinigers in JSON
    }
    
    /**
     * Liest einen spezifischen Bodenreiniger aus der JSON-Datenquelle.
     *
     * @param bodenreiniger Bodenreiniger mit Suchkriterien
     */
    @Override
    public void readBodenreiniger(Bodenreiniger bodenreiniger) {
        // TODO: Implementierung zum Lesen eines spezifischen Bodenreinigers aus JSON
    }
}