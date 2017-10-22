package edu.aiub.cs.geonames.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static edu.aiub.cs.geonames.utility.Constants.CD_ID_LENGTH;
import static edu.aiub.cs.geonames.utility.Constants.CD_RID_LENGTH;

/**
 * Created by Sk Golam Muhammad Hasnain on 10/19/17.
 */

/*CREATE TABLE `region` (
        `regionId` int(200) NOT NULL,
        `regionName` varchar(100) NOT NULL,
        `regionType` varchar(100) NOT NULL
        ) ENGINE=InnoDB DEFAULT CHARSET=latin1;*/

@Entity
public class Region {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Length(max = CD_ID_LENGTH)
    @Column(name = "regionId", length = CD_ID_LENGTH)
    private int regionId;

    @NotNull
    @Length(max = 100)
    @Column(name = "regionName")
    private String regionName;

    @NotNull
    @Length(max = 100)
    @Column(name = "regionType")
    private String regionType;
}
