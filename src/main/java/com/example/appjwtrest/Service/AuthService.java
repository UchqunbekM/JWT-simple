package com.example.appjwtrest.Service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AuthService implements UserDetailsService {

    List<User> userList = new ArrayList<>(Arrays.asList(
            new User("pdp", "pdp.uz", new ArrayList<>()),
            new User("ecma", "ecma", new ArrayList<>()),
            new User("aif", "aif", new ArrayList<>())
    ));

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        throw new UsernameNotFoundException("topilmadi");
    }
}
