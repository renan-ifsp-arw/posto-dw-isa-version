package br.edu.ifsp.ar.postodw.repository;

import br.edu.ifsp.ar.postodw.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
}
