package littlepeople.application.repository;

import littlepeople.application.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    Report getByActivity_Id(Long activityId);
}
