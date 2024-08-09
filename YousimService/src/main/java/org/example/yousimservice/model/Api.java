package org.example.yousimservice.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "api")
public class Api {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_api")
    private String nameApi;
    @Column(name = "ws_code")
    private String wsCode;
    @Column(name = "status")
    private int status;


}
