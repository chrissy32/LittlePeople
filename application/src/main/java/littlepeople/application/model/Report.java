package littlepeople.application.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Report extends BaseEntity {
    @Column
    private String description;

    @Column
    private String category;

    @Column
    private String title;

    @Column
    private String text;


    @OneToOne(fetch = FetchType.LAZY, targetEntity = Activity.class)
    @JoinColumn(name = "activity", referencedColumnName = "id")
    private Activity activity;
}
