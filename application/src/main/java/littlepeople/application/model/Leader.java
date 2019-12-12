package littlepeople.application.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Leader extends BaseEntity {
    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private String firstName;

    @Column
    private String surname;

    @OneToMany(mappedBy = "leader")
    private List<HospitalLeader> hospitals = new ArrayList<>();
}
