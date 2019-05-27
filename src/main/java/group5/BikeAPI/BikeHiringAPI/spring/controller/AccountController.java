package group5.BikeAPI.BikeHiringAPI.spring.controller;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Account;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import group5.BikeAPI.BikeHiringAPI.spring.service.AccountService;
import org.springframework.web.client.ResourceAccessException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.awt.*;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
@Api(value = "Account management", description = "Operation account in BikeHiringApplication")
public class AccountController {

    @Autowired
    AccountService accountService;


    @ApiOperation(value = "Retrieve all accounts")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "All accounts retrieved successfully"),
            @ApiResponse(code = 401, message = "Not authorized to access this data"),
            @ApiResponse(code = 400, message = "This data is forbidden"),
            @ApiResponse(code = 404, message = "This resource is not found")})
    @GetMapping(value = "/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Account> all() {
        return accountService.all();
    }

    @ApiOperation("Get a account' data by id")
    @GetMapping(value = "/account/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> findById(@ApiParam("Account's id of the account would be retrieved") @Valid @PathVariable("id") int id) throws ResourceNotFoundException {
        Account acc = accountService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + id));
        return ResponseEntity.ok().body(acc);
    }

    @PostMapping(value = "/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Boolean> insert(@ApiParam(value = "Account's data would like to insert ", required = true)
                                       @RequestBody Account account) {
        Optional<Account> op = accountService.findById(account.getId());
        Account acc;
        Map<String, Boolean> map = new HashMap<>();
        if (!op.isPresent()) {


            accountService.insert(account);
            map.put("inserted", Boolean.TRUE);
            return map;
        }
        map.put("inserted", Boolean.FALSE);
        return map;

    }


    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> update(@ApiParam(value = "Account's id of the account would be edit", required = true)
                                          @PathVariable("id") int id, @ApiParam(value = "Account's data of the account would be edit", required = true) @Valid @RequestBody Account account) throws ResourceNotFoundException {
        Account acc = accountService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + id));
        acc.setBalance(account.getBalance());
        acc.setEmail(account.getEmail());
        acc.setBalance(account.getPhone());

        accountService.updateById(id, acc);
        return ResponseEntity.ok().body(acc);
    }


    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Boolean> delete(@ApiParam(value = "Account's id of the account would be delete", required = true) @PathVariable("id") int id)
            throws ResourceNotFoundException {
        Account acc = accountService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + id));
        accountService.deleteById(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
