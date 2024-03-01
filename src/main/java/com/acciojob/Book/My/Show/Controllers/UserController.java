package com.acciojob.Book.My.Show.Controllers;

import com.acciojob.Book.My.Show.Request.AddUserRequest;
import com.acciojob.Book.My.Show.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("addUser")
    public String addUser(@RequestBody AddUserRequest addUserRequest){
        String result = userService.addUser(addUserRequest);
        return result;
    }

    @DeleteMapping("removeUser")
    public ResponseEntity removeUser(@RequestParam ("userId") Integer userId){
        try{
            String result = userService.removeUser(userId);
            return new ResponseEntity(result, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }
}
