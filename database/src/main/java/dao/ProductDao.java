package dao;

import entity.Product;

import java.util.List;
import java.util.Optional;

public class ProductDao implements Dao<Integer, Product> {
    private static final ProductDao INSTANCE = new ProductDao();

    private ProductDao() {

    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public Optional<Product> get(Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<Integer> save(Product product) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> delete(Integer id) {
        return Optional.empty();
    }

    @Override
    public void update(Product product) {

    }

    public List<Product> getAllByUser(Integer userId) {
        return null;
    }

    public static ProductDao getInstance() {
        return INSTANCE;
    }
}
