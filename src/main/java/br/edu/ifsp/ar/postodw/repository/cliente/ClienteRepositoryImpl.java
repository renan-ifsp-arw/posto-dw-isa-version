package br.edu.ifsp.ar.postodw.repository.cliente;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import br.edu.ifsp.ar.postodw.model.Cliente;
import br.edu.ifsp.ar.postodw.repository.fliter.ClienteFilter;

public class ClienteRepositoryImpl implements ClienteRepositoryQuery{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<Cliente> filter(ClienteFilter clienteFilter,Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
		Root<Cliente> root = criteria.from(Cliente.class);
		
		Predicate[] predicates = createConstraints(clienteFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Cliente> query = manager.createQuery(criteria);
		addPaginationConstraints(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, totalPages(clienteFilter));
	}

	private Predicate[] createConstraints(ClienteFilter clienteFilter, CriteriaBuilder builder, Root<Cliente> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		
		
		if(clienteFilter.getNome() != null) {
			predicates.add(builder.equal(
					root.get("nome"), clienteFilter.getNome()));
		}
		
		if(clienteFilter.getDocumento() != null) {
			predicates.add(builder.equal(
					root.get("documento"), clienteFilter.getDocumento()));
		}
		
		
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	private void addPaginationConstraints(TypedQuery<Cliente> query, Pageable pageable) {
		int currentPage = pageable.getPageNumber();
		int totalRecordsPerPage = pageable.getPageSize();
		int firstPageRecord = currentPage * totalRecordsPerPage;
		
		query.setFirstResult(firstPageRecord);
		query.setMaxResults(totalRecordsPerPage);
	}
	
	private Long totalPages(ClienteFilter clienteFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Cliente> root = criteria.from(Cliente.class);
		
		Predicate[] predicates = createConstraints(clienteFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}
	

}
