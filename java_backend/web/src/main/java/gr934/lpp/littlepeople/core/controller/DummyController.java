package gr934.lpp.littlepeople.core.controller;

import gr934.lpp.littlepeople.core.dto.DummyEntityDTO;

import gr934.lpp.littlepeople.core.service.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class DummyController {

    @Autowired
    DummyService dummyService;

//    @Autowired
//    DummyMapper dummyMapper;

    @GetMapping("/all")
    List<DummyEntityDTO> getAll() {
        //return Mappers.getMapper(DummyMapper.class).mapDummyEntityToDTO(this.dummyService.getAll());

        return this.dummyService.getAll().stream().map(ent -> new DummyEntityDTO(ent.getId(), ent.getText())).collect(Collectors.toList());
    }
}
