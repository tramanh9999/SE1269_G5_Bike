package group5.BikeAPI.BikeHiringAPI.spring.controller;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Order;
import group5.BikeAPI.BikeHiringAPI.spring.service.OrderService;
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
@Api(value = "Order management", description = "Operatiing order in BikeHiringApplication")
public class OrderController {
    @Autowired
    OrderService orderService;

    @ApiOperation(value = "Retrieve all order")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "All order retrieved successfully"), @ApiResponse(code =
            401, message = "Not authorized to access this data"), @ApiResponse(code = 403, message = "This data is forbidden"), @ApiResponse(code = 404, message = "This resource is not found")})
    @GetMapping(value = "/orders/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> all() {
        return orderService.all();
    }

    @ApiOperation("Get a Order' data by id")
    @GetMapping(value = "/orders/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> findById(@ApiParam("Order's id of the area would be retrieved") @Valid @PathVariable("id") int id) throws ResourceNotFoundException {
        Order acc = orderService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order not found for " +
                "this id " +
                ":: " + id));
        return ResponseEntity.ok().body(acc);
    }


    @ApiOperation("Insert a order ")
    @PostMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Boolean> insert(@ApiParam(value = "Order's data would like to insert ", required = true) @RequestBody Order order) {
        Optional<Order> op = orderService.findById(order.getOrderId());
        Order acc;
        Map<String, Boolean> map = new HashMap<>();
        if (op==null) {
            orderService.insert(order);
            map.put("inserted", Boolean.TRUE);
            return map;
        }
        map.put("inserted", Boolean.FALSE);
        return map;

    }

    @ApiOperation("Update a order")
    @PutMapping(value = "/orders/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> update(@ApiParam(value = "Order's id of the order would be edit", required = true) @PathVariable("id") int id, @ApiParam(value = "Order's data of the host would be edit", required = true) @Valid @RequestBody Order order) throws ResourceNotFoundException {
        Order acc = orderService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order not found for this " +
                "id :: " + id));
        orderService.updateById(id, order);
        return ResponseEntity.ok().body(acc);
    }


    @DeleteMapping(value = "/orders/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Boolean> delete(@ApiParam(value = "Order's id of the order would be delete", required = true) @PathVariable("id") int id) throws ResourceNotFoundException {
        Order acc = orderService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + id));
        orderService.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
