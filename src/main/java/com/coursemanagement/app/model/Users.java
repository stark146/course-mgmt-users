package com.coursemanagement.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//Auto: Default. It does not take any specific action
//Identity: Auto increment
//Sequence: Oracle/Postgresql creates variable to autoincrement
//Table: Hibernate uses a database table to simulate a sequence

//EAGER - Fetch Immediately. EAGER will call Country object of User when User is called
//LAZY - Fetch when needed. used when we want to call country object only when needed

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String username;

    private String password;

    @Enumerated(value = EnumType.STRING)
    private Role role;

}
