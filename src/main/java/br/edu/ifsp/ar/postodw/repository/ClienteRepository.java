package br.edu.ifsp.ar.postodw.repository;

import br.edu.ifsp.ar.postodw.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
