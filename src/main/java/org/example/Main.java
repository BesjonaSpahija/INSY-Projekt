package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://aws-0-eu-central-1.pooler.supabase.com:5432/postgres";
        String user = "postgres.hfuseoevogpgegcavina";
        String password = "1N$YPr0jektBe$jona";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();

            String query = "SELECT title, description, published_at, author_uuid FROM books ORDER BY title";
            ResultSet resultSet = statement.executeQuery(query);

            System.out.println("Books sorted by Title:");
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                String publishedAt = resultSet.getString("published_at");
                String authorUuid = resultSet.getString("author_uuid");

                System.out.println("Title: " + title);
                System.out.println("Description: " + description);
                System.out.println("Published At: " + publishedAt);
                System.out.println("Author UUID: " + authorUuid);
                System.out.println("----------------------------");
            }
            resultSet.close();
            statement.close();

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}