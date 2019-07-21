package group5.BikeAPI.BikeHiringAPI.spring.service;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Account;
import group5.BikeAPI.BikeHiringAPI.spring.domain.Garage;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    List<Account> all();

    boolean insert(Account a);

    boolean insertGarage(Garage garage);

    boolean deleteById(int id);

    boolean updateById(int id, Account a);

    Optional<Account> findById(int id);

    Account findByEmail(String email);

    int getLastIndex();


}
