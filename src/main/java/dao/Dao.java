package dao;

import java.util.List;

public interface Dao<K, E> { // Key Entity

    List<E> getAll();

    E get(K k);

    E delete(K k);

    E update(E e);

    void save(E e);
}
