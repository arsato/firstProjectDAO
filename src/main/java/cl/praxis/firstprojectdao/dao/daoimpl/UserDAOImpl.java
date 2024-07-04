package cl.praxis.firstprojectdao.dao.daoimpl;

import cl.praxis.firstprojectdao.connection.MysqlConnection;
import cl.praxis.firstprojectdao.dao.UserDAO;
import cl.praxis.firstprojectdao.model.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private static final String SELECT_ALL_USERS = "SELECT idusuario, nombre, apellido, email, edad FROM usuarios";
    private static final String SELECT_USER_BY_ID = "SELECT idusuario, nombre, apellido, email, edad FROM usuarios WHERE idusuario = ?";
    private static final String INSERT_USER_SQL = "INSERT INTO usuarios (nombre, apellido, email, edad) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_USER_SQL = "UPDATE usuarios SET nombre = ?, apellido = ?, email = ?, edad = ? WHERE idusuario = ?";
    private static final String DELETE_USER_SQL = "DELETE FROM usuarios WHERE idusuario = ?";

    public UserDAOImpl() {

    }

    @Override
    public UserDTO selectUser(int id) {
        UserDTO user = null;
        try (Connection connection = MysqlConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String name = rs.getString("nombre");
                String lastName = rs.getString("apellido");
                String email = rs.getString("email");
                int age = rs.getInt("edad");
                user = new UserDTO(id, name, lastName, email, age);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public List<UserDTO> selectAllUsers() {
        List<UserDTO> users = new ArrayList<>();
        try (Connection connection = MysqlConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idusuario");
                String name = rs.getString("nombre");
                String lastName = rs.getString("apellido");
                String email = rs.getString("email");
                int age = rs.getInt("edad");
                users.add(new UserDTO(id, name, lastName, email, age));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public UserDTO insertUser(UserDTO user) {
        UserDTO newUser = null;
        try (Connection connection = MysqlConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setInt(4, user.getAge());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                newUser = new UserDTO(id, user.getName(), user.getLastName(), user.getEmail(), user.getAge());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return newUser;
    }

    @Override
    public UserDTO updateUser(UserDTO user) {
        try (Connection connection = MysqlConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setInt(4, user.getAge());
            preparedStatement.setInt(5, user.getUserId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public boolean deleteUser(int id) {
        boolean rowDeleted;
        try (Connection connection = MysqlConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_SQL)) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDeleted;
    }
}
