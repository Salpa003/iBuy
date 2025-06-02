package service;

import dao.UserDao;
import entity.User;
import exception.IncorrectPasswordException;
import exception.UserNotFoundException;
import util.MailManager;

import java.util.List;
import java.util.Optional;

public class UserService implements Service<Integer, User> {
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
        int code = MailManager.sendCode(user.getMail());
        return userDao.save(user, code);
    }

    @Override
    public Optional<User> delete(Integer id) {
        return userDao.delete(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    public Integer login(String name, String password) throws UserNotFoundException, IncorrectPasswordException {
        Optional<User> maybeUser = userDao.getUserByName(name);
        if (maybeUser.isPresent()) {
            User user = maybeUser.get();
            if (user.getPassword().equals(password)) {
                return user.getId();
            } else {
                throw new IncorrectPasswordException("incorrect password");
            }
        } else {
            throw new UserNotFoundException("user not found");
        }
    }

    public boolean activate(int id, int code) {
        return userDao.activate(id,code);
    }
}

