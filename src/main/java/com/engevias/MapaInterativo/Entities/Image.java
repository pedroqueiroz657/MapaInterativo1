package com.engevias.MapaInterativo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "image_table")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Lob
    private byte[] imagem_panoramica;

    @Lob
    private byte[] imagem_pavimento;

    @ManyToOne
    @JoinColumn(name = "condicao_id")
    @JsonIgnore
    private Condicao condicao;
}
