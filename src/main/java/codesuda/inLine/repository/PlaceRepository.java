package codesuda.inLine.repository;

import codesuda.inLine.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}