package littlepeople.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AcceptProposalResponseDto {
    ProposalDto proposalDto;
    ActivityDto activityDto;
}
