package littlepeople.application.repository;

import littlepeople.application.model.Hospital;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends CrudRepository<Hospital, Long> {
}
