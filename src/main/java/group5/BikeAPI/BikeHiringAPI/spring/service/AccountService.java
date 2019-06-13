package group5.BikeAPI.BikeHiringAPI.spring.service;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

     List<Account> all();

     void insert(Account a);

     void deleteById(int id);

     void updateById(int id, Account a);

     Optional<Account> findById(int id);
}
