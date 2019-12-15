package littlepeople.application.model;

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

    public Report(Activity activity, String text) {
        this.activity = activity;
        this.description = this.activity.getDescription();
        this.category = this.activity.getCategory();
        this.title = this.activity.getTitle();
        this.text = text;
    }
}
