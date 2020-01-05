package littlepeople.application.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Activity extends BaseEntity {

    @Column
    private String description;

    @Column
    private String category;

    @Column
    private String title;

    @Column
    private String status = StatusEnum.PENDING.toString();

    @Column
    private LocalDateTime startDateAndTime;

    @Column
    private LocalDateTime endDateAndTime;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Hospital.class)
    @JoinColumn(name = "hospital", referencedColumnName = "id")
    private Hospital hospital;
}
