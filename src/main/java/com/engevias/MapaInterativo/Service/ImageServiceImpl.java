package com.engevias.MapaInterativo.Service;

import com.engevias.MapaInterativo.Entities.Image;
import com.engevias.MapaInterativo.Entities.Condicao;
import com.engevias.MapaInterativo.Repository.ImageRepository;
import com.engevias.MapaInterativo.Repository.CondicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private CondicaoRepository condicaoRepository;

    @Override
    public Image create(MultipartFile imagemPanoramica, MultipartFile imagemPavimento, int condicaoId) {
        Image newImage = new Image();
        try {
            newImage.setImagem_panoramica(imagemPanoramica.getBytes()); // Armazena a imagem panorâmica
            newImage.setImagem_pavimento(imagemPavimento.getBytes()); // Armazena a imagem do pavimento
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao ler os arquivos de imagem");
        }

        Condicao condicao = condicaoRepository.findById(condicaoId)
                .orElseThrow(() -> new RuntimeException("Condição não encontrada: " + condicaoId));
        newImage.setCondicao(condicao); // Associa a condição

        return imageRepository.save(newImage);
    }

    @Override
    public List<Image> viewAll() {
        return imageRepository.findAll();
    }

    @Override
    public Image viewById(long id) {
        return imageRepository.findById(id).orElse(null);
    }

    @Override
    public List<Image> viewByCondicaoId(int condicaoId) {
        return imageRepository.findByCondicaoId(condicaoId);
    }


}
