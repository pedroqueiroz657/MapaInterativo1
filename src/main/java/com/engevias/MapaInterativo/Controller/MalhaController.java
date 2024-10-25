package com.engevias.MapaInterativo.Controller;

import com.engevias.MapaInterativo.Repository.MalhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class MalhaController {

    @Autowired
    private MalhaRepository malhaRepository;

    @GetMapping("/malhas")
    public ResponseEntity<Map<String, Object>> getAllMalhaAsGeoJson() {
        try {
            // Obtém o objeto GeoJSON completo
            Map<String, Object> geoJson = malhaRepository.findAllMalhaAsGeoJson();

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
}
