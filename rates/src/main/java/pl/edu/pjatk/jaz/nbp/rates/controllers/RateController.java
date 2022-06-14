package pl.edu.pjatk.jaz.nbp.rates.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjatk.jaz.nbp.rates.models.Currency;
import pl.edu.pjatk.jaz.nbp.rates.models.Query;
import pl.edu.pjatk.jaz.nbp.rates.services.RateService;


@RestController
@RequestMapping("/nbprates")
public class RateController {

    private final RateService rateService;

    public RateController(RateService rateService) {
        this.rateService = rateService;
    }

    @GetMapping("/average/{cur}")
    public ResponseEntity<Query> getAverageRate(@PathVariable String cur,
                                                   @RequestParam(required = false, defaultValue = "1") Integer days) {
        return ResponseEntity.ok(rateService.getAverageRate(cur, days));
    }
}
