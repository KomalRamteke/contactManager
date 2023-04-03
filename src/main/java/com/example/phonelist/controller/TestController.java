package com.example.phonelist.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.phonelist.dao.UserRepo;
//import com.example.phonelist.entity.Contact;
import com.example.phonelist.entity.User;
import com.example.phonelist.helper.Message;
import com.example.phonelist.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class TestController {
   

    @Autowired
    private UserRepo userrepo;
    @Autowired
    private UserService uService;

    @RequestMapping("/")
    public String home(Model model)
    {
        model.addAttribute("title", "Home-smart Contact Manager");
        System.out.println("hi hello********************");
        return "home";
    }

 @RequestMapping("/about")
    public String about(Model model)
    {
        model.addAttribute("title", "About-smart Contact Manager");
        return "about";

    }

    @RequestMapping("/login")
    public String login(Model model)
    {
        model.addAttribute("title", "login-smart Contact Manager");
        return "login";

    }
    
    @RequestMapping("/signup")
    public String signup(Model model)
    {
        model.addAttribute("title", "Register-smart Contact Manager");
        model.addAttribute("user", new User());
        return "signup";

    }
    

    //this handler for register user
    @RequestMapping(value = "/do_register",method=RequestMethod.POST)

    public String registerUser(@Valid @ModelAttribute("user") User user,BindingResult result1,@RequestParam
    (value="agreement",defaultValue="false") boolean agreement,
    Model model,HttpSession session)

    {
       try {
        
        if(!agreement)
        {
            System.out.println("you have not agreed terms and condition");
            throw new Exception("you have not agreed terms and condition");
        }
        if(result1.hasErrors())
        {
            System.out.println("Error "+result1.toString());
            model.addAttribute("USER", user);
            return "signup";
        }
        user.setRole("ROLE_USER");
        user.setEnabled(true);
        user.setImgurl("default.png");
       // user.setPassword(passwordEncoder.encode(user.getPassword()));

        System.out.println("agreement"+agreement);
        System.out.println("USER"+user);
        User result=this.userrepo.save(user);

        
        model.addAttribute("user", new User());
        session.setAttribute("message", new Message("successfully register" ,
        "alert-success"));
        return "signup";   

    }
        catch (Exception e) 
        {
        model.addAttribute("user",user);
        session.setAttribute("message", new Message("something went wrong  "+e.getMessage(),"alert-danger" ));
        return "signup";
         }}
      
    


    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public String loginuser( @ModelAttribute("user") User user, 
    @RequestParam(value="email", defaultValue="false")  Model model,
    HttpSession session)
     {
        try {
            List<User> retrievedUser =uService.getByEmailUsers("email");
            List<User> retrivePassword=uService.getByPasswordUsers("password");
            if (((User) retrievedUser).getEmail().equals(retrievedUser) && ((User) retrievedUser).getPassword().equals(retrivePassword))
             {
            
                session.setAttribute("user", retrievedUser);

                session.setAttribute("message", new Message("successfully register" ,
                "alert-success"));
            return "detail";
             } }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error during login");
            model.addAttribute("user",user);
            session.setAttribute("message", new Message("something went wrong  "+e.getMessage(),"alert-danger" ));
        
            return "login";
        }
        return "login";
        
  
}




}
