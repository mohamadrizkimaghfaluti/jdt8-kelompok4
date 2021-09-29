package com.example.MiniProjectUniversity.service;
import com.example.MiniProjectUniversity.model.User;
import com.example.MiniProjectUniversity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Id;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User getById(String id){
        User user1 = repository.getById(id);
        return user1;
    }

    private int randomNumber() {
        Random rnd = new Random();
        int number = rnd.nextInt(99999999);
        int k = Integer.parseInt(String.format("%08d", number));
        return k;
    }

}