package littlepeople.application.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Hospital extends BaseEntity {
    @Column
    private String name;

    @Column
    private String city;

    @Column
    private String address;
}
