package com.itlap.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "VieToEng")
public class VieToEng {

    public VieToEng(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String vie;

    @Column(columnDefinition = "text")
    private String eng;
}
