package group5.BikeAPI.BikeHiringAPI.spring.controller;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Bike;
import group5.BikeAPI.BikeHiringAPI.spring.service.BikeService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@Api(value = "Bike management", description = "Operatiing bike in BikeHiringApplication")
public class BikeController {

    @Autowired
    BikeService BikeService;

    @CrossOrigin(origins = "http://localhost:63342", allowCredentials = "true")
    @ApiOperation(value = "Retrieve all bikes")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "All bike retrieved successfully"), @ApiResponse(code =
            401, message = "Not authorized to access this data"), @ApiResponse(code = 403, message = "This data is forbidden"), @ApiResponse(code = 404, message = "This resource is not found")})
    @GetMapping(value = "/bikes/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Bike> all() {
        return BikeService.all();
    }

    @ApiOperation(value = "Retrieve amount of bikes first")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Amount of bikes retrieved successfully"), @ApiResponse(code =
            401, message = "Not authorized to access this data"), @ApiResponse(code = 403, message = "This data is forbidden"), @ApiResponse(code = 404, message = "This resource is not found")})
    @GetMapping(value = "/bikes/all/{amount}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Bike> getAmount(@PathVariable("amount") int amount) {

        return BikeService.getAmount(amount);
    }

    @ApiOperation("Get a Bike' data by id")
    @GetMapping(value = "/bikes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bike> findById(@ApiParam("Bike's id of the Bike would be retrieved") @Valid @PathVariable("id") int id) throws ResourceNotFoundException {
        Bike acc = BikeService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Bike not found for " +
                "this id " +
                ":: " + id));
        return ResponseEntity.ok().body(acc);
    }


    @ApiOperation("Insert a Bike ")
    @PostMapping(value = "/bikes", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Boolean> insert(@ApiParam(value = "Bike's data would like to insert ", required = true) @RequestBody Bike Bike) {
        Optional<Bike> op = BikeService.findById(Bike.getBikeId());
        Bike acc;
        Map<String, Boolean> map = new HashMap<>();
        if (!op.isPresent()) {
            BikeService.insert(Bike);
            map.put("inserted", Boolean.TRUE);
            return map;
        }
        map.put("inserted", Boolean.FALSE);
        return map;

    }

    @ApiOperation("Update an bike")
    @PutMapping(value = "/bikes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bike> update(@ApiParam(value = "Bike's id of the Bike would be edit", required = true) @PathVariable("id") int id, @ApiParam(value = "Bike's data of the Bike would be edit", required = true) @Valid @RequestBody Bike Bike) throws ResourceNotFoundException {
        Bike acc = BikeService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Bike not found for this " +
                "id :: " + id));
        BikeService.updateById(id, Bike);
        return ResponseEntity.ok().body(acc);
    }


    @DeleteMapping(value = "/bikes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Boolean> delete(@ApiParam(value = "Bike's id of the Bike would be delete", required = true) @PathVariable("id") int id) throws ResourceNotFoundException {
        Bike acc = BikeService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Bike not found for this id :: " + id));
        BikeService.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
