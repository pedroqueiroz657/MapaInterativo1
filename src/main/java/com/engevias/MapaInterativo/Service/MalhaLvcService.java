package com.engevias.MapaInterativo.Service;


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
    private MalhaLvcRepository repository;

    public List<MalhaLvc> findAll() {
        return repository.findAll();
    }

    public Optional<MalhaLvc> findById(Integer id) {
        return repository.findById(id);
    }

    public MalhaLvc save(MalhaLvc lvc) {
        return repository.save(lvc);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public Map<String, Object> getAllAsGeoJson() {
        return repository.findAllAsGeoJson();
    }
}

