package littlepeople.application.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private LocalDateTime dateAndTime;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Hospital.class)
    @JoinColumn(name = "hospital", referencedColumnName = "id")
    private Hospital hospital;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = Report.class)
    @JoinColumn(name = "report", referencedColumnName = "id")
    private Report report;

    public Activity(String description, String category, String title, LocalDateTime dateAndTime) {
        this.description = description;
        this.category = category;
        this.title = title;
        this.dateAndTime = dateAndTime;
    }
}
