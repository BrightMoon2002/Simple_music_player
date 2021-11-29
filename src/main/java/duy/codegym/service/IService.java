package duy.codegym.service;

import duy.codegym.model.Track;

import java.util.List;
import java.util.Optional;

public interface IService<T> {
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    void save (T t);

    void remove(Long id);
}
