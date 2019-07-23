package group5.BikeAPI.BikeHiringAPI.spring.controller;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Account;
import group5.BikeAPI.BikeHiringAPI.spring.domain.Garage;
import group5.BikeAPI.BikeHiringAPI.spring.service.AccountService;
import group5.BikeAPI.BikeHiringAPI.spring.service.GarageService;
import io.swagger.annotations.*;
import org.hibernate.TransientPropertyValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@Api(value = "Account management", description = "Operating account in BikeHiringApplication")
public class AccountController {

    @Autowired
    AccountService accountService;


    @ApiOperation(value = "Retrieve all accounts")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "All accounts retrieved successfully"),
            @ApiResponse(code = 401, message = "Not authorized to access this data"),
            @ApiResponse(code = 403, message = "This data is forbidden"),
            @ApiResponse(code = 404, message = "This resource is not found")})
    @GetMapping(value = "/accounts/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Account> all() {
        return accountService.all();
    }

    @ApiOperation("Get a account' data by id")
    @GetMapping(value = "/accounts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> findById(@ApiParam(value = "Account id would be retrieved"
    ) @Valid @PathVariable("id") Integer id) throws ResourceNotFoundException {
        Account acc = accountService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + id));
        return ResponseEntity.ok().body(acc);
    }





    @ApiOperation("Insert a account ")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Insert successfully"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 403, message = "This data is forbidden"),
            @ApiResponse(code = 204, message = "Duplicate email"),
    })
    @PostMapping(value = "/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> insert(@ApiParam(value = "Account's data would like to insert ", required = true)
                                          @RequestBody Account account) {

        if (accountService.insert(account)) {
            int insert_id = accountService.getLastIndex();
            return ResponseEntity.created(URI.create("/accounts/" + insert_id)).body(accountService.findById(insert_id).get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @Autowired
    GarageService garageService;

    @ApiOperation("Link an account to new garage by their id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " successfully"),
            @ApiResponse(code = 400, message = "Bad request"),


    })
    @PostMapping(value = "/accounts/{account_id}/garages/{gid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> linkAccountToGarage(@ApiParam(value = "Link account to an garage by their id", required = true)
                                                       @PathVariable("account_id") int account_id, @PathVariable("gid") int gid) {

        Account acc = accountService.findById(account_id).orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + account_id));
        Garage garage = new Garage();
        garage.setId(gid);
        acc.setGarage(garage);

            accountService.updateById(account_id, acc);


        return ResponseEntity.ok().body(accountService.findById(account_id).get());
    }


//    @ApiOperation("Check if exist an account by its email ")
//    @PostMapping(value = "/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Map<String, Boolean> insert(@RequestBody String email) {
//        Optional<Account> op = accountService.findByEmail(email);
//        Account acc;
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



    @ApiOperation("Get an account by email")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Insert successfully"),
            @ApiResponse(code = 404, message = "Not found")
    })

    @GetMapping(value = "/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> getByEmail(
            @ApiParam(value = "Email of account would be retrieved", required = true)
            @Valid @RequestParam("email") String email) throws ResourceNotFoundException {
        Account acc = accountService.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("Account not found for this email :: " + email));
        return ResponseEntity.ok().body(acc);
    }


    @ApiOperation("Delete an acocunt")
    @DeleteMapping(value = "/accounts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Boolean> delete(
            @ApiParam(value = "Account's id of the account would be delete",
                    required = true) @PathVariable("id") Integer id)

            throws ResourceNotFoundException {
        Account acc = accountService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + id));
        accountService.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;


    }

    //todo create money transaction
}
