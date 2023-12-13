package br.edu.ifsp.ar.postodw.repository;

import br.edu.ifsp.ar.postodw.model.Cliente;

import br.edu.ifsp.ar.postodw.repository.cliente.ClienteRepositoryQuery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long>, ClienteRepositoryQuery  {
	public List<Cliente> findBy();
}
