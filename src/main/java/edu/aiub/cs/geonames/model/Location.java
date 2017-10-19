package edu.aiub.cs.geonames.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static edu.aiub.cs.geonames.utility.Constants.CD_ID_LENGTH;

/**
 * Created by Sk Golam Muhammad Hasnain on 10/19/17.
 */

/*CREATE TABLE `location` (
        `locationId` int(11) NOT NULL,
        `locName` varchar(300) NOT NULL,
        `lattitude` varchar(200) NOT NULL,
        `longitudde` varchar(200) NOT NULL,
        `locType` varchar(200) NOT NULL
        ) ENGINE=InnoDB DEFAULT CHARSET=latin1;*/

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Length(max = CD_ID_LENGTH)
    @Column(name = "locationId", length = CD_ID_LENGTH)
    private int locationId;

    @NotNull
    @Length(max = 300)
    @Column(name = "locName")
    private String locName;

    @NotNull
    @Length(max = 200)
    @Column(name = "lattitude")
    private String lattitude;

    @NotNull
    @Length(max = 200)
    @Column(name = "longitudde")
    private String longitudde;


    @NotNull
    @Length(max = 200)
    @Column(name = "locType")
    private String locType;
}
