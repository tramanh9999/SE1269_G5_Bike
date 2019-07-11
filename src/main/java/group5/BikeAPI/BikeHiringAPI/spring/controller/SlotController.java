package group5.BikeAPI.BikeHiringAPI.spring.controller;

import group5.BikeAPI.BikeHiringAPI.spring.service.SlotService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
