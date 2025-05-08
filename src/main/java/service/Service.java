package service;

import java.util.List;

public interface Service<K,E> {
    List<E> getAll();

    E get(K k);

    E delete(K k);

    E update(E e);

    void save(E e);
}
