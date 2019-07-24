package group5.BikeAPI.BikeHiringAPI.spring.service;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Image;
import group5.BikeAPI.BikeHiringAPI.spring.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepository imageRepository;

    @Override
    public List<Image> all() {
        return imageRepository.findAll();
    }

    @Override
    public boolean insertImage(String url) {

        Image image= new Image();
        image.setUrl(url);
        imageRepository.save(image);
        return true;
    }


    @Override
    public boolean deleteById(int id) {
        imageRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean updateById(int id, Image a) {
        a.setId(id);
        imageRepository.save(a);
        return true;
    }

    @Override
    public Optional<Image> findById(int id) {
         return imageRepository.findById(id);

    }

    @Override
    public int getLastIndex() {
        return 0;
    }
}
