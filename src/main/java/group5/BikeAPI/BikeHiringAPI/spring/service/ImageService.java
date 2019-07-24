package group5.BikeAPI.BikeHiringAPI.spring.service;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Image;
import group5.BikeAPI.BikeHiringAPI.spring.domain.Image;

import java.util.List;
import java.util.Optional;

public interface ImageService {

    List<Image> all();



    boolean insertImage(String  url);

    boolean deleteById(int id);

    boolean updateById(int id, Image a);

    Optional<Image> findById(int id);

    int getLastIndex();


}
