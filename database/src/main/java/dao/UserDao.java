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
            SELECT id, name, password, email
            FROM users.users
            """;

    private String GET_SQL = GET_ALL_SQL + " WHERE id = ? ;";

    private String SAVE_SQL = """
            INSERT INTO users.users (name, password, email)
            VALUES (?,?,?)
            RETURNING id;
            """;

    private String DELETE_SQL = """
            DELETE FROM users.users
            WHERE id = ?
            RETURNING id, name, password, email;
            """;

    private String UPDATE_SQL = """
            UPDATE users.users
            SET name = ?, password = ?, email = ?
            WHERE id = ?;
            """;

    private String GET_USER_BY_NAME_SQL = """
            SELECT id,name,email,password
            FROM users.users
            WHERE name = ?;
            """;

    private String SAVE_CODE_SQL = """
             INSERT INTO users.users (name, password, email,activate_code)
            VALUES (?,?,?,?)
            RETURNING id;
            """;

    private String GET_CODE_BY_ID = """
            SELECT activate_code
            FROM users.users
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
                users.add(resulSetToEntity(resultSet));
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
                user = resulSetToEntity(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<Integer> save(User user) {
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getMail());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                return Optional.ofNullable(resultSet.getInt("id"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }
    public Optional<Integer> save(User user,int code) {
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_CODE_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getMail());
            preparedStatement.setInt(4,code);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                return Optional.ofNullable(resultSet.getInt("id"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> delete(Integer id) {
        User user = null;
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                user = resulSetToEntity(resultSet);
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

    public Optional<User> getUserByName(String name) {
        User user = null;
        try (Connection connection = ConnectionManager.open();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_NAME_SQL)) {
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = resulSetToEntity(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(user);
    }

    public boolean activate(int id,int code) {
        try (Connection connection = ConnectionManager.open();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_CODE_BY_ID)) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int actualCode = resultSet.getInt("activate_code");
                System.out.println(actualCode + " A");
                if (actualCode == code) {
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            return false;
        }
    }

    public static UserDao getInstance() {
        return INSTANTS;
    }

    private User resulSetToEntity(ResultSet resultSet) throws SQLException {
        return new User(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("password"),
                resultSet.getString("email")
        );
    }

}
