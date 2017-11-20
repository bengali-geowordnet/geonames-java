package edu.aiub.cs.geonames.model.base;

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

/**
 * ************** FOR SECOND STAGE ***************
 * <p>
 * This class is used for App Ranking to determine which apps give good data.
 * THis class will also be used for Subscrption Ranking to determine which user gives good data.
 * THis class is also used to rank concepts based on data from CollectedConcepts using probability.
 * Here probability theory is the higher probability will give us the actual ranking.
 */
@Entity
public class Rank {

    @Id
    @NotNull
    @Column(name = "rankId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long rankId;

    @NotNull
    @Column(name = "rankType")
    private String rankType;

    @NotNull
    @Column(name = "basedOn")
    private String basedOn;
}
