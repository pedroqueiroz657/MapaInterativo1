package com.engevias.MapaInterativo.Controller;

import com.engevias.MapaInterativo.Entities.Condicao;
import com.engevias.MapaInterativo.Service.CondicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/condicoes")
public class CondicaoController {

    @Autowired
    private CondicaoService condicaoService;

    @GetMapping
    public List<Condicao> getCondicoes(){
        return condicaoService.findAll();
    }

}
