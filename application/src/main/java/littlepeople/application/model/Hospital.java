package littlepeople.application.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "hospitals")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Hospital extends BaseEntity {
    private String name;
    private String city;
}
