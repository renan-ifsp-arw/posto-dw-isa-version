package br.edu.ifsp.ar.postodw.controler;

import br.edu.ifsp.ar.postodw.model.Bomba;
import br.edu.ifsp.ar.postodw.model.Cliente;
import br.edu.ifsp.ar.postodw.repository.ClienteRepository;
import br.edu.ifsp.ar.postodw.repository.fliter.ClienteFilter;
import br.edu.ifsp.ar.postodw.service.BombaService;
import br.edu.ifsp.ar.postodw.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteControler {

    @Autowired
    private ClienteService clienteService;
    
    @Autowired
	private ClienteRepository clienteRepository;

   /* @GetMapping
    public List<Cliente> list(){
        return clienteService.list();
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id){
    	Optional<Cliente> cliente = 
				clienteRepository.findById(id);
		if(cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}
		return ResponseEntity.notFound().build();
	}
    

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(@Valid @RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }

    @DeleteMapping
   // @ResponseStatus(HttpStatus.OK)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('ROLE_GERENCIA') and #oauth2.hasScope('write')")
    public void delete(@PathVariable Long id){
    	clienteRepository.deleteById(id);
    }
    
    @PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_GERENCIA') and #oauth2.hasScope('write')")
	public ResponseEntity<Cliente> update(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
    	Cliente clienteSaved = clienteService.update(id, cliente);
		return ResponseEntity.ok(clienteSaved);
	}
    
    @GetMapping
	@PreAuthorize("hasAuthority('ROLE_GERENCIA' ) and #oauth2.hasScope('read')")
	public Page<Cliente> search(ClienteFilter clienteFilter, Pageable pageable){
		return clienteService.search(clienteFilter, pageable);
	}
}
