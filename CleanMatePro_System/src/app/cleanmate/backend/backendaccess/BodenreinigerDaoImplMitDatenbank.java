package app.cleanmate.backend.backendaccess;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import app.cleanmate.model.Bodenreiniger;

/**
 * Implementierung des BodenreinigerDao-Interfaces für den Datenbankzugriff.
 * Ermöglicht CRUD-Operationen auf Bodenreiniger-Objekten in einer
 * MySQL-Datenbank.
 */
public class BodenreinigerDaoImplMitDatenbank implements BodenreinigerDao {

	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/bodenreiniger_db?createDatabaseIfNotExist=true";
	private static final String DATABASE_USER = "root";
	private static final String DATABASE_PASSWORD = "";

	private static final String SQL_SELECT_ALL = "SELECT * FROM Bodenreiniger";
	private static final String SQL_INSERT = "INSERT INTO Bodenreiniger VALUES(NULL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	/**
	 * Ruft alle Bodenreiniger aus der Datenbank ab.
	 *
	 * @return Liste mit allen Bodenreiniger-Objekten
	 */
	@Override
	public List<Bodenreiniger> getAllBodenreiniger() {
		List<Bodenreiniger> reinigerListe = new ArrayList<>();

		try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL)) {

			while (resultSet.next()) {
				Bodenreiniger reiniger = mapResultSetToBodenreiniger(resultSet);
				reinigerListe.add(reiniger);
			}
		} catch (SQLException e) {
			handleDatabaseException("Fehler beim Abrufen aller Bodenreiniger", e);
		}

		return reinigerListe;
	}

	/**
	 * Fügt einen neuen Bodenreiniger zur Datenbank hinzu.
	 *
	 * @param bodenreiniger Der hinzuzufügende Bodenreiniger
	 */
	@Override
	public void addBodenreiniger(Bodenreiniger bodenreiniger) {
		try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT,
						Statement.RETURN_GENERATED_KEYS)) {

			setBodenreinigerParameters(preparedStatement, bodenreiniger);
			preparedStatement.executeUpdate();

			try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					String neueArtikelId = generatedKeys.getString(1);
					bodenreiniger.setArtikelID(neueArtikelId);
				}
			}
		} catch (SQLException e) {
			handleDatabaseException("Fehler beim Hinzufügen eines Bodenreinigers", e);
		}
	}

	/**
	 * Löscht einen Bodenreiniger aus der Datenbank.
	 *
	 * @param bodenreiniger Der zu löschende Bodenreiniger
	 */
	@Override
	public void deleteBodenreiniger(Bodenreiniger bodenreiniger) {
		// TODO: Implementierung zum Löschen eines Bodenreinigers
	}

	/**
	 * Aktualisiert einen Bodenreiniger in der Datenbank.
	 *
	 * @param bodenreiniger Der zu aktualisierende Bodenreiniger
	 */
	@Override
	public void updateBodenreiniger(Bodenreiniger bodenreiniger) {
		// TODO: Implementierung zum Aktualisieren eines Bodenreinigers
	}

	/**
	 * Liest einen spezifischen Bodenreiniger aus der Datenbank.
	 *
	 * @param bodenreiniger Bodenreiniger mit Suchkriterien
	 */
	@Override
	public void readBodenreiniger(Bodenreiniger bodenreiniger) {
		// TODO: Implementierung zum Lesen eines spezifischen Bodenreinigers
	}

	/**
	 * Extrahiert ein Bodenreiniger-Objekt aus einem ResultSet.
	 *
	 * @param resultSet Das ResultSet, aus dem die Daten gelesen werden sollen
	 * @return Ein neues Bodenreiniger-Objekt
	 * @throws SQLException Bei Problemen mit dem Datenbankzugriff
	 */
	private Bodenreiniger mapResultSetToBodenreiniger(ResultSet resultSet) throws SQLException {
		String artikelID = resultSet.getString("ArtikelID");
		String produktName = resultSet.getString("Produktsname");
		String kategorie = resultSet.getString("Kategorie");
		String hersteller = resultSet.getString("Hersteller");
		String ean = resultSet.getString("EAN");
		BigDecimal gewicht = resultSet.getBigDecimal("Gewicht");
		LocalDate haltbarkeitsDatum = resultSet.getDate("Haltbarkeitsdatum").toLocalDate();
		String lagerOrt = resultSet.getString("Lagerort");
		int aktuellerBestand = resultSet.getInt("Aktueller Bestand");
		int mindestBestand = resultSet.getInt("Mindestbestand");
		int meldeBestand = resultSet.getInt("Meldebestand");
//      boolean lagerKritisch = resultSet.getBoolean("Kritische Bestandslager"); // dieser Variable hat keinen Einfluss 
		                                                                         // auf den weiteren Verlauf des Programm
		int maxLieferZeit = resultSet.getInt("Max. Lieferzeit");
		BigDecimal einkaufsPreis = resultSet.getBigDecimal("Einkaufspreis");
		BigDecimal verkaufsPreis = resultSet.getBigDecimal("Verkaufspreis");
		LocalDate letzterEinkauf = resultSet.getDate("Letzter Einkauf").toLocalDate();
		LocalDate letzteInventur = resultSet.getDate("Letzte Inventur").toLocalDate();

		Bodenreiniger bodenreiniger = new Bodenreiniger(produktName, kategorie, hersteller, ean, gewicht, lagerOrt,
				aktuellerBestand, mindestBestand, meldeBestand, maxLieferZeit, haltbarkeitsDatum, einkaufsPreis,
				verkaufsPreis, letzterEinkauf, letzteInventur);

		bodenreiniger.setArtikelID(artikelID);
		return bodenreiniger;
	}

	/**
	 * Setzt die Parameter für ein PreparedStatement auf Basis eines
	 * Bodenreiniger-Objekts.
	 *
	 * @param preparedStatement Das zu befüllende PreparedStatement
	 * @param bodenreiniger     Das Bodenreiniger-Objekt, dessen Daten verwendet
	 *                          werden sollen
	 * @throws SQLException Bei Problemen mit dem Datenbankzugriff
	 */
	private void setBodenreinigerParameters(PreparedStatement preparedStatement, Bodenreiniger bodenreiniger)
			throws SQLException {
		preparedStatement.setString(1, bodenreiniger.getArtikelID());
		preparedStatement.setString(2, bodenreiniger.getProduktName());
		preparedStatement.setString(3, bodenreiniger.getKategorie());
		preparedStatement.setString(4, bodenreiniger.getHersteller());
		preparedStatement.setString(5, bodenreiniger.getEan());
		preparedStatement.setBigDecimal(6, bodenreiniger.getGewicht());
		preparedStatement.setString(7, bodenreiniger.getLagerOrt());
		preparedStatement.setDate(8, java.sql.Date.valueOf(bodenreiniger.getHaltbarkeitsDatum()));
		preparedStatement.setInt(9, bodenreiniger.getAktuellerBestand());
		preparedStatement.setInt(10, bodenreiniger.getMindestBestand());
		preparedStatement.setInt(11, bodenreiniger.getMeldeBestand());
		preparedStatement.setBoolean(12, bodenreiniger.isLagerKritisch());
		preparedStatement.setInt(13, bodenreiniger.getMaxLieferZeit());
		preparedStatement.setBigDecimal(14, bodenreiniger.getEinkaufsPreis());
		preparedStatement.setBigDecimal(15, bodenreiniger.getVerkaufsPreis());
		preparedStatement.setDate(16, java.sql.Date.valueOf(bodenreiniger.getLetzterEinkauf()));
		preparedStatement.setDate(17, java.sql.Date.valueOf(bodenreiniger.getLetzteInventur()));
	}

	/**
	 * Behandelt Datenbankausnahmen einheitlich.
	 *
	 * @param message   Die Fehlermeldung
	 * @param exception Die aufgetretene SQLException
	 */
	private void handleDatabaseException(String message, SQLException exception) {
		// Im Produktionscode könnte hier ein Logger verwendet werden
		System.err.println(message + ": " + exception.getMessage());
		exception.printStackTrace();
	}
}