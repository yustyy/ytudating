package com.ytudating.ytudating.webAPI.controllers;

import com.ytudating.ytudating.business.abstracts.UserService;
import com.ytudating.ytudating.core.security.JwtService;
import com.ytudating.ytudating.core.utilities.result.Result;
import com.ytudating.ytudating.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@CrossOrigin(origins = {"http://localhost:3000","http://localhost:3000/signup","http://localhost:3000/login" })
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserService userService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @PostMapping("/generateToken")
    public String generateToken(@RequestParam String username, @RequestParam String password){
    Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    if(authentication.isAuthenticated()){
        return jwtService.generateToken(username);
    }
    throw new UsernameNotFoundException("invalid username");
}

    @PostMapping("/registerUser")
    public Result registerUser(@RequestBody User user){
        return userService.addUser(user);
    }

}
