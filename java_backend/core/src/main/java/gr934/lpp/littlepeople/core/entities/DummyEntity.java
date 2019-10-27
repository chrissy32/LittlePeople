package gr934.lpp.littlepeople.core.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class DummyEntity extends BaseEntity<Long> {

    @Column(name = "text", nullable = false)
    private String text;
}
