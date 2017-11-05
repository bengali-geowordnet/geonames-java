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

/**
 *                  ************** FOR SECOND STAGE ***************
 * 
 */
@Entity
public class CollectedConcepts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Length(max = CD_ID_LENGTH)
    private int collectedConceptsId;

    /**
     * THis is the domain of the concept.
     */
    @NotNull
    @Length(max = 200)
    private String domainName;

    /**
     * This stores the keyword that is used to search on a specific concept.
     * This is a single word or string.
     * The relation of keyword to conceptData is one to many.
     * keyWord 1_______* conceptData
     */
    @NotNull
    @Length(max = 200)
    private String keyWord;

    /**
     * This stores the concepts against a keyword and stores as set/array.
     * Here all concept will store. From here we will use probability to determine the actual concept.
     * Here many concept may come against a single concept.
     * From this we will use probability to find the best concept.
     */
    @NotNull
    @Length(max = 300)
    private String conceptData;

    public CollectedConcepts() {
    }
}
