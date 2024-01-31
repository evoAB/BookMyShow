package com.acciojob.Book.My.Show.Repository;

import com.acciojob.Book.My.Show.Entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
