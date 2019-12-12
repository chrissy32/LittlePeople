package littlepeople.application.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Hospital_Leader")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HospitalLeader extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital", referencedColumnName = "id")
    private Hospital hospital;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leader", referencedColumnName = "id")
    private Leader leader;
}
