package edu.aiub.cs.geonames.model.base;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static edu.aiub.cs.geonames.utility.Constants.CD_ID_LENGTH;

/**
 * Created by Sk Golam Muhammad Hasnain on 10/19/17.
 */

/*CREATE TABLE `knowledgebase` (
        `knowledgeBaseId` int(11) NOT NULL,
        `name` varchar(200) NOT NULL,
        `type` varchar(200) NOT NULL
        ) ENGINE=InnoDB DEFAULT CHARSET=latin1;*/

/**
 * ************** FOR SECOND STAGE ***************
 */
@Entity
public class KnowledgeBase {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "knowledgeBaseId")
    private long knowledgeBaseId;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "type")
    private String type;
}
