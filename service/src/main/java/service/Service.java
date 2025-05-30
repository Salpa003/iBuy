package service;

import java.util.List;
import java.util.Optional;

public interface Service<K,E> {
    List<E> getAll();

    Optional<E> get(K k);

    Optional<K> save(E e);

    Optional<E> delete(K k);

   void update(E e);
}
