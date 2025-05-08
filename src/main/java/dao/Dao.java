package dao;

import java.util.List;
import java.util.Optional;

public interface Dao<K, E> { // Key Entity

    List<E> getAll();

    Optional<E> get(K k);

    Optional<E> delete(K k);

    Optional<E> update(E e);

    void save(E e);
}
