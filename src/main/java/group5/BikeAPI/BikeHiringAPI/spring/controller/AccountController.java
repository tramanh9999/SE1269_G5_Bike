package group5.BikeAPI.BikeHiringAPI.spring.controller;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Account;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import group5.BikeAPI.BikeHiringAPI.spring.service.AccountService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.awt.*;
import java.util.List;


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
    public ResponseEntity<Account> findById(@ApiParam(value = "Account's id of the account would be retrieved",
            defaultValue = "new Integer(1)" ) @Valid @PathVariable("id") Integer id) throws ResourceNotFoundException {
        Account acc = accountService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + id));
        return ResponseEntity.ok().body(acc);
    }


    @ApiOperation("Insert a account ")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Insert successfully"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 403, message = "This data is forbidden"),
            })
    @PostMapping(value = "/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> insert(@ApiParam(value = "Account's data would like to insert ", required = true)
                                       @RequestBody Account account) {
        accountService.insert(account);

        return ResponseEntity.ok().body(accountService.findById(accountService.getLastIndex()).get());

    }
    //todo: get garage of acocunt



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

    @ApiOperation("Update an acocunt")
    @PutMapping(value = "/accounts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> update(
            @ApiParam(value = "Account's id of the account would be edit",
           required = true)
          @PathVariable("id") Integer id, @ApiParam(value = "Account's data of the account would be edit", required = true) @Valid @RequestBody Account account) throws ResourceNotFoundException {
        Account acc = accountService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + id));
        acc.setBalance(account.getBalance());
        acc.setEmail(account.getEmail());
        acc.setBalance(account.getBalance());

        accountService.updateById(id, acc);
        return ResponseEntity.ok().body(acc);
    }


    @ApiOperation("Delete an acocunt")
    @DeleteMapping(value = "/accounts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Boolean> delete(
      @ApiParam(value = "Account's id of the account would be delete",
              required = true ) @PathVariable("id") Integer id)

            throws ResourceNotFoundException {
        Account acc = accountService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + id));
        accountService.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
