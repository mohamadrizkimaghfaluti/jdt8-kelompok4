package com.example.MiniProjectUniversity.model;


import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mst_user")
public class User {

    @Id
    @NotNull
    @Column(name = "id_user", length = 20)
    private String idUser;

    @NotNull
    @Column(name = "user_name", length = 50)
    private String userName;

    @NotNull
    @Column(name = "password", length = 20)
    private String password;


    public String getIdUser() { return idUser;}

    public void setIdUser(String idUser) { this.idUser = idUser;}

    public String getUsername() { return userName;}

    public void setUsername(String userName) {this.userName = userName;}

    public String getPassword() { return password;}

    public void setPassword(String password) {this.password = password;}

}
