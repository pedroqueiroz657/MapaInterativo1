package com.engevias.MapaInterativo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CondicaoDTO {
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
    private List<String> imagensHex;


}

