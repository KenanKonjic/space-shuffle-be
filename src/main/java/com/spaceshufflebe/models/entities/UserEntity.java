package com.spaceshufflebe.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "app_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "car")
    private Boolean car;

    @Column(name = "role")
    private Boolean role;

    public UserEntity(String name, String surname, String username, String password, Boolean car, Boolean role) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.car = car;
        this.role = role;
    }
}
