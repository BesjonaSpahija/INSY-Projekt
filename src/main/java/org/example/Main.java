package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
//Besjona Spahija
//5B
//Insy Projekt
//In diesem Code sortiere ich die Bücher in meiner Datenbank nach dem Namen
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Verbindungsdaten für die PostgreSQL-Datenbank
        String url = "jdbc:postgresql://aws-0-eu-central-1.pooler.supabase.com:5432/postgres";
        String user = "postgres.hfuseoevogpgegcavina";
        String password = "1N$YPr0jektBe$jona";

        try {
            // Verbindung zur Datenbank herstellen
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();

            // das ist eine Abfrage, die Informationen aus der Tabelle Bücher in meiner Datenbank auswählt
            // Sortiert die Ergebnisse alphabetisch nach dem Titel
            String query = "SELECT title, description, published_at, author_uuid FROM books ORDER BY title";
            //führt die SQL-Abfrage aus und das Ergebnis der Abfrage wird in einem ResultSet gespeichert.
            ResultSet resultSet = statement.executeQuery(query);

            // Ausgabe der Ergebnisse
            System.out.println("Books sorted by Title:");
            while (resultSet.next()) {
                // Werte aus der aktuellen Zeile des ResultSets abrufen
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                String publishedAt = resultSet.getString("published_at");
                String authorUuid = resultSet.getString("author_uuid");

                // Ausgabe der Buchinformationen
                System.out.println("Title: " + title);
                System.out.println("Description: " + description);
                System.out.println("Published At: " + publishedAt);
                System.out.println("Author UUID: " + authorUuid);
                System.out.println("----------------------------");
            }

            // Ressourcen schließen
            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}