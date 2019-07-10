package group5.BikeAPI.BikeHiringAPI.spring.controller;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Bike;
import group5.BikeAPI.BikeHiringAPI.spring.domain.BikeSlot;
import group5.BikeAPI.BikeHiringAPI.spring.service.SlotService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Api(value = "Slot management", description = "Operating slot in BikeHiringApplication")
@RequestMapping
public class SlotController {


    @Autowired
    SlotService slotService;


    
    
//    @ApiOperation("Get slot by bikeid")
//    @GetMapping(value = "/bikes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<BikeSlot> findById(@ApiParam("Id of the Bike would be retrieved") @Valid @PathVariable("id") Integer id)
//            throws ResourceNotFoundException {
//        Bike acc = slotService.findById(id).orElseThrow(() ->
//                new ResourceNotFoundException("Bike not found for this id " +
//                        ":: " + id));
//
//        return ResponseEntity.ok().body(acc);
//    }



}
