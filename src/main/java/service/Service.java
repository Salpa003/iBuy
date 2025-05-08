package service;

import java.util.List;
import java.util.Optional;

public interface Service<K,E> {
    List<E> getAll();

    Optional<E> get(K k);

    Optional<E> delete(K k);

    Optional<E> update(E e);

    void save(E e);
}
