package br.edu.ifsp.ar.postodw.repository.cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



import br.edu.ifsp.ar.postodw.model.Cliente;
import br.edu.ifsp.ar.postodw.repository.fliter.ClienteFilter;

public interface ClienteRepositoryQuery {

	Page<Cliente> filter(ClienteFilter activityFilter, Pageable pageable);
}