package littlepeople.application.repository;

import littlepeople.application.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository  extends JpaRepository<Hospital, Long> {
    @Query("SELECT hospital from Hospital  hospital WHERE lower(hospital.city) = lower(:city)")
    List<Hospital> getAllByCityCaseInsesitive(@Param("city") String city);
}
