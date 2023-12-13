package utils;

import java.sql.*;

public class JBDCMethods {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://database-1.cb72canasobc.us-east-2.rds.amazonaws.com/loan";
        //jdbc:{driverType}://{urlToDB/schema}
        String username = "duotech";
        String password = "duotech2024";
        //establishes a connectiona nd returns an object that represents an established connection
        Connection connection = DriverManager.getConnection(url, username, password);

        //No suitable driver found for jdbc:mysql://database-1.cb72canasobc.us-east-2.rds.amazonaws.com/duotify2

        System.out.println("Connection established");

        // Create a statement that represent a SQL entry

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE , ResultSet.CONCUR_UPDATABLE);

        //Execute the query and get the result

       ResultSet resultSet = statement.executeQuery("SELECT * FROM tbl_user");

       // Proces te result using resultSet interface method

        resultSet.next();
        String name  = resultSet.getString(2);
        System.out.println(name);
        System.out.println(resultSet.getString("id"));

       // while (resultSet.next()) {
          //  System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
       // }

        resultSet.last();
        int row = resultSet.getRow();
        System.out.println(row);

        //get the number of colums

        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        // get the colunm name
        String columnNameFrst  = metaData.getColumnName(1);
        System.out.println(columnCount);
        System.out.println(columnNameFrst);

        // Close the connection
        resultSet.close();
        statement.close();
        connection.close();


    }
}
