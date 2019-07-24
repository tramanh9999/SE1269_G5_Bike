package group5.BikeAPI.BikeHiringAPI.spring.controller;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Account;
import group5.BikeAPI.BikeHiringAPI.spring.domain.Garage;
import group5.BikeAPI.BikeHiringAPI.spring.service.AccountService;
import group5.BikeAPI.BikeHiringAPI.spring.service.GarageService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@Api(value = "Garage management")
public class GarageController {

    @Autowired
    GarageService garageService;


    @ApiOperation(value = "Retrieve all ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "All retrieved successfully"),
            @ApiResponse(code = 401, message = "Not authorized to access this data"),
            @ApiResponse(code = 403, message = "This data is forbidden"),
            @ApiResponse(code = 404, message = "This resource is not found")})
    @GetMapping(value = "/garages/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Garage> all() {
        return garageService.all();
    }

    @ApiOperation("Get a data by id")
    @GetMapping(value = "/garages/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Garage> findById(
            @ApiParam(value = "Garage's id of the Garage would be retrieved")
            @Valid @PathVariable("id") Integer id)
            throws ResourceNotFoundException {
        Garage acc = garageService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Garage not found for this id :: " + id));
        return ResponseEntity.ok().body(acc);
    }


    @ApiOperation("Insert a Garage , return garage that just saved by id of post garage")
    @PostMapping(value = "/Garages", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Garage> insert
            (@ApiParam(value = "Garage's data would be inserted",
                    required = true)
             @RequestBody Garage Garage) {
        //set =0 to save new instance but not update old instance
        Garage.setId(0);
        garageService.insert(Garage);
        Optional<Garage> garageOptional = garageService.findById(garageService.getLastIndex());

        return ResponseEntity.ok().body(garageOptional.get());
    }

    @ApiOperation("Insert a Garage own by an account by account id, return garage that just saved by id of post garage")
    @PostMapping(value = "/Garages/accounts/{account_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Garage> insertByAccountId
            (@ApiParam(value = "Garage's data would be inserted",
                    required = true) @PathVariable int account_id,
             @RequestBody Garage garage) {

        Account account = accountService.findById(account_id).get();
        garageService.insert(garage);
        account.setGarage(garage);
        accountService.updateById(account_id, account);
        return ResponseEntity.ok().build();
    }


    @Autowired
    AccountService accountService;


//    @ApiOperation("Check if exist an Garage by its email ")
//    @PostMapping(value = "/Garages", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Map<String, Boolean> insert(@RequestBody String email) {
//        Optional<Garage> op = garageService.findByEmail(email);
//        Garage acc;
//        Map<String, Boolean> map = new HashMap<>();
//        if (!op.isPresent()) {
//
//            map.put("inserted", Boolean.TRUE);
//            return map;
//        }
//        map.put("inserted", Boolean.FALSE);
//        return map;
//
//    }

    @ApiOperation("Update an garage, return updated garage")
    @PutMapping(value = "/Garages/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Garage> update(
            @ApiParam(value = "Garage's id of the Garage would be edit", defaultValue = "0", required = true)
            @PathVariable("id") Integer id, @ApiParam(value = "Garage's data of the Garage would be edit", required = true) @Valid @RequestBody Garage garage) throws ResourceNotFoundException {
        Garage acc = garageService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Garage not found for this id :: " + id));


        garageService.updateById(id, garage);
        return ResponseEntity.ok().body(garageService.findById(id).get());
    }


    @ApiOperation("Delete an garage")
    @DeleteMapping(value = "/Garages/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Garage> delete
            (@ApiParam(value = "Garage's id of the Garage would be delete", defaultValue = "0", required = true)
             @PathVariable("id") Integer id)
            throws ResourceNotFoundException {
        Garage acc = garageService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Garage not found for this id :: " + id));
        garageService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
