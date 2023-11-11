package com.maping.Mapping.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetails {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "youtube_channel")
    private  String youtubeChanel;
    @Column(name = "hobby")
    private String hobby;

    public InstructorDetails() {
    }

    public InstructorDetails(String youtubeChanel, String hobby) {
        this.youtubeChanel = youtubeChanel;
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeChanel() {
        return youtubeChanel;
    }

    public void setYoutubeChanel(String youtubeChanel) {
        this.youtubeChanel = youtubeChanel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "InstructorDetails{" +
                "id=" + id +
                ", youtubeChanel='" + youtubeChanel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}