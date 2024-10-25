package com.engevias.MapaInterativo.Controller;

import com.engevias.MapaInterativo.Entities.MalhaLvc;
import com.engevias.MapaInterativo.Service.MalhaLvcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/malhaLvc")
public class MalhaLvcController {

    @Autowired
    private MalhaLvcService service;

    @GetMapping
    public List<MalhaLvc> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MalhaLvc> getById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MalhaLvc create(@RequestBody MalhaLvc lvc) {
        return service.save(lvc);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MalhaLvc> update(@PathVariable Integer id, @RequestBody MalhaLvc lvc) {
        lvc.setId(id);
        return ResponseEntity.ok(service.save(lvc));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/geojson")
    public ResponseEntity<Map<String, Object>> getAllAsGeoJson() {
        Map<String, Object> geoJson = service.getAllAsGeoJson();
        return ResponseEntity.ok(geoJson);
    }

}
