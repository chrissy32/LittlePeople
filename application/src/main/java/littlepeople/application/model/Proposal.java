package littlepeople.application.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Proposal extends BaseEntity {
    @Column
    private String proposedBy;

    @Column
    private String description;

    @Column
    private String category;

    @Column
    private String title;

    @Column
    private String status = StatusEnum.PENDING.toString();

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Hospital.class)
    @JoinColumn(name = "hospital", referencedColumnName = "id")
    private Hospital hospital;

    public Proposal(String proposedBy, String description, String category, String title) {
        this.proposedBy = proposedBy;
        this.description = description;
        this.category = category;
        this.title = title;
    }

}
