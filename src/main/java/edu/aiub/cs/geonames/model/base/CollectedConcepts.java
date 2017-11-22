package edu.aiub.cs.geonames.model.base;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
 * ************** FOR SECOND STAGE ***************
 */
@Entity
public class CollectedConcepts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "collectedConceptsId")
    private long collectedConceptsId;

    /**
     * THis is the domain of the concept.
     */
    @NotNull
    @Column(name = "domainName")
    private String domainName;

    /**
     * This stores the keyword that is used to search on a specific concept.
     * This is a single word or string.
     * The relation of keyword to conceptData is one to many.
     * keyWord 1_______* conceptData
     */
    @NotNull
    @Column(name = "keyWord")
    private String keyWord;

    /**
     * This stores the concepts against a keyword and stores as set/array.
     * Here all concept will store. From here we will use probability to determine the actual concept.
     * Here many concept may come against a single concept.
     * From this we will use probability to find the best concept.
     */
    @NotNull
    @Column(name = "conceptData")
    private String conceptData;

    public CollectedConcepts() {
    }
}
