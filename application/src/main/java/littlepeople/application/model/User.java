package littlepeople.application.model;

import lombok.*;

import javax.persistence.*;

@Table(name = "users")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User extends BaseEntity {

    @Column
    public String username;

    @Column
    public String email;

    @Column
    public String password;

    @Column
    public Boolean isAdmin;

    @ManyToOne
    @JoinColumn(name="hospital")
    private Hospital hospital;

}
