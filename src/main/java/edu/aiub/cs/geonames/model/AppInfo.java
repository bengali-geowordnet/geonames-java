package edu.aiub.cs.geonames.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static edu.aiub.cs.geonames.utility.Constants.CD_ID_LENGTH;

/**
 * Created by Farhan Ar Rafi on 10/17/17.
 */
/*
CREATE TABLE `appregister` (
        `registerId` int(11) NOT NULL,
        `userId` int(11) NOT NULL,
        `appId` int(11) NOT NULL
        ) ENGINE=InnoDB DEFAULT CHARSET=latin1;*/

@Entity
public class AppInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Length(max = CD_ID_LENGTH)
    @Column(name = "appId", length = CD_ID_LENGTH)
    private int appId;

    @NotNull
    @Length(max = 100)
    @Column(name = "appName")
    private String appName;

    @NotNull
    @Length(max = 100)
    private String appType;
}
