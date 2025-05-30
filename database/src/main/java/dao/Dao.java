package dao;

import java.util.List;
import java.util.Optional;

public interface Dao<K,E> { //Key Entity
    List<E> getAll();

    Optional<E> get(K k);

    Optional<K> save(E e);

    Optional<E> delete(K k);

    void update(E e);

}
