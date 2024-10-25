package com.engevias.MapaInterativo.Controller;

import com.engevias.MapaInterativo.Entities.Image;
import com.engevias.MapaInterativo.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/{condicaoId}") // Endpoint para criar imagens associadas a uma condição
    public ResponseEntity<Image> createImage(
            @PathVariable int condicaoId, // ID da condição
            @RequestParam("imagem_panoramica") MultipartFile imagemPanoramica, // Imagem panorâmica
            @RequestParam("imagem_pavimento") MultipartFile imagemPavimento) { // Imagem de pavimento
        Image createdImage = imageService.create(imagemPanoramica, imagemPavimento, condicaoId);
        return ResponseEntity.ok(createdImage);
    }

    @GetMapping // Endpoint para visualizar todas as imagens
    public ResponseEntity<List<Image>> getAllImages() {
        List<Image> images = imageService.viewAll();
        return ResponseEntity.ok(images);
    }

    @GetMapping("/{id}") // Endpoint para visualizar uma imagem pelo ID
    public ResponseEntity<Image> getImageById(@PathVariable long id) {
        Image image = imageService.viewById(id);
        if (image != null) {
            return ResponseEntity.ok(image);
        } else {
            return ResponseEntity.notFound().build(); // Retorna 404 se não encontrar
        }
    }

    @GetMapping("/condicao/{condicaoId}") // Endpoint para visualizar imagens associadas a uma condição
    public ResponseEntity<List<Image>> getImagesByCondicaoId(@PathVariable int condicaoId) {
        List<Image> images = imageService.viewByCondicaoId(condicaoId);
        return ResponseEntity.ok(images);
    }
}
