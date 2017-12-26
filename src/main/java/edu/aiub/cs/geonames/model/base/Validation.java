package edu.aiub.cs.geonames.model.base;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Sk Golam Muhammad Hasnain on 10/19/17.
 */

/*CREATE TABLE `validation` (
        `validationId` int(100) NOT NULL,
        `validationType` varchar(100) NOT NULL
        ) ENGINE=InnoDB DEFAULT CHARSET=latin1;*/

/**
 * ************** FOR SECOND STAGE ***************
 */
@Entity
public class Validation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "validationId")
    private long validationId;

    @NotNull
    @Column(name = "validationType")
    private String validationType;

}
