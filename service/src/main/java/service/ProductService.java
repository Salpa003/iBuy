package service;

import java.util.List;
import java.util.Optional;

public class ProductService implements Service<Integer, Product> {

    private ProductDao productDao = ProductDao.getInstance();

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
}
