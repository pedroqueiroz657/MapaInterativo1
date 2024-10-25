package com.engevias.MapaInterativo.Repository;

import com.engevias.MapaInterativo.Entities.Malha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface MalhaRepository extends JpaRepository<Malha, Long> {

    @Query(value = "SELECT json_build_object(\n" +
            "    'type', 'FeatureCollection',\n" +
            "    'features', json_agg(\n" +
            "        json_build_object(\n" +
            "            'type', 'Feature',\n" +
            "            'geometry', ST_AsGeoJSON(ST_Force2D(geom))::json,\n" +
            "            'properties', json_build_object(\n" +
            "                'id', id,\n" +
            "                'name', name,\n" +
            "                'extensão', \"extensão\",\n" +
            "                'situ', situ\n" +
            "            )\n" +
            "        )\n" +
            "    )\n" +
            ") AS geojson\n" +
            "FROM public.\"SHAPE 2024\";",
            nativeQuery = true)
    Map<String, Object> findAllMalhaAsGeoJson();

}
