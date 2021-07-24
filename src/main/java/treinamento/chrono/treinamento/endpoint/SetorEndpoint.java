package treinamento.chrono.treinamento.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import treinamento.chrono.treinamento.dto.SetorDto;
import treinamento.chrono.treinamento.service.SetorService;

@RestController
@RequestMapping("/setores")
public class SetorEndpoint {

    @Autowired
    private SetorService service;

    @GetMapping({"/",""})
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping({"/{id}","{id}"})
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long idSetor){
        return ResponseEntity.ok(service.findById(idSetor));
    }

    @PutMapping({"/{id}","{id}"})
    public ResponseEntity<?> update(@PathVariable(name = "id") Long idProcedimento, @RequestBody SetorDto setorDto){
        return ResponseEntity.ok(service.update(idProcedimento, setorDto));
    }

    @PostMapping({"/",""})
    public ResponseEntity<?> save(@RequestBody SetorDto setorDto){
        return ResponseEntity.ok(service.save(setorDto));
    }

    @DeleteMapping({"/{id}","{id}"})
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long idSetor){
        service.deleteById(idSetor);
        return ResponseEntity.ok().build();
    }

    @PatchMapping({"/{id}","{id}"})
    public ResponseEntity<?> active(@PathVariable(name = "id") Long idProcedimento){
        return ResponseEntity.ok(service.active(idProcedimento));
    }


}
