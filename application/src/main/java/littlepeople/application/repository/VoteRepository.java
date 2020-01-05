package littlepeople.application.repository;

import littlepeople.application.model.Hospital;
import littlepeople.application.model.Proposal;
import littlepeople.application.model.Vote;
import littlepeople.application.model.VotePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote, VotePK> {
}
