package duy.codegym.service.impl;

import duy.codegym.model.Track;
import duy.codegym.repo.ITrackRepository;
import duy.codegym.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import java.util.Optional;

@Service
public class MediaPlayerServiceImpl implements IService<Track> {
    @Autowired
    private ITrackRepository trackRepository;

    @Override
    public Iterable<Track> findAll() {
        return trackRepository.findAll();
    }

    @Override
    public Optional<Track> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Track track) {
        trackRepository.save(track);
    }

    @Override
    public void remove(Long id) {
        trackRepository.delete(id);
    }


//    @Override
//    public Iterable<Track> findAll() {
//        return trackRepository.findAll();
//    }
//
//    @Override
//    public Track findOne(Long id) {
//        return trackRepository.findOne(id);
//    }
//
//    @Override
//    public void save(Track track) {
//        trackRepository.save(track);
//    }
//
//    @Override
//    public List<Track> save(List<Track> tracks) {
//        return null;
//    }
//
//    @Override
//    public boolean exists(Long id) {
//        return false;
//    }
//
//    @Override
//    public List<Track> findAll(List<Integer> ids) {
//        return null;
//    }
//
//    @Override
//    public long count() {
//        return 0;
//    }
//
//    @Override
//    public void delete(Long id) {
//        trackRepository.delete(id);
//    }
//
//    @Override
//    public void delete(Track track) {
//
//    }
//
//    @Override
//    public void delete(List<Track> tracks) {
//
//    }
//
//    @Override
//    public void deleteAll() {
//
//    }
//
//    @Override
//    public void update(Track track) {
//
//    }
}
