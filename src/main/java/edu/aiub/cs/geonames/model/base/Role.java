package edu.aiub.cs.geonames.model.base;

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
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "roleId")
    private long roleId;

    @NotNull
    @Column(name = "roleName")
    private String name;

    @NotNull
    @Column(name = "assignedTo")
    private String assignedTo;

    @NotNull
    @Column(name = "userId")
    private long userId;
}
