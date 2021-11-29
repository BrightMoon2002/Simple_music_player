package duy.codegym.repo;

import duy.codegym.model.Track;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITrackRepository extends PagingAndSortingRepository<Track, Long> {

}
