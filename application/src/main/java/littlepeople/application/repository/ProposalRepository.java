package littlepeople.application.repository;

import littlepeople.application.model.Hospital;
import littlepeople.application.model.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Long> {
}
