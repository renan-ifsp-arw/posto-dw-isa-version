package br.edu.ifsp.ar.postodw.service;

import br.edu.ifsp.ar.postodw.model.Abastecimento;
import br.edu.ifsp.ar.postodw.repository.AbastecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbastecimentoService {

    @Autowired
    private AbastecimentoRepository abastecimentoRepository;

    public List<Abastecimento> list(){
        return abastecimentoRepository.findAll();
    }
    public Optional<Abastecimento> findById(Long id){return abastecimentoRepository.findById(id);}
    public Abastecimento save(Abastecimento abastecimento){return abastecimentoRepository.save(abastecimento);}
    public void deleteById(Long id){abastecimentoRepository.deleteById(id);}
}
