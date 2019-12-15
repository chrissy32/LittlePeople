package littlepeople.application.model;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User extends BaseEntity {

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

    @Column
    private Boolean isAdmin;

    @Column
    private String city;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Hospital.class)
    @JoinColumn(name = "hospital", referencedColumnName = "id")
    private Hospital hospital;
}
