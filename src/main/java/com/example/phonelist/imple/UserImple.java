package com.example.phonelist.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.phonelist.dao.UserRepo;
import com.example.phonelist.entity.User;
import com.example.phonelist.service.UserService;
@Service
public class UserImple  implements UserService{
    @Autowired
private UserRepo userrepo;
    @Override
    public List<User> getByEmailUsers(String email) {
        return userrepo.getByEmailUsers(email);
    
    }
    @Override
    public List<User> getByPasswordUsers(String password) {

        return userrepo.getByPasswordUsers(password);
    }
    
}
