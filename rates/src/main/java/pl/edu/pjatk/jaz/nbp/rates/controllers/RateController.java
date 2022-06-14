package pl.edu.pjatk.jaz.nbp.rates.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    @ApiOperation(value = "Get average exchange rate", notes =
            "Retriving average exchange rate of foreign currency for specific number of days", response = Query.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "SUCCESS", response = Query.class),
            @ApiResponse(code = 404, message = "NOT FOUND"),
            @ApiResponse(code = 400, message = "BAD REQUEST"),
            @ApiResponse(code = 400, message = "BAD REQUEST (EXCEEDED LIMIT OF 367 DAYS)")
    })
    public ResponseEntity<Query> getAverageRate(@PathVariable String cur,
                                                @RequestParam(required = false, defaultValue = "1") Integer days) {
        return ResponseEntity.ok(rateService.getAverageRate(cur, days));
    }
}
