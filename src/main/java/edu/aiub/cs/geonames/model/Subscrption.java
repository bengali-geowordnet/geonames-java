package edu.aiub.cs.geonames.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

import static edu.aiub.cs.geonames.utility.Constants.CD_ID_LENGTH;

/**
 * Created by Sk Golam Muhammad Hasnain on 10/19/17.
 */

/*CREATE TABLE `user` (
        `userId` int(11) NOT NULL,
        `userName` varchar(200) NOT NULL,
        `userType` varchar(200) NOT NULL,
        `fullName` varchar(200) NOT NULL,
        `dateOfBirth` date NOT NULL,
        `gender` varchar(100) NOT NULL,
        `address` varchar(500) NOT NULL,
        `contactNumber` int(11) NOT NULL,
        `age` int(11) NOT NULL,
        `country` varchar(100) NOT NULL,
        `education` varchar(300) NOT NULL
        ) ENGINE=InnoDB DEFAULT CHARSET=latin1;*/

@Entity
public class Subscrption {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Length(max = CD_ID_LENGTH)
    @Column(name = "subscriptionId", length = CD_ID_LENGTH)
    private int subscriptionId;

}
