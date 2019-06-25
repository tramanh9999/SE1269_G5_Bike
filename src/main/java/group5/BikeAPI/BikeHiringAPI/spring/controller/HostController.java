package group5.BikeAPI.BikeHiringAPI.spring.controller;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Host;
import group5.BikeAPI.BikeHiringAPI.spring.service.HostService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@Api(value = "Host management", description = "Operatiing host in BikeHiringApplication")
public class HostController {
    @Autowired
    HostService hostService;


    @GetMapping(value = "/host/gallery")
    public ModelAndView hostgala(){
        return new ModelAndView("forward:/view/hostGalery.html");
    }

    @ApiOperation(value = "Retrieve all host")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "All host retrieved successfully"), @ApiResponse(code =
            401, message = "Not authorized to access this data"), @ApiResponse(code = 403, message = "This data is forbidden"), @ApiResponse(code = 404, message = "This resource is not found")})
    @GetMapping(value = "/hosts/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Host> all() {
        return hostService.all();
    }

    @ApiOperation("Get a Host' data by id")
    @GetMapping(value = "/hosts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Host> findById(@ApiParam("Host's id of the host would be retrieved") @Valid @PathVariable("id") int id) throws ResourceNotFoundException {
        Host acc = hostService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Host not found for " +
                "this id " +
                ":: " + id));
        return ResponseEntity.ok().body(acc);
    }


    @ApiOperation("Insert a Host ")
    @PostMapping(value = "/hosts", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Boolean> insert(@ApiParam(value = "Host's data would like to insert ", required = true) @RequestBody Host host) {
        Optional<Host> op = hostService.findById(host.getHostId());
        Host acc;
        Map<String, Boolean> map = new HashMap<>();
        if (op==null) {
            hostService.insert(host);
            map.put("inserted", Boolean.TRUE);
            return map;
        }
        map.put("inserted", Boolean.FALSE);
        return map;

    }

    @ApiOperation("Update a host")
    @PutMapping(value = "/hosts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Host> update(@ApiParam(value = "Host's id of the host would be edit", required = true) @PathVariable("id") int id, @ApiParam(value = "Host's data of the host would be edit", required = true) @Valid @RequestBody Host host) throws ResourceNotFoundException {
        Host acc = hostService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Host not found for this " +
                "id :: " + id));
        hostService.updateById(id, host);
        return ResponseEntity.ok().body(acc);
    }


    @DeleteMapping(value = "/hosts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Boolean> delete(@ApiParam(value = "Host's id of the host would be delete", required = true) @PathVariable("id") int id) throws ResourceNotFoundException {
        Host acc = hostService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Host not found for this id :: " + id));
        hostService.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
