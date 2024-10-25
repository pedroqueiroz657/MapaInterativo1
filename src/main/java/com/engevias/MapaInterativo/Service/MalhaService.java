package com.engevias.MapaInterativo.Service;

import com.engevias.MapaInterativo.Entities.Malha;
import com.engevias.MapaInterativo.Repository.MalhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MalhaService {

    @Autowired
    private MalhaRepository malhaRepository;

    public List<Malha> findAll() {
        return malhaRepository.findAll();
    }

    public Malha findById(Long id) {
        return malhaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Malha não encontrada: " + id));
    }

    public Malha save(Malha malha) {
        return malhaRepository.save(malha);
    }

    public void delete(Long id) {
        malhaRepository.deleteById(id);
    }
}
