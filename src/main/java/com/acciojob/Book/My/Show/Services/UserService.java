package com.acciojob.Book.My.Show.Services;

import com.acciojob.Book.My.Show.Entities.User;
import com.acciojob.Book.My.Show.Repository.UserRepository;
import com.acciojob.Book.My.Show.Request.AddUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String addUser(AddUserRequest addUserRequest){

        User user = User.builder().emailId(addUserRequest.getEmailId())
                .name(addUserRequest.getName())
                .build();

        userRepository.save(user);
        return "User has been saved to the DB";

    }
}
