package com.example.phonelist.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="USER")
public class User {
    

    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private int id;
    @NotBlank(message="name should not be blank")
    @Size(min=2,max=10,message = "min 2 and max 10 charcters allowed")
    private String name;
    @Column(unique = true)
    private String  email;
    private String password;
    private String role;
    private boolean enabled;
    private String imgurl;
    private String about;
    public String contact;

    
    public User() {
    }

    public User(int id,
            @NotBlank(message = "name should not be blank") @Size(min = 2, max = 10, message = "min 2 and max 10 charcters allowed") String name,
            String email, String password, String role, boolean enabled, String imgurl, String about, String contact) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
        this.imgurl = imgurl;
        this.about = about;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }
    
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
                + ", enabled=" + enabled + ", imgurl=" + imgurl + ", about=" + about + ", contact=" + contact + "]";
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public boolean isEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    public String getImgurl() {
        return imgurl;
    }
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
    public String getAbout() {
        return about;
    }
    public void setAbout(String about) {
        this.about = about;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }

    
    }



