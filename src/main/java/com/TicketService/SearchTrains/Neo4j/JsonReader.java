package com.TicketService.SearchTrains.Neo4j;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

@Component
public class JsonReader {
    public List<StationDTO> readStations() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = new ClassPathResource("stations.json").getInputStream();

        JsonNode root = mapper.readTree(is);
        return mapper.convertValue(
                root.get("stations"),
                new TypeReference<List<StationDTO>>() {}
        );
    }
}
