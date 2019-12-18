package littlepeople.application.repository;

import littlepeople.application.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    @Query("SELECT activity FROM Activity activity LEFT JOIN FETCH activity.hospital hospital WHERE hospital.city = :city")
    List<Activity> getAllActivitiesFromCity(@Param("city") String city);

    @Query("SELECT activity FROM Activity activity WHERE activity.hospital = :hospital")
    List<Activity> getAllActivitesFromHospital(@Param("hospital") Long hospital);
}
