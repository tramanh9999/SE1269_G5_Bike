package group5.BikeAPI.BikeHiringAPI.spring.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import group5.BikeAPI.BikeHiringAPI.spring.domain.Bike;
import group5.BikeAPI.BikeHiringAPI.spring.repository.BikeRepository;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.swing.text.html.HTMLDocument;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class BikeServiceImpl implements BikeService {

    @Autowired
    BikeRepository bikeRepository;
    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    @Autowired
    ObjectMapper objectMapper;
    private SetOperations<String, Object> hashOperations;

    @Autowired
    Gson gson;

    public static void main(String[] args) {
        BikeServiceImpl bikeService = new BikeServiceImpl();
        bikeService.all();
    }

    @PostConstruct
    void initializeHashOperation() {
        hashOperations = redisTemplate.opsForSet();
//        for (Bike x : bikeRepository.findAll()) {
//            hashOperations.add("bikes", gson.toJson(x));
//        }
//        redisTemplate.expire("bikes", 10, TimeUnit.MINUTES);
    }

@Override
public List<Bike> getAmount(int amount){
    Set<Object> bikes = hashOperations.members("bikes");

    Iterator<Object> iterator = bikes.iterator();
    List<Bike> bk = new ArrayList<>();
    while (iterator.hasNext()) {
        if(bikes.size()==10){
            return bk;
        }
        bk.add(gson.fromJson(iterator.next().toString(), Bike.class));
    }
    return bk;
}
    @Override
    public List<Bike> all() {
        Set<Object> bikes = hashOperations.members("bikes");
        Iterator<Object> iterator = bikes.iterator();
        List<Bike> bk = new ArrayList<>();
        while (iterator.hasNext()) {
            bk.add(gson.fromJson(iterator.next().toString(), Bike.class));
        }
        return bk;
    }

    @Override
    public void insert(Bike a) {
        try {
            Gson gson = new Gson();
            hashOperations.add("bikes", gson.toJson(a));
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
//        bikeRepository.save(a);
    }

    @Override
    public void deleteById(int id) {
        bikeRepository.deleteById(id);
    }

    @Override
    public boolean updateById(int id, Bike a) {
        if (bikeRepository.existsById(id)) {
            a.setBikeId(id);
            bikeRepository.save(a);
            return true;
        }
        return false;


    }

    @Cacheable(value = "bike", condition = "#id>10")
    @Override
    public Optional<Bike> findById(int id) {
        Optional<Bike> op = bikeRepository.findById(id);
        return op;

    }
}
