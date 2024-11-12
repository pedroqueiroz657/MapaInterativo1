package com.engevias.MapaInterativo.Controller;

import com.engevias.MapaInterativo.Entities.MalhaLvc;
import com.engevias.MapaInterativo.Entities.Obra;
import com.engevias.MapaInterativo.Repository.ObrasRepository;
import com.engevias.MapaInterativo.Service.MalhaLvcService;
import com.engevias.MapaInterativo.Service.ObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ObraController {

    @Autowired
    private ObrasRepository repository;

    @Autowired
    private ObraService service;

    @GetMapping("/Obra")
    public ResponseEntity<Map<String, Object>> getAllMalhaAsGeoJson() {
        try {
            // Obtém o objeto GeoJSON completo
            Map<String, Object> geoJson = repository.findAllAsGeoJson();

            // Verifica se o retorno está vazio
            if (geoJson == null || geoJson.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Map.of("message", "Nenhuma malha encontrada"));
            }

            return ResponseEntity.ok(geoJson);

        } catch (Exception e) {
            e.printStackTrace(); // Log do erro para depuração
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Erro ao buscar malhas"));
        }
    }

    @GetMapping("/Obra/{id}")
    public ResponseEntity<Obra> getMalhaById(@PathVariable Integer id) {
        try {
            Obra obra = service.findById(id);
            return ResponseEntity.ok(obra);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null); // Retorna 404 se não encontrado
        } catch (Exception e) {
            e.printStackTrace(); // Log do erro para depuração
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    // Endpoint para buscar obras por distrito
    @GetMapping("/Obra/distrito/{distrito}")
    public ResponseEntity<Map<String, Object>> getObrasByDistrito(@PathVariable String distrito) {
        try {
            // Busca as obras filtradas por distrito
            List<Obra> obras = service.findByDistrito(distrito);

            // Verifica se a lista está vazia
            if (obras.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Map.of("message", "Nenhuma obra encontrada para o distrito " + distrito));
            }

            // Converte a lista de obras para GeoJSON
            Map<String, Object> geoJson = repository.findAllAsGeoJson();  // Aqui você pode ajustar o retorno para GeoJSON

            return ResponseEntity.ok(geoJson); // Retorna o GeoJSON das obras filtradas

        } catch (Exception e) {
            e.printStackTrace(); // Log do erro para depuração
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Erro ao buscar obras para o distrito"));
        }
    }

}
