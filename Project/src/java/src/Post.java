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
public class Post implements Serializable {
    int id;
    String title;
    String genre;
    int userid;
    String content;
    java.util.Date published;

    public Post(int id, String title, String genre, int userid, String content, Date published) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.userid = userid;
        this.content = content;
        this.published = published;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getUserid() {
        return userid;
    }

    public String getContent() {
        return content;
    }

    public Date getPublished() {
        return published;
    }
    
    
}
