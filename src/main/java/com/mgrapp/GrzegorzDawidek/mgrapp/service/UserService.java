package com.mgrapp.GrzegorzDawidek.mgrapp.service;


import com.mgrapp.GrzegorzDawidek.mgrapp.model.User;
import com.mgrapp.GrzegorzDawidek.mgrapp.model.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);

}
