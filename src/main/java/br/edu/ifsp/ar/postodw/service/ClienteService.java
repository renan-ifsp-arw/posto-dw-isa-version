package br.edu.ifsp.ar.postodw.service;

import br.edu.ifsp.ar.postodw.model.Bomba;
import br.edu.ifsp.ar.postodw.model.Cliente;
import br.edu.ifsp.ar.postodw.repository.ClienteRepository;
import br.edu.ifsp.ar.postodw.repository.fliter.ClienteFilter;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> list(){
        return clienteRepository.findAll();
    }
    public Optional<Cliente> findById(Long id){return clienteRepository.findById(id);}
    public Cliente save(Cliente cliente){return clienteRepository.save(cliente);}
    public void deleteById(Long id){clienteRepository.deleteById(id);}
    
    public Cliente update(Long id, Cliente cliente) {
    	Cliente clienteSaved = findClienteById(id);
		BeanUtils.copyProperties(cliente, clienteSaved, "id");
		return clienteRepository.save(clienteSaved);
	}
    
    public Cliente findClienteById(Long id) {
    	Cliente clienteSaved = clienteRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		return clienteSaved;
	}
    public Page<Cliente> search(ClienteFilter clienteFilter, Pageable pageable){
		return clienteRepository.filter(clienteFilter, pageable);
	}

}
