package dao;

import entity.Seller;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class SellerDao implements Dao<Integer, Seller> {
    private static SellerDao INSTANCE = new SellerDao();

    private SellerDao() {

    }
    private final String SAVE_SQL = """
            INSERT INTO ibuy.seller (name)
            VALUES (?);
            """;

    public static SellerDao getInstance() {
        return INSTANCE;
    }

    @Override
    public List<Seller> getAll() {
        return null;
    }

    @Override
    public Optional<Seller> get(Integer integer) {
        return null;
    }

    @Override
    public Optional<Seller> delete(Integer integer) {
        return null;
    }

    @Override
    public Optional<Seller> update(Seller seller) {
        return null;
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
}
