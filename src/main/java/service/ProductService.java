package service;

import dao.ProductDao;
import entity.Product;


import java.util.List;
import java.util.Optional;

public class ProductService implements Service<Integer,Product> {
    private ProductDao productDao = ProductDao.getInstance();
    private static ProductService INSTANCE = new ProductService();

    private ProductService() {

    }

    public static ProductService getInstance() {
        return INSTANCE;
    }

    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public Optional<Product> get(Integer integer) {
        return productDao.get(integer);
    }

    @Override
    public Optional<Product> delete(Integer integer) {
        return productDao.delete(integer);
    }

    @Override
    public Optional<Product> update(Product product) {
        return productDao.update(product);
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

}
