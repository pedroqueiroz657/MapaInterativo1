package com.engevias.MapaInterativo.Repository;

import com.engevias.MapaInterativo.Entities.Obra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ObrasRepository extends JpaRepository<Obra, Integer> {

    @Query(value = "SELECT json_build_object(" +
            "    'type', 'FeatureCollection'," +
            "    'features', json_agg(" +
            "        json_build_object(" +
            "            'type', 'Feature'," +
            "            'geometry', ST_AsGeoJSON(ST_Force2D(geom))::json," +
            "            'properties', json_build_object(" +
            "                'id', id," +
            "                'descricao', descricao," +
            "                'rodovia', rodovia," +
            "                'sre', sre," +
            "                'tipo obra', \"tipo obra\"," +  // Campo adaptado
            "                'fonte', fonte," +               // Campo adaptado
            "                'extensao', extensao," +         // Campo adaptado
            "                'valor', valor," +               // Campo adaptado
            "                'status', \"status\"," +         // Campo adaptado (precisa de aspas duplas)
            "                'distrito', distrito" +          // Corrigindo vírgula faltante
            "            )" +
            "        )" +
            "    )" +
            ") AS geojson " +  // Adicionando um espaço aqui após geojson
            "FROM public.\"OBRAS\";", nativeQuery = true)
    Map<String, Object> findAllAsGeoJson();

    List<Obra> findByDistrito(String distrito);
}
