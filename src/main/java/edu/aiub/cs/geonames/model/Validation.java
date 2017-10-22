package edu.aiub.cs.geonames.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static edu.aiub.cs.geonames.utility.Constants.CD_MID_LENGTH;

/**
 * Created by Sk Golam Muhammad Hasnain on 10/19/17.
 */

/*CREATE TABLE `validation` (
        `validationId` int(100) NOT NULL,
        `validationType` varchar(100) NOT NULL
        ) ENGINE=InnoDB DEFAULT CHARSET=latin1;*/

@Entity
public class Validation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Length(max = CD_MID_LENGTH)
    @Column(name = "validationId", length = CD_MID_LENGTH)
    private int validationId;

    @NotNull
    @Length(max = 100)
    @Column(name = "validationType")
    private String validationType;

}
