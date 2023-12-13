package br.edu.ifsp.ar.postodw.controler;

import br.edu.ifsp.ar.postodw.model.Abastecimento;
import br.edu.ifsp.ar.postodw.model.Bomba;
import br.edu.ifsp.ar.postodw.service.AbastecimentoService;
import br.edu.ifsp.ar.postodw.service.BombaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bomba")
public class BombaControler {

    @Autowired
    private BombaService bombaService;


    @GetMapping
    public List<Bomba> list(){
        return bombaService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bomba> findById(@PathVariable Long id){
        return bombaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Bomba create(@Valid @RequestBody Bomba bomba){
        return bombaService.save(bomba);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id){
        bombaService.deleteById(id);
    }
}
