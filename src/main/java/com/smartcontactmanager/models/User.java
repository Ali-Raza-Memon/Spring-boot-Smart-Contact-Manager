package com.smartcontactmanager.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="User")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String roll;
    private boolean enabled;
    private String name;

    @Column(unique = true)
    private String email;
    private String password;
    private String imageUrl;
    private String about;

}
