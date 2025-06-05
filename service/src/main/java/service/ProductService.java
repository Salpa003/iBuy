package service;

import dao.ProductDao;
import entity.Product;

import java.security.Key;
import java.util.List;
import java.util.Optional;

public class ProductService implements Service<Integer, Product> {
    private static final ProductService INSTANCE = new ProductService();
    private static final ProductDao productDao = ProductDao.getInstance();

    private ProductService() {

    }

    public static ProductService getInstance() {
        return INSTANCE;
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public Optional<Product> get(Integer id) {
        return productDao.get(id);
    }

    @Override
    public Optional<Integer> save(Product product) {
        return productDao.save(product);
    }

    @Override
    public Optional<Product> delete(Integer id) {
        return productDao.delete(id);
    }

    @Override
    public void update(Product product) {
        productDao.update(product);
    }

    public List<Product> getAllByUser(Integer userId) {
        return productDao.getAllByUser(userId);
    }
}
