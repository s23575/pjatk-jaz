package pl.edu.pjatk.jaz.nbp.rates.services;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.edu.pjatk.jaz.nbp.rates.interfaces.RateRepository;
import pl.edu.pjatk.jaz.nbp.rates.models.Currency;
import pl.edu.pjatk.jaz.nbp.rates.models.Query;
import pl.edu.pjatk.jaz.nbp.rates.models.Rate;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;


@Service
public class RateService {

    private final RateRepository rateRepository;
    private final RestTemplate restTemplate;

    public RateService(RateRepository rateRepository, RestTemplate restTemplate) {
        this.rateRepository = rateRepository;
        this.restTemplate = restTemplate;
    }

    private static final String resourceUrl = "http://api.nbp.pl/api/exchangerates/rates/a/";

    public Query getAverageRate(String cur, Integer days) {
        String endDate = LocalDate.now().toString();
        String startDate = LocalDate.now().minusDays(days).toString();

        ResponseEntity<Currency> response = restTemplate.exchange(resourceUrl + cur + "/" + startDate + "/"
                + endDate + "/?format=json", HttpMethod.GET, null, Currency.class);

        Currency currency = response.getBody();
        List<Rate> rates = currency.getRates();
        double averageRate = rates.stream().mapToDouble(Rate::getMid).average().orElse(0);

        Query queryToSave = new Query(currency.getCurrency(), cur, days, startDate, endDate, averageRate,
                new Timestamp(System.currentTimeMillis()));

        return rateRepository.save(queryToSave);
    }
}
