package com.acciojob.Book.My.Show.Repository;

import com.acciojob.Book.My.Show.Entities.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Integer> {
}
