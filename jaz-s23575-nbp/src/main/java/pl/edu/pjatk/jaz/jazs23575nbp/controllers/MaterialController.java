package pl.edu.pjatk.jaz.jazs23575nbp.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pjatk.jaz.jazs23575nbp.models.MaterialQuery;
import pl.edu.pjatk.jaz.jazs23575nbp.services.MaterialService;

@RestController
@RequestMapping("/nbpmaterials")
public class MaterialController {

    private final MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping("/average/{start}/{end}/")
    @ApiOperation(value = "Get average value of gold", notes =
            "Retriving average value of gold for specific period", response = MaterialQuery.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "SUCCESS", response = MaterialQuery.class),
            @ApiResponse(code = 404, message = "NOT FOUND"),
            @ApiResponse(code = 400, message = "BAD REQUEST"),
            @ApiResponse(code = 400, message = "BAD REQUEST (EXCEEDED LIMIT OF 367 DAYS)")
    })
    public ResponseEntity<MaterialQuery> getAverageValue(@PathVariable String start, @PathVariable String end) {
        return ResponseEntity.ok(materialService.getAverageValue(start, end));
    }

}
