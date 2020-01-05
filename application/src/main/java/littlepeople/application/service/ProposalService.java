package littlepeople.application.service;

import littlepeople.application.model.Activity;
import littlepeople.application.model.Proposal;
import littlepeople.application.model.StatusEnum;
import littlepeople.application.repository.ProposalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author Xps 9560
 */

@Service
@RequiredArgsConstructor
public class ProposalService {
    @Autowired
    ProposalRepository proposalRepository;

    @Autowired
    ActivityService activityService;

    public Proposal addProposal(Proposal proposal) {
        proposal.setStatus(StatusEnum.PENDING.toString());
        return this.proposalRepository.save(proposal);
    }

    public Proposal updateProposal(Proposal proposal) {
        return this.proposalRepository.save(proposal);
    }

    public void deleteProposalById(Long proposalId) {
        this.proposalRepository.deleteById(proposalId);
    }

    public Proposal getProposalById(Long proposalId) {
        return this.proposalRepository.findById(proposalId).get();
    }

    @Transactional
    public Activity acceptProposal(Long proposalId) {
        Proposal proposal = getProposalById(proposalId);
        proposal.setStatus(StatusEnum.ACCEPTED.toString());
        Activity activity = new Activity();
        activity.setStatus(proposal.getStatus());
        activity.setHospital(proposal.getHospital());
        activity.setTitle(proposal.getTitle());
        activity.setStartDateAndTime(proposal.getStartDateAndTime());
        activity.setEndDateAndTime(proposal.getEndDateAndTime());
        activity.setCategory(proposal.getCategory());
        activity.setDescription(proposal.getDescription());
        return activityService.addActivity(activity);
    }

    @Transactional
    public Proposal rejectProposal(Long proposalId) {
        Proposal proposal = getProposalById(proposalId);
        proposal.setStatus(StatusEnum.REJECTED.toString());
        return proposal;
    }

    public List<Proposal> getAllProposalsWithOptionalStatus(Optional<String> optionalStatus) {
        if (!optionalStatus.isPresent()) {
            return this.proposalRepository.getAllProposals();
        }
        else {
            return this.proposalRepository.getAllProposalsWithStatus(optionalStatus.get());
        }
    }


    public List<Proposal> getAllProposalsFromCurrentWeekWithOptionalStatus(Optional<String> optionalStatus) {
        LocalDate today = LocalDate.now();
        // Go backward to get Monday
        LocalDate monday = today;
        while (monday.getDayOfWeek() != DayOfWeek.MONDAY) {
            monday = monday.minusDays(1);
        }
        // Go forward to get Sunday
        LocalDate sunday = today;
        while (sunday.getDayOfWeek() != DayOfWeek.SUNDAY) {
            sunday = sunday.plusDays(1);
        }


        LocalDateTime beginWeek = monday.atStartOfDay();
        LocalDateTime endWeek = sunday.atStartOfDay().plusHours(24);

        if (!optionalStatus.isPresent()) {
            return this.proposalRepository.getAllProposalsFromThisWeek(beginWeek, endWeek);
        }
        else {
            return this.proposalRepository.getAllProposalsFromThisWeekWithStatus(beginWeek, endWeek, optionalStatus.get());
        }
    }
}
