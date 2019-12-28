package littlepeople.application.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Proposal extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = User.class)
    @JoinColumn(name = "proposedBy", referencedColumnName = "username")
    private User proposedBy;

    @Column
    private String description;

    @Column
    private String category;

    @Column
    private String title;

    @Column
    private String status = StatusEnum.PENDING.toString();

    @Column
    private LocalDateTime dateAndTime;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Hospital.class)
    @JoinColumn(name = "hospital", referencedColumnName = "id")
    private Hospital hospital;
}
