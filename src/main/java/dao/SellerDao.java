package dao;

import entity.Seller;
import service.SellerService;

import java.util.List;

public class SellerDao implements Dao<Integer, Seller> {
    private static SellerDao INSTANCE = new SellerDao();

    private SellerDao() {

    }

    public static SellerDao getInstance() {
        return INSTANCE;
    }

    @Override
    public List<Seller> getAll() {
        return null;
    }

    @Override
    public Seller get(Integer integer) {
        return null;
    }

    @Override
    public Seller delete(Integer integer) {
        return null;
    }

    @Override
    public Seller update(Seller seller) {
        return null;
    }

    @Override
    public void save(Seller seller) {

    }
}
