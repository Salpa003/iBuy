package dao;

import entity.User;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<Integer, User> {

    private String GET_ALL_SQL = """
            SELECT id, name, password, email, is_activate, activate_code
            FROM users.users
            """;

    private String GET_SQL = GET_ALL_SQL + " WHERE id = ? ;";

    private String SAVE_SQL = """
            INSERT INTO users.users (name, password, email, activate_code, is_activate)
            VALUES (?,?,?,?,?);
            """;

    private String DELETE_SQL = """
            DELETE FROM users.users
            WHERE id = ?
            RETURNING id, name, password, email, is_activate, activate_code;
            """;

    private String UPDATE_SQL = """
            UPDATE users.users
            SET name = ?, password = ?, email = ?, is_activate = ?, activate_code = ?
            WHERE id = ?;
            """;


    private static final UserDao INSTANTS = new UserDao();

    private UserDao() {

    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                users.add(ResulSetToEntity(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

    @Override
    public Optional<User> get(Integer id) {
        User user = null;
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = ResulSetToEntity(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(user);
    }

    @Override
    public void save(User user) {
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getMail());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<User> delete(Integer id) {
        User user = null;
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                user = ResulSetToEntity(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(user);
    }

    @Override
    public void update(User user) {
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getMail());
            preparedStatement.setInt(6, user.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static UserDao getInstance() {
        return INSTANTS;
    }

    private User ResulSetToEntity(ResultSet resultSet) throws SQLException {
        return new User(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("password"),
                resultSet.getString("email")
        );
    }
}
