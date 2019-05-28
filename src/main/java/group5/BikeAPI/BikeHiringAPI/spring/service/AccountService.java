package group5.BikeAPI.BikeHiringAPI.spring.service;

import group5.BikeAPI.BikeHiringAPI.spring.repository.AccountRepository;
import group5.BikeAPI.BikeHiringAPI.spring.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface AccountService {

    public List<Account> all();

    public void insert(Account a);

    public void deleteById(int id);

    public void updateById(int id, Account a);

    public Optional<Account> findById(int id);
}
