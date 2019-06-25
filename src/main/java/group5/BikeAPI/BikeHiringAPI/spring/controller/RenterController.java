package group5.BikeAPI.BikeHiringAPI.spring.controller;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Renter;
import group5.BikeAPI.BikeHiringAPI.spring.service.RenterService;
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
@Api(value = "Renter management", description = "Operatiing renter in BikeHiringApplication")
public class RenterController {
    @Autowired
    RenterService renterService;

    @ApiOperation(value = "Retrieve all renter")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "All renter retrieved successfully"), @ApiResponse(code =
            401, message = "Not authorized to access this data"), @ApiResponse(code = 403, message = "This data is forbidden"), @ApiResponse(code = 404, message = "This resource is not found")})
    @GetMapping(value = "/renters/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Renter> all() {
        return renterService.all();
    }

    @ApiOperation("Get a Renter' data by id")
    @GetMapping(value = "/renters/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Renter> findById(@ApiParam("Renter's id of the renter would be retrieved") @Valid @PathVariable("id") int id) throws ResourceNotFoundException {
        Renter acc = renterService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Renter not found for " +
                "this id " +
                ":: " + id));
        return ResponseEntity.ok().body(acc);
    }


    @ApiOperation("Insert a renter ")
    @PostMapping(value = "/renters", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Boolean> insert(@ApiParam(value = "Renter's data would like to insert ", required = true) @RequestBody Renter renter) {
        Optional<Renter> op = renterService.findById(renter.getRenterId());
        Renter acc;
        Map<String, Boolean> map = new HashMap<>();
        if (op==null) {
            renterService.insert(renter);
            map.put("inserted", Boolean.TRUE);
            return map;
        }
        map.put("inserted", Boolean.FALSE);
        return map;

    }

    @ApiOperation("Update a renter")
    @PutMapping(value = "/renters/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Renter> update(@ApiParam(value = "Renter's id of the host would be edit", required = true) @PathVariable("id") int id, @ApiParam(value = "Renter's data of the host would be edit", required = true) @Valid @RequestBody Renter renter) throws ResourceNotFoundException {
        Renter acc = renterService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Renter not found for this " +
                "id :: " + id));
        renterService.updateById(id, renter);
        return ResponseEntity.ok().body(acc);
    }


    @DeleteMapping(value = "/renters/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Boolean> delete(@ApiParam(value = "Renter's id of the renter would be delete", required = true) @PathVariable("id") int id) throws ResourceNotFoundException {
        Renter acc = renterService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Renter not found for this id :: " + id));
        renterService.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
