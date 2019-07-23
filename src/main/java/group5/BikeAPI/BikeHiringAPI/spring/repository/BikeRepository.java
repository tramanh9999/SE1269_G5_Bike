package group5.BikeAPI.BikeHiringAPI.spring.repository;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Bike;
import group5.BikeAPI.BikeHiringAPI.spring.domain.Garage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Integer> {
    @Query("select  max (id) from Bike")
    int getLastIndex();


    @Query(value = "select b from tbl_bike b  where b.garage_id=?1", nativeQuery = true)
    List<Bike> findAllByGarageId( int gid);
}
