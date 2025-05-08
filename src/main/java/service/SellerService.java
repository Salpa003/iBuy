package service;

import dao.ProductDao;
import dao.SellerDao;
import entity.Seller;

import java.util.List;
import java.util.Optional;

public class SellerService implements Service<Integer, Seller> {
    SellerDao sellerDao = SellerDao.getInstance();
    private static SellerService INSTANCE = new SellerService();

    private SellerService() {

    }

    public static SellerService getInstance() {
        return INSTANCE;
    }
    @Override
    public List<Seller> getAll() {
        return sellerDao.getAll();
    }

    @Override
    public Optional<Seller> get(Integer integer) {
        return sellerDao.get(integer);
    }

    @Override
    public Optional<Seller> delete(Integer integer) {
        return sellerDao.delete(integer);
    }

    @Override
    public Optional<Seller> update(Seller seller) {
        return sellerDao.update(seller);
    }

    @Override
    public void save(Seller seller) {
        sellerDao.save(seller);
    }
}
