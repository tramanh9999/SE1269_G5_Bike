package group5.BikeAPI.BikeHiringAPI.spring.controller;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Bike;
import group5.BikeAPI.BikeHiringAPI.spring.domain.Slot;
import group5.BikeAPI.BikeHiringAPI.spring.service.BikeService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.net.URI;
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
    @ApiOperation(value = "Get all bikes by garageid")
    @GetMapping(value = "/bikes/garages/gid", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Bike> getBikesByGid(@PathVariable("gid") int gid) {
        return BikeService.findByGarageId(gid);
    }
// todo get bike near bike


    @ApiOperation(value = "Get first amount of bikes")
    @GetMapping(value = "/bikes/all/{amount}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Bike> getAmount(@PathVariable("amount") Integer amount) {
        return BikeService.getAmount(amount);
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






    @CrossOrigin(origins = "http://fe-bk.surge.sh", allowCredentials = "true")
    @ApiOperation("Insert bike")
    @PostMapping(value = "/bikes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bike> insert(@ApiParam(value = "Bike's data would like to insert", required = true)
                                       @RequestBody Bike Bike) throws HttpClientErrorException.BadRequest {
        Bike.setId(0);
        BikeService.insert(Bike);
        URI uri= URI.create(String.valueOf(Bike.getId()));
        return ResponseEntity.created(uri).body(Bike);
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

        BikeService.updateSlotList(id,slotList);
        return ResponseEntity.ok().body(BikeService.findById(id).get());
    }

    @PostMapping(value = "/bikes/garages/{gid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bike> createAndInsertIntoGarage(
            @RequestBody Bike bike) throws
            ResourceNotFoundException {

        //garage id would be insert in bike
        BikeService.insert(bike);
        return ResponseEntity.ok().build();

    }

}
