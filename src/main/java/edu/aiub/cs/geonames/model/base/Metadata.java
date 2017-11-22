package edu.aiub.cs.geonames.model.base;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
    @Column(name = "metaId")
    private long metaId;

    @NotNull
    @Column(name = "appId")
    private int appId;

    @NotNull
    @Column(name = "typeOfData")
    private String typeOfData;

    @NotNull
    @Column(name = "dataDescription")
    private String dataDescription;

}
