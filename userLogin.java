import java.sql.*;
public class userLogin {
    public user checkLogin(String email, String password) throws SQLException, ClassNotFoundException {
        String jdbcURL = "jdbc:mysql://localhost:3306/jailsystem?servletTimezone=UTC";
        String dbUser = "root";
        String dbPassword = "";

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        //getting the connection
        String sql = "SELECT * FROM login WHERE email = ? and password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, password);

        ResultSet rs = statement.executeQuery();
        //using ResultSet to run through the values as a pointer.

        user user = null;

        if (rs.next()) {
            user = new user();
            user.setName(rs.getString("name"));
            user.setEmail(email);
        }

        connection.close();

        return user;

    }
}
