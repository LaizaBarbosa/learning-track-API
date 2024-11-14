package com.api.learning_track.service;

import java.util.List;

public interface CrudService<Id, T> {
    
    T findById(Id id);
    List<T> findAll();
    T create(T entity);
    T update(Id id, T entity);
    void delete(Id id);

}
