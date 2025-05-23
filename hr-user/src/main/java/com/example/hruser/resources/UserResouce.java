package com.example.hruser.resources;

import com.example.hruser.entities.User;
import com.example.hruser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResouce {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/{id}")
    private ResponseEntity<User> buscarPorId(@PathVariable Long id) {
        User user = userRepository.findById(id).orElse(null);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(value = "/search")
    private ResponseEntity<User> buscarPorEmail(@RequestParam String email) {
        User user = userRepository.findByEmail(email).orElse(null);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
