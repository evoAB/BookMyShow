package com.acciojob.Book.My.Show.Repository;

import com.acciojob.Book.My.Show.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByEmailId(String emailId);

}
