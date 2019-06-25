package group5.BikeAPI.BikeHiringAPI.spring.controller;

import group5.BikeAPI.BikeHiringAPI.spring.domain.BikeSlot;
import group5.BikeAPI.BikeHiringAPI.spring.service.BikeSlotService;
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
@Api(value = "Slot management", description = "Operatiing slot in BikeHiringApplication")
public class SlotController {
    @Autowired
    BikeSlotService bikeSlotService;

    @ApiOperation(value = "Retrieve all slot")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "All slot retrieved successfully"), @ApiResponse(code =
            401, message = "Not authorized to access this data"), @ApiResponse(code = 403, message = "This data is forbidden"), @ApiResponse(code = 404, message = "This resource is not found")})
    @GetMapping(value = "/slot/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BikeSlot> all() {
        return bikeSlotService.all();
    }

    @ApiOperation("Get a Slot' data by id")
    @GetMapping(value = "/slot/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BikeSlot> findById(@ApiParam("Slot's id of the Slot would be retrieved") @Valid @PathVariable("id") int id) throws ResourceNotFoundException {
        BikeSlot slot = bikeSlotService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Slot not found for " +
                "this id " +
                ":: " + id));
        return ResponseEntity.ok().body(slot);
    }


    /*@ApiOperation("Insert a Slot ")
    @PostMapping(value = "/slot", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Boolean> insert(@ApiParam(value = "Slot's data would like to insert ", required = true) @RequestBody BikeSlot slot) {
        *//*Optional<BikeSlot> op = bikeSlotService.findById(slot.get);*//*
        *//*Slot slot1;*//*
        Map<String, Boolean> map = new HashMap<>();
        if (!op.isPresent()) {
            bikeSlotService.insert(slot);
            map.put("inserted", Boolean.TRUE);
            return map;
        }
        map.put("inserted", Boolean.FALSE);
        return map;

    }*/

    @ApiOperation("Update slot")
    @PutMapping(value = "/slot/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BikeSlot> update(@ApiParam(value = "Slot's id of the Slot would be edit", required = true) @PathVariable("id") int id, @ApiParam(value = "Slot's data of the Slot would be edit", required = true) @Valid @RequestBody BikeSlot slot) throws ResourceNotFoundException {
        BikeSlot acc = bikeSlotService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Slot not found for this " +
                "id :: " + id));

        return ResponseEntity.ok().body(acc);
    }


    @DeleteMapping(value = "/slot/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Boolean> delete(@ApiParam(value = "Slot's id of the Slot would be delete", required = true) @PathVariable("id") int id) throws ResourceNotFoundException {
        BikeSlot acc = bikeSlotService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Slot not found for this id :: " + id));
        bikeSlotService.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
