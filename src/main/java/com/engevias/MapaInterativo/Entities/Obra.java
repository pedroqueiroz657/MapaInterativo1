package com.engevias.MapaInterativo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.MultiLineString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "OBRAS")
public class Obra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "geom", columnDefinition = "geometry(MultiLineStringZ, 4326)")
    private MultiLineString geom;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "rodovia")
    private String rodovia;

    @Column(name = "sre")
    private String sre;

    @Column(name = "\"tipo obra\"")  // Special character (space) handled with quotes
    private String tipoObra;

    @Column(name = "fonte")
    private String fonte;

    @Column(name = "extensao")
    private float extensao;

    @Column(name = "valor")
    private float valor;

    @Column(name = "status")
    private String status;

    @Column(name = "distrito")
    private String distrito;


}
