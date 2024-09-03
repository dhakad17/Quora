package com.Quora.Quora.Controllers;

import com.Quora.Quora.Models.User;
import com.Quora.Quora.Services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService)
    {
        this.userService=userService;
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<User> getUser(@PathVariable UUID uuid)
    {
        User user=this.userService.getUser(uuid);

        return ResponseEntity.ok(user);
    }

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        User u = this.userService.createUser(user);
        return new ResponseEntity<>(u, HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<User> updateUser(@PathVariable UUID uuid,@RequestBody User user)
    {
        User updatedUser= this.userService.updateUser(uuid, user);

        return ResponseEntity.ok(user);
    }

}
