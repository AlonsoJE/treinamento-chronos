package treinamento.chrono.treinamento.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import treinamento.chrono.treinamento.dto.ProcedimentoDto;
import treinamento.chrono.treinamento.service.ProcedimentoService;

@RestController
@RequestMapping("/procedimentos")
public class ProcedimentoEndpoint {

    @Autowired
    private ProcedimentoService service;

    @GetMapping({"/",""})
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping({"/{id}","{id}"})
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long idProcedimento){
        return ResponseEntity.ok(service.findById(idProcedimento));
    }

    @PutMapping({"/{id}","{id}"})
    public ResponseEntity<?> update(@PathVariable(name = "id") Long idProcedimento, @RequestBody ProcedimentoDto procedimentoDto){
        return ResponseEntity.ok(service.update(idProcedimento, procedimentoDto));
    }

    @PostMapping({"/",""})
    public ResponseEntity<?> save(@RequestBody ProcedimentoDto procedimentoDto){
        return ResponseEntity.ok(service.save(procedimentoDto));
    }

    @DeleteMapping({"/{id}","{id}"})
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long idProcedimento){
        return ResponseEntity.ok(service.deleteById(idProcedimento));
    }

    @PatchMapping({"/{id}","{id}"})
    public ResponseEntity<?> active(@PathVariable(name = "id") Long idProcedimento){
        return ResponseEntity.ok(service.active(idProcedimento));
    }

}
