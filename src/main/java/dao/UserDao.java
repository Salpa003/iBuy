package dao;

import entity.User;

import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<Integer, User> {
    public List<User> getAll() {
        return null;
    }

    public Optional<User> get(Integer integer) {
        return Optional.empty();
    }

    public Optional<User> delete(Integer integer) {
        return Optional.empty();
    }

    public Optional<User> update(User user) {
        return Optional.empty();
    }

    public void save(User user) {

    }
}
