package group5.BikeAPI.BikeHiringAPI.spring.controller;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Bike;
import group5.BikeAPI.BikeHiringAPI.spring.domain.Garage;
import group5.BikeAPI.BikeHiringAPI.spring.domain.Slot;
import group5.BikeAPI.BikeHiringAPI.spring.service.BikeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(value = "Bike management", description = "Operating bike in BikeHiringApplication")
@RequestMapping
public class BikeController {

    @Autowired
    BikeService BikeService;


    @CrossOrigin(origins = "http://fe-bk.surge.sh", allowCredentials = "true")
    @ApiOperation(value = "Get all bikes")
    @GetMapping(value = "/bikes/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Bike> all() {
        return BikeService.all();
    }


    @CrossOrigin(origins = "http://fe-bk.surge.sh", allowCredentials = "true")
    @ApiOperation(value = "Delete bike")
    @DeleteMapping(value = "/bikes/{bid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bike> delete(@PathVariable("bid") int bid) {
        BikeService.deleteById(bid);
        return ResponseEntity.ok().build();
    }


    @CrossOrigin(origins = "http://fe-bk.surge.sh", allowCredentials = "true")
    @ApiOperation(value = "Get all bikes by garageid")
    @GetMapping(value = "/bikes/garages/{gid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Bike> getBikesByGid(@PathVariable("gid") int gid) {
        return BikeService.findByGarageId(gid);
    }


    @ApiOperation("Get bike by id")
    @GetMapping(value = "/bikes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bike> findById(@ApiParam("Id of the Bike would be retrieved") @Valid @PathVariable("id") Integer id)
            throws ResourceNotFoundException {
        Bike acc = BikeService.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Bike not found for this id " +
                        ":: " + id));
        return ResponseEntity.ok().body(acc);
    }


    @ApiOperation("Update bike by id")
    @PutMapping(value = "/bikes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bike> update(@ApiParam(value = "Id of the Bike would be updated", required = true)
                                       @PathVariable("id") Integer id, @ApiParam(value = "Data would be updated", required = true)
                                       @Valid @RequestBody Bike Bike) throws ResourceNotFoundException {
        Bike acc = BikeService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Bike not found for this " +
                "id :: " + id));


// update bike with id= id and data in Bike
        BikeService.updateById(id, Bike);
        return ResponseEntity.ok().body(Bike);
    }

    @ApiOperation("Update bike slot list by bikeid")
    @PutMapping(value = "/bikes/{id}/slots", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bike> updateSlots(@ApiParam(value = "Id of the Bike would be updated", required = true)
                                            @PathVariable("id") Integer id, @ApiParam(value = "Slot list would be updated", required = true)
                                            @Valid @RequestBody List<Slot> slotList) throws ResourceNotFoundException {
        Bike acc = BikeService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Bike not found for this " +
                "id :: " + id));

        BikeService.updateSlotList(id, slotList);
        return ResponseEntity.ok().body(BikeService.findById(id).get());
    }

    @PostMapping(value = "/bikes/garages/{gid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bike> createAndInsertIntoGarage(
            @RequestBody Bike bike, @PathVariable("gid") Integer gid) throws
            ResourceNotFoundException {

        //garage id would be insert in bike
        Garage garage = new Garage();
        garage.setId(gid);
        bike.setGarage(garage);
        BikeService.insert(bike);
        return ResponseEntity.ok().build();
    }

//    @DeleteMapping(value = "/bikes/{bid}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Bike> createAndInsertIntoGarage(
//            @PathVariable("bid") int bid) throws
//            ResourceNotFoundException {
//        BikeService.deleteById(bid);
//        return ResponseEntity.ok().build();
//
//    }

}
