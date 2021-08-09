package com.proiect_PS.resurse.security;

import com.proiect_PS.resurse.model.User;
import com.proiect_PS.resurse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User userFromDB=userRepository.findFirstByUserName(username);
        if(userFromDB==null){
            throw new UsernameNotFoundException("Do not found " +username);
        }

        UserDetails userDetails=org.springframework.security.core.userdetails.User.withUsername(userFromDB.getUserName()).password(userFromDB.getPassword()).roles(userFromDB.getClass().getSimpleName().toUpperCase()).build();
        return userDetails;
    }
}
