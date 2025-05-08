package dao;

import entity.Product;
import entity.Seller;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDao implements Dao<Integer, Product> {
    private static ProductDao INSTANCE = new ProductDao();

    private ProductDao() {

    }

    public static ProductDao getInstance() {
        return INSTANCE;
    }

    private final String GET_ALL_SQL = """
           SELECT id,name,description,price,count,seller
           FROM ibuy.product
            """;
    private final String SAVE_SQL = """
             INSERT INTO ibuy.product (name, description,count, price, seller)
             VALUES (?,?,?,?,?);
            """;
    private final String DELETE_SQL = """
            DELETE FROM ibuy.product
            WHERE id = ? 
            RETURNING id,name,description,count,price,seller;
            """;

    private final String GET_BY_ID_SQL = GET_ALL_SQL + " WHERE id = ?;";
    private final String UPDATE_SQL = """
            
            """;


    @Override
    public List<Product> getAll() {
       List<Product> list = new ArrayList<>();
       try (Connection connection = ConnectionManager.open();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_SQL)) {
           ResultSet resultSet = preparedStatement.executeQuery();
           while (resultSet.next()) {
               list.add(new Product(
                       resultSet.getInt("id"),
                       resultSet.getString("name"),
                       resultSet.getString("description"),
                       resultSet.getDouble("price"),
                       resultSet.getInt("count"),
                        resultSet.getString("seller")
               ));
           }
       } catch (SQLException e) {
            throw new RuntimeException(e);
       }
       return list;
    }

    @Override
    public Optional<Product> get(Integer id) {
        Product product = null;
        try (Connection connection = ConnectionManager.open();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID_SQL)) {
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            product = new Product(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("description"),
                    resultSet.getDouble("price"),
                    resultSet.getInt("count"),
                    resultSet.getString("seller")
            );
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(product);
    }

    @Override
    public Optional<Product> delete(Integer id) {
       Product product = null;
       try (Connection connection = ConnectionManager.open();
       PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)) {
           preparedStatement.setInt(1,id);
           ResultSet resultSet = preparedStatement.executeQuery();
           if (resultSet.next()) {
               product = new Product(
                       resultSet.getInt("id"),
                       resultSet.getString("name"),
                       resultSet.getString("description"),
                       resultSet.getDouble("price"),
                       resultSet.getInt("count"),
                       resultSet.getString("seller")
               );
           }
       } catch (SQLException e) {
           throw new RuntimeException();
       }
       return Optional.ofNullable(product);
    }

    @Override
    public  Optional<Product> update(Product product) {
        return null;
    }

    @Override
    public void save(Product product) {
        try(Connection connection = ConnectionManager.open();
        PreparedStatement preparedStatement = connection.prepareStatement(SAVE_SQL)) {
            preparedStatement.setString(1,product.getName());
            preparedStatement.setString(2,product.getDescription());
            preparedStatement.setInt(3,product.getCount());
            preparedStatement.setDouble(4,product.getPrice());
            preparedStatement.setString(5,product.getSeller());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Seller getSeller(Integer id) {
        Optional<Seller> optional = SellerDao.getInstance().get(id);
        if (optional.isPresent())
            return optional.get();
        else
            throw new RuntimeException();
    }
}
