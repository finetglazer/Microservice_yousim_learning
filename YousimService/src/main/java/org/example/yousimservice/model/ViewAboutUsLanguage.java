package org.example.yousimservice.model;


import lombok.Data;
import org.example.yousimservice.dto.request.iRequestData;
import org.springframework.data.annotation.Immutable;

import javax.persistence.*;

@Immutable
@Data
@Entity
@Table(name = "v_about_us_lang")
public class ViewAboutUsLanguage implements iRequestData {
    @Id
    @Column(name="id")
    private int id;
    @Column(name = "image")
    private String image;
    @Column(name = "type")
    private int type;
    @Column(name = "content")
    private String content;
    @Column(name = "title")
    private String title;
    @Column(name = "language")
    private String language;
    @Column(name = "partner")
    private String partner;
    @Column(name="status")
    private int status;


    @Override
    public boolean isValid() {
        return false;
    }
}
