package br.edu.ifsp.ar.postodw.service;

import br.edu.ifsp.ar.postodw.model.Bomba;
import br.edu.ifsp.ar.postodw.model.VendaConveniencia;
import br.edu.ifsp.ar.postodw.repository.BombaRepository;
import br.edu.ifsp.ar.postodw.repository.VendaConvenienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaConvenienciaService {

    @Autowired
    private VendaConvenienciaRepository vendaConvenienciaRepository;

    public List<VendaConveniencia> list(){
        return vendaConvenienciaRepository.findAll();
    }
    public Optional<VendaConveniencia> findById(Long id){return vendaConvenienciaRepository.findById(id);}
    public VendaConveniencia save(VendaConveniencia vendaConveniencia){return vendaConvenienciaRepository.save(vendaConveniencia);}
    public void deleteById(Long id){vendaConvenienciaRepository.deleteById(id);}
}
