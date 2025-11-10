import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CheckConnection {
    public static void main(String[] args) {



        String url = "jdbc:postgresql://db.dnilleylqukcwlehqbhd.supabase.co:5432/postgres";
        String user = "postgres";
        String password = "watchmensepooch";


        String insert_query = "INSERT INTO entries (name, contact, meet, purpose) VALUES (?, ?, ?, ?);";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to Supabase database!");

            PreparedStatement insert_data = connection.prepareStatement(insert_query);
            insert_data.setString(1, "Anmol");
            insert_data.setString(2, "anmol.com");
            insert_data.setString(3, "CEO");
            insert_data.setString(4, "Discussion");
            int affected = insert_data.executeUpdate();

            if (affected > 0) {
                System.out.println("added");
            } else {
                System.out.println("Failed to add!");
            }

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
