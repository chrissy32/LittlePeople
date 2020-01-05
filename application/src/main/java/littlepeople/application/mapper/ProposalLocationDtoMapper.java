package littlepeople.application.mapper;

import littlepeople.application.dto.ProposalLocationDto;
import littlepeople.application.model.Hospital;
import littlepeople.application.model.Proposal;
import littlepeople.application.service.HospitalService;
import littlepeople.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ProposalLocationDtoMapper extends AbstractMapper<Proposal, ProposalLocationDto> {
    @Autowired
    HospitalService hospitalService;
    @Autowired
    UserService userService;

    @Override
    public Proposal convertDtoToModel(ProposalLocationDto proposalDto) {
        // TODO never used I hope



        Proposal proposal = new Proposal();
        proposal.setId(proposalDto.getId());
        proposal.setCategory(proposalDto.getCategory());
        proposal.setDescription(proposalDto.getDescription());
        //proposal.setHospital(hospitalService.getById(proposalDto.getHospitalId()));
        proposal.setProposedBy(userService.getUserByUsername(proposalDto.getProposedBy()));
        proposal.setStatus(proposalDto.getStatus());
        proposal.setTitle(proposalDto.getTitle());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        proposal.setStartDateAndTime(LocalDateTime.parse(proposalDto.getStartDateAndTime(), formatter));
        proposal.setEndDateAndTime(LocalDateTime.parse(proposalDto.getEndDateAndTime(), formatter));
        return proposal;
    }

    @Override
    public ProposalLocationDto convertModelToDto(Proposal proposal) {
        ProposalLocationDto proposalDto = new ProposalLocationDto();
        proposalDto.setId(proposal.getId());
        proposalDto.setCategory(proposal.getCategory());
        proposalDto.setDescription(proposal.getDescription());

        Hospital hospitalObject = hospitalService.getById(proposal.getHospital().getId());
        proposalDto.setLocation(hospitalObject.getName() + " " + hospitalObject.getCity());

        proposalDto.setProposedBy(proposal.getProposedBy().getUsername());
        proposalDto.setStatus(proposal.getStatus());
        proposalDto.setTitle(proposal.getTitle());
        proposalDto.setStartDateAndTime(proposal.getStartDateAndTime().toString());
        proposalDto.setEndDateAndTime(proposal.getEndDateAndTime().toString());
        return proposalDto;
    }
}
