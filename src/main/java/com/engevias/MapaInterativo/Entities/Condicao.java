package com.engevias.MapaInterativo.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "condicao")
public class Condicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String trecho;

    private float bom;
    private float regular;
    private float ruim;
    private float pessimo;

    private String desInicio;
    private String desFinal;
    private long d_O;
    private long sit;
    private long distrito;
    private String jurisdicao;
    private Double kmInicio;
    private Double kmFim;
    private Double extensao;
    private String sit_des;
    private String tipoPav;

    @Column(name = "imagem_panoramica_id")
    private Long imagemPanoramicaId;

    @Column(name = "imagem_pavimento_id")
    private Long imagemPavimentoId;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "condicao")
    @JsonManagedReference
    private List<Image> images;  // List<Image> permite que você tenha várias imagens associadas
}
