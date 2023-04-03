package com.example.phonelist.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.phonelist.entity.User;
@Repository                    
public interface UserRepo  extends JpaRepository<User,Integer>{



   @Query("SELECT p FROM User p WHERE p.email=?1" )
   public List<User> getByEmailUsers(String email);

   @Query("SELECT p FROM User p WHERE p.password=?1" )
   public List<User> getByPasswordUsers(String passsword);
  
}
