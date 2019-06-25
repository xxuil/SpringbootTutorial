package com.learn.springboot.pojo;

import java.io.Serializable;

import com.couchbase.client.java.repository.annotation.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

@Document
public class Post implements Serializable {
    @Id
    private int id;

    @Field
    private String title;

    @Field
    private String content;

    @Field
    private String time;

    public String getTime(){
        return time;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Post: " + id;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(obj instanceof Post){
            if(((Post) obj).id == this.id){
                if(((Post) obj).title.equals(this.title)){
                    if(((Post) obj).content.equals(this.content))
                        return true;
                }
            }
        }

        return false;
    }
}
