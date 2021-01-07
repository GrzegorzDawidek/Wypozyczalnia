package com.mgrapp.GrzegorzDawidek.mgrapp.repository;

import com.mgrapp.GrzegorzDawidek.mgrapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
