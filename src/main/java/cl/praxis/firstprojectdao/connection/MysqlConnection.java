package cl.praxis.firstprojectdao.connection;

import java.sql.Connection;

public class Conexion {

    private static Conexion instance;
    private Connection connection;
    private String jdbcURL ="jdbc:mysql://localhost:3306/demo_dao";
    private String jdbcUsername = "root";
    private String jdbcPassword = "DB14!";
}
