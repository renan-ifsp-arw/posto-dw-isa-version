package br.edu.ifsp.ar.postodw.service;

import br.edu.ifsp.ar.postodw.model.Bomba;
import br.edu.ifsp.ar.postodw.model.Fornecedor;
import br.edu.ifsp.ar.postodw.repository.BombaRepository;
import br.edu.ifsp.ar.postodw.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<Fornecedor> list(){
        return fornecedorRepository.findAll();
    }
    public Optional<Fornecedor> findById(Long id){return fornecedorRepository.findById(id);}
    public Fornecedor save(Fornecedor fornecedor){return fornecedorRepository.save(fornecedor);}
    public void deleteById(Long id){fornecedorRepository.deleteById(id);}
}
