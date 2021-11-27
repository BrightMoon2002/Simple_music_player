package duy.codegym.service;

import duy.codegym.model.Track;

import java.util.List;

public interface IService {
    List<Track> findAll();

    Track findOne(int id);

    void save(Track track);

    List<Track> save(List<Track> customers);

    boolean exists(int id);

    List<Track> findAll(List<Integer> ids);

    long count();

    void delete(int id);

    void delete(Track track );

    void delete(List<Track> tracks);

    void deleteAll();

    void update(Track track);
}
