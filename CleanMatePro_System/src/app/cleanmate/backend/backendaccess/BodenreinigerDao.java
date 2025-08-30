package app.cleanmate.backend.backendaccess;

import java.util.List;
import app.cleanmate.model.Bodenreiniger;

/**
 * Data Access Object Interface für Bodenreiniger-Entitäten.
 * Definiert die grundlegenden Datenzugriffsoperationen zur Verwaltung von Bodenreiniger-Objekten.
 */
public interface BodenreinigerDao {
    
    /**
     * Gibt alle verfügbaren Bodenreiniger aus der Datenquelle zurück.
     *
     * @return Liste aller Bodenreiniger-Objekte
     */
    List<Bodenreiniger> getAllBodenreiniger();
    
    /**
     * Fügt ein neues Bodenreiniger-Objekt zur Datenquelle hinzu.
     *
     * @param bodenreiniger Das zu speichernde Bodenreiniger-Objekt
     */
    void addBodenreiniger(Bodenreiniger bodenreiniger);
    
    /**
     * Entfernt ein Bodenreiniger-Objekt aus der Datenquelle.
     *
     * @param bodenreiniger Das zu löschende Bodenreiniger-Objekt
     */
    void deleteBodenreiniger(Bodenreiniger bodenreiniger);
    
    /**
     * Aktualisiert ein bestehendes Bodenreiniger-Objekt in der Datenquelle.
     *
     * @param bodenreiniger Das zu aktualisierende Bodenreiniger-Objekt
     */
    void updateBodenreiniger(Bodenreiniger bodenreiniger);
    
    /**
     * Liest ein spezifisches Bodenreiniger-Objekt aus der Datenquelle.
     *
     * @param bodenreiniger Bodenreiniger-Objekt mit den Suchkriterien
     */
    void readBodenreiniger(Bodenreiniger bodenreiniger);
}