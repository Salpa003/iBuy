package dao;

import java.util.List;
import java.util.Optional;

public interface Dao<K,E> { //Key Entity
    List<E> getAll();

    Optional<E> get(K k);

    void save(E e);

    boolean delete(K k);

    boolean update(E e);

}
