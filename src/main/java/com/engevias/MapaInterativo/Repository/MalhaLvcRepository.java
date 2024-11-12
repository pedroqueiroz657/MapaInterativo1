package com.engevias.MapaInterativo.Repository;

import com.engevias.MapaInterativo.Entities.MalhaLvc;
import com.engevias.MapaInterativo.Entities.Obra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MalhaLvcRepository extends JpaRepository<MalhaLvc, Integer> {

    @Query(value = "SELECT json_build_object(\n" +
            "    'type', 'FeatureCollection',\n" +
            "    'features', json_agg(\n" +
            "        json_build_object(\n" +
            "            'type', 'Feature',\n" +
            "            'geometry', ST_AsGeoJSON(ST_Force2D(geom))::json,\n" +
            "            'properties', json_build_object(\n" +
            "                'id', id,\n" +
            "                'layer', layer,\n" +
            "                'linetype', linetype,\n" +
            "                'sre', sre,\n" +
            "                'resultado', resultado\n" + // Adicione esta linha
            "            )\n" +
            "        )\n" +
            "    )\n" +
            ") AS geojson\n" +
            "FROM public.\"LVC_\";", nativeQuery = true)
    Map<String, Object> findAllAsGeoJson();


}
