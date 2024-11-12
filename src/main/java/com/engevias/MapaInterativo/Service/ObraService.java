package com.engevias.MapaInterativo.Service;

import com.engevias.MapaInterativo.Entities.Obra;
import com.engevias.MapaInterativo.Repository.ObrasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraService {
    @Autowired
    private ObrasRepository repository;

    public List<Obra> findAll() {
        return repository.findAll();
    }

    public Obra findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Malha não encontrada: " + id));
    }

    public Obra save(Obra obra) {
        return repository.save(obra);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public List<Obra> findByDistrito(String distrito){
        return repository.findByDistrito(distrito);
    }
}
