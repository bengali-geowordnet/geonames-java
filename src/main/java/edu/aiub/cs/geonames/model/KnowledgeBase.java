package edu.aiub.cs.geonames.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static edu.aiub.cs.geonames.utility.Constants.CD_ID_LENGTH;

/**
 * Created by Farhan Ar Rafi on 10/19/17.
 */
@Entity
public class KnowledgeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Length(max = CD_ID_LENGTH)
    @Column(name = "appId", length = CD_ID_LENGTH)
    private int knowledgeBaseId;

    @NotNull
    @Length(max = 100)
    @Column(name = "name")
    private String name;

    @NotNull
    @Length(max = 100)
    @Column(name = "type")
    private String type;
}
