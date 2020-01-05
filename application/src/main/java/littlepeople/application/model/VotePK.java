package littlepeople.application.model;

import lombok.*;

import javax.persistence.Entity;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class VotePK implements Serializable {
    private Long user;
    private Long proposal;
}
