package br.edu.ifsp.ar.postodw.service;

import br.edu.ifsp.ar.postodw.model.Abastecimento;
import br.edu.ifsp.ar.postodw.model.Bomba;
import br.edu.ifsp.ar.postodw.repository.BombaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BombaService {

    @Autowired
    private BombaRepository bombaRepository;

    public List<Bomba> list(){
        return bombaRepository.findAll();
    }
    public Optional<Bomba> findById(Long id){return bombaRepository.findById(id);}
    public Bomba save(Bomba bomba){return bombaRepository.save(bomba);}
    public void deleteById(Long id){bombaRepository.deleteById(id);}
}
