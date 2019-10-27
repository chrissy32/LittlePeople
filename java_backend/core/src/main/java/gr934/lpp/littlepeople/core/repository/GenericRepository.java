package gr934.lpp.littlepeople.core.repository;

import gr934.lpp.littlepeople.core.entities.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface GenericRepository <T extends BaseEntity<ID>, ID extends
        Serializable>
        extends JpaRepository<T, ID> {
}
