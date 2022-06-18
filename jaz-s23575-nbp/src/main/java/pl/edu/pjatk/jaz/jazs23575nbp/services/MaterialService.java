package pl.edu.pjatk.jaz.jazs23575nbp.services;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.edu.pjatk.jaz.jazs23575nbp.interfaces.MaterialRepository;
import pl.edu.pjatk.jaz.jazs23575nbp.models.MaterialQuery;
import pl.edu.pjatk.jaz.jazs23575nbp.models.Price;
import pl.edu.pjatk.jaz.jazs23575nbp.types.Material;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaterialService {

    private final MaterialRepository materialRepository;
    private final RestTemplate restTemplate;

    public MaterialService(MaterialRepository materialRepository, RestTemplate restTemplate) {
        this.materialRepository = materialRepository;
        this.restTemplate = restTemplate;
    }

    private static final String resourceUrl = "http://api.nbp.pl/api/cenyzlota/";

    public MaterialQuery getAverageValue(String start, String end) {

        // Poniższe na podstawie: https://www.baeldung.com/spring-resttemplate-json-list
        ResponseEntity<List<Price>> response =
                restTemplate.exchange(resourceUrl + start + "/" + end + "/", HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Price>>() {
                        }
                );
        List<Price> prices = response.getBody();
        prices.stream().map(Price::getData).collect(Collectors.toList());

        double averageRate = prices.stream().mapToDouble(Price::getCena).average().orElse(0);

        MaterialQuery queryToSave = new MaterialQuery(Material.GOLD, start, end, averageRate,
                new Timestamp(System.currentTimeMillis()));

        return materialRepository.save(queryToSave);
    }

}
