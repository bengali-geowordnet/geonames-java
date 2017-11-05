package edu.aiub.cs.geonames.model;

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
 *                 ************** FOR SECOND STAGE ***************
 *
 */
@Entity
public class KnowledgeBase {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Length(max = CD_ID_LENGTH)
    @Column(name = "appId", length = CD_ID_LENGTH)
    private int knowledgeBaseId;

    @NotNull
    @Length(max = 200)
    @Column(name = "name")
    private String name;

    @NotNull
    @Length(max = 200)
    @Column(name = "type")
    private String type;
}
