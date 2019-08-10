package com.library.domain;

import javax.persistence.*;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer userId;

        private String username;

        private String email;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Orders> orders;


    public Integer getUserId() {
         return userId;
     }

     public void setUserId(Integer userId) {
         this.userId = userId;
     }

     public String getUsername() {
         return username;
     }

     public void setUsername(String username) {
         this.username = username;
     }

     public String getEmail() {
         return email;
     }

     public void setEmail(String email) {
         this.email = email;
     }
 }

