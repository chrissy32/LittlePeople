package gr934.lpp.littlepeople.core.service;

import gr934.lpp.littlepeople.core.entities.DummyEntity;
import gr934.lpp.littlepeople.core.repository.DummyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DummyService  {

    @Autowired
    DummyRepository dummyRepository;

    public List<DummyEntity> getAll()
    {
        return this.dummyRepository.findAll();
    }
}
