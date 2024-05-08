/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author HP
 */
public class User implements Serializable {
    int id;
    String username;
    String user_firstname;
    String user_lastname;
    String mail;
    String password;
    int age;
    java.util.Date created;

    public User(int id, String username, String user_firstname, String user_lastname, String mail, String password, int age, Date created) {
        this.id = id;
        this.username = username;
        this.user_firstname = user_firstname;
        this.user_lastname = user_lastname;
        this.mail = mail;
        this.password = password;
        this.age = age;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getUser_firstname() {
        return user_firstname;
    }

    public String getUser_lastname() {
        return user_lastname;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public Date getCreated() {
        return created;
    }
    
    
    
}
