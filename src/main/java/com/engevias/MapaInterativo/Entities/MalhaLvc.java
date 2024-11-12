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
@Table(name = "LVC_")
public class MalhaLvc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "geometry(MultiLineStringZ, 4326)")
    private MultiLineString geom;

    private String layer;
    private String linetype;

    private String sre;
    private String resultado;
    private String resultad_1;

}
