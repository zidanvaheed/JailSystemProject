package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JailDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public JailDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    //Insertion code

    public boolean insertBook(Jail jail) throws SQLException {
        String sql = "INSERT INTO jailsystem (name, sex, age, address, country, offense, description) VALUES (?, ?, ?, ?, ?, ?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, jail.getName());
        statement.setString(2, jail.getSex());
        statement.setInt(3, jail.getAge());
        statement.setString(4,jail.getAddress());
        statement.setString(5,jail.getCountry());
        statement.setString(6,jail.getOffense());
        statement.setString(7,jail.getDescription());


        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    //Viewing code

    public List<Jail> listAllBooks() throws SQLException {
        List<Jail> listBook = new ArrayList<>();

        String sql = "SELECT * FROM jailsystem";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String sex = resultSet.getString("sex");
            int age = resultSet.getInt("age");
            String address = resultSet.getString("address");
            String country = resultSet.getString("country");
            String offense = resultSet.getString("offense");
            String description = resultSet.getString("description");


            Jail jail = new Jail(id, name, sex, age, address, country, offense, description);
            listBook.add(jail);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listBook;
    }

    //Deletion code

    public boolean deleteBook(Jail jail) throws SQLException {
        String sql = "DELETE FROM jailsystem where id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, jail.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }

    //Updation code

    public boolean updateBook(Jail jail) throws SQLException {
        String sql = "UPDATE jailsystem SET name = ?, sex = ?, age = ?, address = ?, country = ?, offense = ?, description = ?";
        sql += " WHERE id = ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, jail.getName());
        statement.setString(2, jail.getSex());
        statement.setInt(3, jail.getAge());
        statement.setString(4,jail.getAddress());
        statement.setString(5,jail.getCountry());
        statement.setString(6,jail.getOffense());
        statement.setString(7,jail.getDescription());
        statement.setInt(8, jail.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }

    //Viewing based on id

    public Jail getJail(int id) throws SQLException {
        Jail jail = null;
        String sql = "SELECT * FROM jailsystem WHERE id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String sex = resultSet.getString("sex");
            int age = resultSet.getInt("age");
            String address = resultSet.getString("address");
            String country = resultSet.getString("country");
            String offense = resultSet.getString("offense");
            String description = resultSet.getString("description");

            jail = new Jail(id, name, sex, age, address, country, offense, description);
        }

        resultSet.close();
        statement.close();

        return jail;
    }
}
