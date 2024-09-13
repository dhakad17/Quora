package com.Quora.Quora.Services;


import com.Quora.Quora.Models.User;
import com.Quora.Quora.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

     private UserRepository userRepository;

     public UserService(UserRepository userRepository)
     {
         this.userRepository=userRepository;
     }

     // creating user
     public User createUser(User user)
     {
        return this.userRepository.save(user);
     }
     public boolean checkUser(UUID uuid)
     {
         var user=this.userRepository.findById(uuid);

         return user.isEmpty();
     }

     //getting user
     public User getUser(UUID uuid)
     {
         return this.userRepository.findById(uuid).orElseThrow(()-> new RuntimeException("User not found"));
     }

     public User getUserByEmail(String email)
     {
         return this.userRepository.findByEmail(email);
     }

     // updating user
    public User updateUser(UUID uuid, User userDetails) {
        User user = this.userRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());
        user.setBio(userDetails.getBio());
        LocalDateTime localDateTime = LocalDateTime.now();

        // Convert LocalDateTime to Date
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        user.setUpdatedAt(date);
        return this.userRepository.save(user);
    }
}
