package com.engineeringgec.Services;

import com.engineeringgec.Entity.User;
import com.engineeringgec.Repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;



    public void saveEntry(User user){
        userRepository.save(user);
    }
    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId objectId){
        return userRepository.findById(objectId);
    }

    public void deleteById(ObjectId id){
        userRepository.deleteById(id);
    }

    public User findByUserName(String UserName){
        return userRepository.findByUserName(UserName);
    }

}
