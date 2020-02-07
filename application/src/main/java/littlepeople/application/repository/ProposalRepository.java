package littlepeople.application.repository;

import littlepeople.application.model.Activity;
import littlepeople.application.model.Hospital;
import littlepeople.application.model.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Long> {
    @Query("SELECT proposal FROM Proposal proposal")
    List<Proposal> getAllProposals();

    @Query("SELECT proposal FROM Proposal proposal WHERE proposal.status = :status")
    List<Proposal> getAllProposalsWithStatus(@Param("status") String status);

    @Query("SELECT proposal FROM Proposal proposal WHERE proposal.startDateAndTime >= :beginWeek AND proposal.startDateAndTime <= :endWeek")
    List<Proposal> getAllProposalsFromThisWeek(
            @Param("beginWeek") LocalDateTime beginWeek,
            @Param("endWeek") LocalDateTime endWeek
    );

    @Query("SELECT proposal FROM Proposal proposal WHERE proposal.startDateAndTime >= :beginWeek AND proposal.startDateAndTime <= :endWeek AND proposal.status = :status")
    List<Proposal> getAllProposalsFromThisWeekWithStatus(
            @Param("beginWeek") LocalDateTime beginWeek,
            @Param("endWeek")  LocalDateTime endWeek,
            @Param("status") String status
    );
}
