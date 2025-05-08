package service;

import dao.ProductDao;
import entity.Product;
import entity.Seller;

import java.util.List;

public class ProductService implements Service<Integer,Product> {
    private ProductDao productDao = ProductDao.getInstance();

    public List<Product> getAll() {
        return productDao.getAll();
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

}
