package app.cleanmate.model;

/**
 * Ausnahme für Primärschlüssel-bezogene Fehler in der Datenverwaltung.
 * 
 * Diese benutzerdefinierte Ausnahme signalisiert Probleme mit Primärschlüsseln,
 * wie Duplikate, fehlende oder ungültige Schlüssel in der Datenbank oder
 * anderen Speichersystemen.
 * 
 * @author mboudni
 * @version 2.0
 * @since 2025-03-31
 */
public class PrimaerSchluesselException extends RuntimeException {

    /**
     * Wird zur Serialisierung verwendet und vermeidet Warnungen bezüglich der
     * fehlenden serialVersionUID für serialisierbare Klassen.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Erstellt eine neue PrimaerSchluesselException mit einer detaillierten Fehlermeldung.
     * 
     * @param nachricht Die Beschreibung des Fehlers, der diese Ausnahme verursacht hat
     */
    public PrimaerSchluesselException(String nachricht) {
        super(nachricht);
    }
    
    /**
     * Erstellt eine neue PrimaerSchluesselException mit einer Fehlermeldung und
     * der ursprünglichen Ausnahme.
     * 
     * @param nachricht Die Beschreibung des Fehlers
     * @param ursache Die ursprüngliche Ausnahme, die diesen Fehler verursacht hat
     */
    public PrimaerSchluesselException(String nachricht, Throwable ursache) {
        super(nachricht, ursache);
    }
}