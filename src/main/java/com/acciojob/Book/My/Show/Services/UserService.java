package com.acciojob.Book.My.Show.Services;

import com.acciojob.Book.My.Show.CustomException.InvalidUserId;
import com.acciojob.Book.My.Show.Entities.User;
import com.acciojob.Book.My.Show.Repository.UserRepository;
import com.acciojob.Book.My.Show.Request.AddUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String addUser(AddUserRequest addUserRequest){

        User user = User.builder().emailId(addUserRequest.getEmailId())
                .name(addUserRequest.getName())
                .build();

        User savedUser = userRepository.save(user);
        return "User has been saved to the DB with UserId : "+savedUser.getUserId();

    }

    public String removeUser(int userId) throws Exception{
        Optional<User> optionalUser=userRepository.findById(userId);
        if(optionalUser.isEmpty())
            throw new InvalidUserId("UserId not present");

        User user=optionalUser.get();
        userRepository.delete(user);
        return "User has been deleted from the DB";

    }
}
