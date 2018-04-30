package com.epam.jmp.bayanouskaya.task11.repository.api;

public interface CrudRepository<T, ID> {

    void create(T obj);

    T read(ID id);

    void update(T obj);

    void delete(ID id);
}
