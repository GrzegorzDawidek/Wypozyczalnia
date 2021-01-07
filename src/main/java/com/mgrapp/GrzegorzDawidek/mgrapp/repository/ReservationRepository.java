package com.mgrapp.GrzegorzDawidek.mgrapp.repository;

import com.mgrapp.GrzegorzDawidek.mgrapp.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    public List<Reservation> findByItemid(Long itemid);

}
