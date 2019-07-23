package group5.BikeAPI.BikeHiringAPI.spring.repository;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {


    @Query("select max(id) from Account ")
    int getLastIndex();

    @Query(value = "select a from Account a where a.email = :email")
    Account findFirstByEmailIsLike(@Param("email") String email);


}
