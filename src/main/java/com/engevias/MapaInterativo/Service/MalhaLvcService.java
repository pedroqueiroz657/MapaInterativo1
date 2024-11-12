package com.engevias.MapaInterativo.Service;


import com.engevias.MapaInterativo.Entities.Malha;
import com.engevias.MapaInterativo.Entities.MalhaLvc;
import com.engevias.MapaInterativo.Repository.MalhaLvcRepository;
import com.engevias.MapaInterativo.Repository.MalhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MalhaLvcService {
    @Autowired
    private MalhaLvcRepository malhaLvcRepository;

    public List<MalhaLvc> findAll() {
        return malhaLvcRepository.findAll();
    }

    public MalhaLvc findById(Integer id) {
        return malhaLvcRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Malha não encontrada: " + id));
    }

    public MalhaLvc save(MalhaLvc malha) {
        return malhaLvcRepository.save(malha);
    }

    public void delete(Integer id) {
        malhaLvcRepository.deleteById(id);
    }
}

