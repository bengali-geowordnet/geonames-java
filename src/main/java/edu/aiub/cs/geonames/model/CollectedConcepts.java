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

/*CREATE TABLE `collectedconcepts` (
        `collectedConceptsId` int(11) NOT NULL,
        `domainName` varchar(200) NOT NULL,
        `keyWord` varchar(200) NOT NULL,
        `conceptData` varchar(300) NOT NULL
        ) ENGINE=InnoDB DEFAULT CHARSET=latin1;*/

@Entity
public class CollectedConcepts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Length(max = CD_ID_LENGTH)
    private int collectedConceptsId;

    @NotNull
    @Length(max = 200)
    private String domainName;

    @NotNull
    @Length(max = 200)
    private String keyWord;

    @NotNull
    @Length(max = 300)
    private String conceptData;
}
