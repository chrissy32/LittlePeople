package littlepeople.application.service;

import littlepeople.application.model.Vote;
import littlepeople.application.model.VotePK;
import littlepeople.application.repository.ProposalRepository;
import littlepeople.application.repository.UserRepository;
import littlepeople.application.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class VoteService {
    @Autowired
    VoteRepository voteRepository;

    @Autowired
    UserService userService;

    @Autowired
    ProposalService proposalService;

    public void addVote(Long userId, Long proposalId){
        Vote vote = new Vote(userService.getUserById(userId), proposalService.getProposalById(proposalId));
        voteRepository.save(vote);
    }

    public void removeVote(Long userId, Long proposalId){
        Vote vote = new Vote(userService.getUserById(userId), proposalService.getProposalById(proposalId));
        voteRepository.delete(vote);
    }
}
