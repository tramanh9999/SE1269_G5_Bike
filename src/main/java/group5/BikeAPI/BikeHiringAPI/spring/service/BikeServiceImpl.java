package group5.BikeAPI.BikeHiringAPI.spring.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import group5.BikeAPI.BikeHiringAPI.spring.domain.Bike;
import group5.BikeAPI.BikeHiringAPI.spring.domain.Slot;
import group5.BikeAPI.BikeHiringAPI.spring.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


    @PostConstruct
    void initializeHashOperation() {
//        hashOperations = redisTemplate.opsForSet();
//        for (Bike x : bikeRepository.findAll()) {
//            hashOperations.add("bikes", gson.toJson(x));
//        }
//        redisTemplate.expire("bikes", 100, TimeUnit.DAYS);
    }

    @Override
    public List<Bike> getAmount(int amount) {
//        Set<Object> bikes = hashOperations.members("bikes");
//
//        Iterator<Object> iterator = bikes.iterator();
//        List<Bike> bk = new ArrayList<>();
//        while (iterator.hasNext()) {
//            if (bikes.size() == 10) {
//                return bk;
//            }
//            bk.add(gson.fromJson(iterator.next().toString(), Bike.class));
//        }
//        return bk;
        return new ArrayList<>();
    }

    @Override
    public List<Bike> all() {
//        Set<Object> bikes = hashOperations.members("bikes");
//        Iterator<Object> iterator = bikes.iterator();
//        List<Bike> bk = new ArrayList<>();
//        while (iterator.hasNext()) {
//            bk.add(gson.fromJson(iterator.next().toString(), Bike.class));
//        }

        List<Bike> bk = bikeRepository.findAll();


        return bk;
    }

    @Override
    public void updateSlotList(int id, List<Slot> slotList) {
        findById(id).get().setSlot_list(slotList);

    }

    public int getLastIndex() {
        return bikeRepository.getLastIndex();
    }

    @Override
    public boolean insert(Bike a) {
//        try {
//            Gson gson = new Gson();
//            Long x = hashOperations.add("bikes", gson.toJson(a));
//            if (x == null || x < 1) {
//                return false;
//            }
//        } catch (Exception e) {
//            System.out.println("Error");
//            e.printStackTrace();
//            return false;
//        }

        //todo check save to main db
        bikeRepository.save(a);
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        bikeRepository.deleteById(id);
        Optional<Bike> bk = bikeRepository.findById(id);
        if (bk.isPresent()) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateById(int id, Bike a) {
        if (bikeRepository.existsById(id)) {
            a.setId(id);
            bikeRepository.save(a);
            return true;
        }
        return false;


    }

    @Override
    public Optional<Bike> findById(int id) {
        Optional<Bike> op = bikeRepository.findById(id);
        return op;
    }
}
