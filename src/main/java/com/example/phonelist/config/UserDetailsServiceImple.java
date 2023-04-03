/*package com.example.phonelist.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.phonelist.dao.UserRepo;
import com.example.phonelist.entity.User;

public class UserDetailsServiceImple implements UserDetailsService {
    @Autowired
    private UserRepo userrepo;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       //fetching user from database
       User user= userrepo.getUserByUserName(username);
       if(user==null)
       {
        throw new UsernameNotFoundException("could not found user");
       }
       CustomUserDetails csd=new CustomUserDetails(user);

       return csd;
    }
    
    
}*/
