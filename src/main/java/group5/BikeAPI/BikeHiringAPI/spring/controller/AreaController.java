package group5.BikeAPI.BikeHiringAPI.spring.controller;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Area;
import group5.BikeAPI.BikeHiringAPI.spring.service.AreaService;
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
@Api(value = "Area management", description = "Operatiing area in BikeHiringApplication")
public class AreaController {
    @Autowired
    AreaService areaService;

    @ApiOperation(value = "Retrieve all area")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "All area retrieved successfully"), @ApiResponse(code =
            401, message = "Not authorized to access this data"), @ApiResponse(code = 403, message = "This data is forbidden"), @ApiResponse(code = 404, message = "This resource is not found")})
    @GetMapping(value = "/areas/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Area> all() {
        return areaService.all();
    }

    @ApiOperation("Get a Area' data by id")
    @GetMapping(value = "/areas/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Area> findById(@ApiParam("Area's id of the area would be retrieved") @Valid @PathVariable("id") int id) throws ResourceNotFoundException {
        Area acc = areaService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Area not found for " +
                "this id " +
                ":: " + id));
        return ResponseEntity.ok().body(acc);
    }


    @ApiOperation("Insert a Area ")
    @PostMapping(value = "/areas", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Boolean> insert(@ApiParam(value = "Area's data would like to insert ", required = true) @RequestBody Area area) {
        Optional<Area> op = areaService.findById(area.getAreaId());
        Area acc;
        Map<String, Boolean> map = new HashMap<>();
        if (op==null) {
            areaService.insert(area);
            map.put("inserted", Boolean.TRUE);
            return map;
        }
        map.put("inserted", Boolean.FALSE);
        return map;

    }

    @ApiOperation("Update an area")
    @PutMapping(value = "/areas/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Area> update(@ApiParam(value = "Area's id of the area would be edit", required = true) @PathVariable("id") int id, @ApiParam(value = "Area's data of the area would be edit", required = true) @Valid @RequestBody Area area) throws ResourceNotFoundException {
        Area acc = areaService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Area not found for this " +
                "id :: " + id));
        areaService.updateById(id, area);
        return ResponseEntity.ok().body(acc);
    }


    @DeleteMapping(value = "/areas/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Boolean> delete(@ApiParam(value = "Area's id of the area would be delete", required = true) @PathVariable("id") int id) throws ResourceNotFoundException {
        Area acc = areaService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Area not found for this id :: " + id));
        areaService.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
