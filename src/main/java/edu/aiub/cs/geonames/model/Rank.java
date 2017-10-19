package edu.aiub.cs.geonames.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static edu.aiub.cs.geonames.utility.Constants.CD_ID_LENGTH;

/**
 * Created by Sk Golam Muhammad Hasnain on 10/19/17.
 */

/*
CREATE TABLE `rank` (
        `rankType` varchar(200) NOT NULL,
        `basedOn` varchar(200) NOT NULL
        ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
*/

@Entity
public class Rank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Length(max = 200)
    @Column(name = "rankType")
    private String rankType;

    @NotNull
    @Length(max = 200)
    @Column(name = "basedOn")
    private String basedOn;
}
