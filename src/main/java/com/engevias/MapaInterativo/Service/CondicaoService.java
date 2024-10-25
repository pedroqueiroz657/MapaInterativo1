package com.engevias.MapaInterativo.Service;

import com.engevias.MapaInterativo.Entities.Condicao;
import com.engevias.MapaInterativo.Repository.CondicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondicaoService {

    @Autowired
    private CondicaoRepository condicaoRepository;


    public List<Condicao> findAll(){
        return condicaoRepository.findAll();
    }

}
