package arkhipov.traffic.repositories;

import arkhipov.traffic.models.Record;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface RecordRepository extends CrudRepository<Record, Integer> {
    Optional<List<Record>> findByUserIdAndDateTimeBetween(int id, LocalDateTime startDateTime, LocalDateTime endDateTime);
}
