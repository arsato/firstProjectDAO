package cl.praxis.firstprojectdao.connection;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
public class MysqlConnection {
    private static MysqlConnection instance;
    private Connection connection;
    private String jdbcURL ="jdbc:mysql://localhost:3306/demo_dao";
    private String jdbcUsername = "root";
    private String jdbcPassword = "DB14!";

    private MysqlConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException(e);
        }
    }

//    public Connection getConnection() {
//        return connection;
//    }

    public static MysqlConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new MysqlConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new MysqlConnection();
        }
        return instance;
    }
}
