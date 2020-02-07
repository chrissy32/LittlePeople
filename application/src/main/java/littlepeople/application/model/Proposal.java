package littlepeople.application.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private LocalDateTime startDateAndTime;

    @Column
    private LocalDateTime endDateAndTime;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Hospital.class)
    @JoinColumn(name = "hospital", referencedColumnName = "id")
    private Hospital hospital;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "proposal", cascade = CascadeType.ALL)
    private Set<Vote> votes = new HashSet<>();
}
