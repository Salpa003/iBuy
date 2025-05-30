package service;

import dao.UserDao;
import entity.User;

import java.util.List;
import java.util.Optional;

public class UserService  implements Service<Integer,User> {
    private UserDao userDao = UserDao.getInstance();

    private static UserService INSTANCE = new UserService();
    private UserService() {

    }

    public static UserService getInstance() {
        return INSTANCE;
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public Optional<User> get(Integer id) {
        return userDao.get(id);
    }

    @Override
    public Optional<Integer> save(User user) {
       return userDao.save(user);
    }

    @Override
    public Optional<User> delete(Integer id) {
        return userDao.delete(id);
    }

    @Override
    public void update(User user) {
      userDao.update(user);
    }
}

