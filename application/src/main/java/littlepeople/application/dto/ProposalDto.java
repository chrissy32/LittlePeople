package littlepeople.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProposalDto extends BaseDto {
    private String proposedBy;
    private String description;
    private String category;
    private String title;
    private String status;
    private String startDateAndTime;
    private String endDateAndTime;
    private Long hospitalId;
    private Set<Long> userIdsWhoVotedThisProposal;
}
