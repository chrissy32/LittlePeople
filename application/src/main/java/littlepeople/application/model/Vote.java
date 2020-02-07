package littlepeople.application.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@IdClass(VotePK.class)
public class Vote implements Serializable {
    @Id
    @ManyToOne(optional = false, fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "user")
    private User user;

    @Id
    @ManyToOne(optional = false, fetch = FetchType.LAZY, targetEntity = Proposal.class)
    @JoinColumn(name = "proposal")
    private Proposal proposal;
}
