package edu.aiub.cs.geonames.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import static edu.aiub.cs.geonames.utility.Constants.CD_ID_LENGTH;

/**
 * Created by Farhan Ar Rafi on 10/17/17.
 */
@Entity
public class AppRegister {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Length(max = CD_ID_LENGTH)
    private int registerId;

    @NotNull
    @Length(max = CD_ID_LENGTH)
    private int userId;

    @NotNull
    @Length(max = CD_ID_LENGTH)
    private int appId;
}
