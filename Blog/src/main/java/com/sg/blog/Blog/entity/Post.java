/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.blog.Blog.entity;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "post")
public class Post {
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Id
private int id;

   @Column(nullable = false)
   String title;
   @Column
   String body;
   @Column
   LocalDate timeStamp;
   @Column
   LocalDate startDate;
   @Column
   LocalDate endDate;
   @ManyToMany
   @JoinTable(name = "postTags",
   joinColumns = {@JoinColumn(name = "id")},
   inverseJoinColumns = {@JoinColumn(name = "name")})
   List<Tag> tags;

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
   
   

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
   
    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }
   

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDate timeStamp) {
        this.timeStamp = timeStamp;
    }
   
}
