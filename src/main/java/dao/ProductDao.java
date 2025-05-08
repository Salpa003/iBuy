package dao;

import entity.Product;
import entity.Seller;
import service.SellerService;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements Dao<Integer, Product> {
    private static ProductDao INSTANCE = new ProductDao();

    private ProductDao() {

    }

    public static ProductDao getInstance() {
        return INSTANCE;
    }

    private final String GET_ALL_SQL = """
            SELECT id,name,description,price,count,seller_id
            FROM my_database;
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
                      getSeller(resultSet.getInt("seller_id"))
               ));
           }
       } catch (SQLException e) {

       }
       return list;
    }

    @Override
    public Product get(Integer integer) {
        return null;
    }

    @Override
    public Product delete(Integer integer) {
        return null;
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public void save(Product product) {

    }

    private Seller getSeller(Integer id) {
        return SellerDao.getInstance().get(id);
    }
}
