package com.engevias.MapaInterativo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.MultiLineString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shape 2024") // O nome da tabela com aspas
public class Malha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "geometry(MultiLineStringz, 4326)")
    private MultiLineString geom;

    private String name;
    private Double extensâo;

}

