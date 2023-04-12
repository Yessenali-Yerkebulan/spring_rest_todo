package com.example.spring_todo.service;


import com.example.spring_todo.entity.UserEntity;
import com.example.spring_todo.exception.UserAlreadyExistException;
import com.example.spring_todo.exception.UserNotFoundException;
import com.example.spring_todo.model.User;
import com.example.spring_todo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if(userRepo.findByUsername(user.getUsername())!=null){
            throw new UserAlreadyExistException("User with this name is already exist!");
        }
        return userRepo.save(user);
    }

    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if(user==null){
            throw new UserNotFoundException("User not found!");
        }
        return User.toModel(user);
    }

    public Long delete(Long id){
        userRepo.deleteById(id);
        return id;
    }
}
