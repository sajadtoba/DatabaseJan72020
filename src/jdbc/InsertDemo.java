package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDemo {
    public static void main(String[] args) throws SQLException {

        String url= "jdbc:mysql://localhost:3306/movies?Timezone=UTC";
        String user = "root";
        String password = "cAt@123";

        //Connection connection = DriverManager.getConnection(url,user,password);
        Connection connection = null;
        Statement statement = null;


        try {
            connection = DriverManager.getConnection(url,user,password);
            statement = connection.createStatement();
            Movie mib = new Movie(15,"RobinS", 2020,"SciFi3","P-12");

            String query= "insert into movie(id,title,release_year,genre,mpaa_rating)" +
                    "values("+mib.getId()+", '"+mib.getTitle()+"', "+mib.getReleaseYear()+", '"+mib.getGenre()+"', '"+mib.getMpaaRating()+"');";

            statement.execute(query);
            System.out.println("Movie added");

        } catch (SQLException ex){
            ex.printStackTrace();
            System.out.println("Something might have went wrong with connection");
        } finally {
            statement.close();
            connection.close();

        }


    }
}
