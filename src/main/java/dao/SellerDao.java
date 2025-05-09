package dao;

import entity.Seller;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SellerDao implements Dao<Integer, Seller> {
    private static SellerDao INSTANCE = new SellerDao();

    private SellerDao() {

    }
    private final String GET_ALL_SQL = """
            SELECT id,name
            FROM ibuy.seller
            """;
    private final String SAVE_SQL = """
            INSERT INTO ibuy.seller (name)
            VALUES (?);
            """;
    private final String DELETE_SQL = """
            DELETE FROM ibuy.seller
            WHERE id = ? 
            RETURNING id,name;       
            """;
    private final String UPRATE_SQL = """
            UPDATE ibuy.seller
            SET name = ?
            WHERE id = ?
            RETURNING id,name;
            """;

    private final String GET_BY_ID_SQL = GET_ALL_SQL + " WHERE id = ?;";

    public static SellerDao getInstance() {
        return INSTANCE;
    }

    @Override
    public List<Seller> getAll() {
        List<Seller> list = new ArrayList<>();
        try (Connection connection = ConnectionManager.open();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(ResultSetToEntity(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Optional<Seller> get(Integer id) {
       Seller seller = null;
       try (Connection connection = ConnectionManager.open();
       PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID_SQL)) {
           preparedStatement.setInt(1,id);
           ResultSet resultSet = preparedStatement.executeQuery();
           if (resultSet.next()) {
               seller = ResultSetToEntity(resultSet);
           }
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
       return Optional.ofNullable(seller);
    }

    @Override
    public Optional<Seller> delete(Integer id) {
        Seller seller = null;
        try (Connection connection = ConnectionManager.open();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
               seller = ResultSetToEntity(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(seller);
    }

    @Override
    public Optional<Seller> update(Seller seller) {
        Seller newSeller = null;
        try (Connection connection = ConnectionManager.open();
        PreparedStatement preparedStatement = connection.prepareStatement(UPRATE_SQL)) {
            preparedStatement.setString(1,seller.getName());
            preparedStatement.setInt(2, seller.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                newSeller = ResultSetToEntity(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(newSeller);
    }

    @Override
    public void save(Seller seller) {
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_SQL)) {
            preparedStatement.setString(1,seller.getName());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Seller ResultSetToEntity(ResultSet resultSet) throws SQLException {
        return new Seller(
                resultSet.getInt("id"),
                resultSet.getString("name")
        );
    }


}