package com.mgrapp.GrzegorzDawidek.mgrapp.service;

import com.mgrapp.GrzegorzDawidek.mgrapp.model.Reservation;
import com.mgrapp.GrzegorzDawidek.mgrapp.model.User;
import com.mgrapp.GrzegorzDawidek.mgrapp.model.dto.ReserveArticleDto;
import com.mgrapp.GrzegorzDawidek.mgrapp.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;


    public void save(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public List<Reservation> listAll() {
        return reservationRepository.findAll();
    }

    public boolean reserveArticle(ReserveArticleDto reserveArticleDto, User user) {

        List<Reservation> listReservation = reservationRepository.findByItemid(Long.parseLong(reserveArticleDto.getArticleid()));

        boolean canReserve = true;
        for (Reservation reservation : listReservation) {
            if (reservation.getDate().equals(reserveArticleDto.getReservedate())) {
                boolean condition1 = reservation.getStarthour().isBefore(reserveArticleDto.getEndreserve());
                boolean condition2 = reserveArticleDto.getStartreserve().isBefore(reservation.getEndhour());
                if (condition1 && condition2) {
                    canReserve = false;
                }
            }
        }
        if (canReserve) {

            Reservation reservation = new Reservation(
                    reserveArticleDto.getReservedate(),
                    Long.parseLong(reserveArticleDto.getArticleid()),
                    user.getId(),
                    reserveArticleDto.getStartreserve(),
                    reserveArticleDto.getEndreserve()
            );

            reservationRepository.save(reservation);
            return true;
        } else {
            return false;
        }

    }


}
