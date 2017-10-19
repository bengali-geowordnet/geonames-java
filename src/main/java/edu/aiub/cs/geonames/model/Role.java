package edu.aiub.cs.geonames.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static edu.aiub.cs.geonames.utility.Constants.CD_ID_LENGTH;

/**
 * Created by Sk Golam Muhammad Hasnain on 10/19/17.
 */
/*CREATE TABLE `role` (
        `roleId` int(11) NOT NULL,
        `roleName` varchar(200) NOT NULL,
        `assignedTo` varchar(200) NOT NULL,
        `userId` int(11) NOT NULL
        ) ENGINE=InnoDB DEFAULT CHARSET=latin1;*/

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Length(max = CD_ID_LENGTH)
    @Column(name = "roleId", length = CD_ID_LENGTH)
    private int roleId;

    @NotNull
    @Length(max = 200)
    @Column(name = "roleName")
    private String name;

    @NotNull
    @Length(max = 200)
    @Column(name = "assignedTo")
    private String assignedTo;

    @NotNull
    @Length(max = CD_ID_LENGTH)
    @Column(name = "userId", length = CD_ID_LENGTH)
    private int userId;
}
