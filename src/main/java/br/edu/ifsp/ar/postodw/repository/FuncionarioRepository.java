package br.edu.ifsp.ar.postodw.repository;

import br.edu.ifsp.ar.postodw.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
