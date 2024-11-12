package com.engevias.MapaInterativo.Controller;

import com.engevias.MapaInterativo.Entities.MalhaLvc;
import com.engevias.MapaInterativo.Repository.MalhaLvcRepository;
import com.engevias.MapaInterativo.Repository.MalhaRepository;
import com.engevias.MapaInterativo.Service.MalhaLvcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MalhaLvcController {

    @Autowired
    private MalhaLvcRepository malhaLvcRepository;

    @Autowired
    private MalhaLvcService malhaLvcService;

    @GetMapping("/malhas_500")
    public ResponseEntity<Map<String, Object>> getAllMalhaAsGeoJson() {
        try {
            // Obtém o objeto GeoJSON completo
            Map<String, Object> geoJson = malhaLvcRepository.findAllAsGeoJson();

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

    @GetMapping("/malhas_500/{id}")
    public ResponseEntity<MalhaLvc> getMalhaById(@PathVariable Integer id) {
        try {
            MalhaLvc malha = malhaLvcService.findById(id);
            return ResponseEntity.ok(malha);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null); // Retorna 404 se não encontrado
        } catch (Exception e) {
            e.printStackTrace(); // Log do erro para depuração
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
