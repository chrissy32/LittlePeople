package littlepeople.application.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Activity_Volunteer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ActivityVolunteer extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "activity", referencedColumnName = "id")
    private Activity activity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "volunteer", referencedColumnName = "id")
    private Volunteer volunteer;
}
