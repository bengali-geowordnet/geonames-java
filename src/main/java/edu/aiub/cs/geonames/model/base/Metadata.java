package edu.aiub.cs.geonames.model.base;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static edu.aiub.cs.geonames.utility.Constants.CD_MID_LENGTH;

/**
 * Created by Sk Golam Muhammad Hasnain on 10/19/17.
 */

/*CREATE TABLE `metadata` (
        `metaId` int(100) NOT NULL,
        `appId` int(100) NOT NULL,
        `typeOfData` varchar(500) NOT NULL,
        `dataDescription` varchar(500) NOT NULL
        ) ENGINE=InnoDB DEFAULT CHARSET=latin1;*/

@Entity
public class Metadata {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Length(max = CD_MID_LENGTH)
    @Column(name = "metaId", length = CD_MID_LENGTH)
    private int metaId;

    @NotNull
    @Length(max = CD_MID_LENGTH)
    @Column(name = "appId", length = CD_MID_LENGTH)
    private int appId;

    @NotNull
    @Length(max = 500)
    @Column(name = "typeOfData")
    private String typeOfData;

    @NotNull
    @Length(max = 500)
    @Column(name = "dataDescription")
    private String dataDescription;

}
