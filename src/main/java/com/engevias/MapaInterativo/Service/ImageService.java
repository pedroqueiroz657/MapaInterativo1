package com.engevias.MapaInterativo.Service;

import com.engevias.MapaInterativo.Entities.Image;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface ImageService {
    Image create(MultipartFile imagemPanoramica, MultipartFile imagemPavimento, int condicaoId); // Altera para aceitar duas imagens
    List<Image> viewAll();
    Image viewById(long id);
    List<Image> viewByCondicaoId(int condicaoId); // Permanece inalterado
}
