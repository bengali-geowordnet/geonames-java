package edu.aiub.cs.geonames.model.base;

import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Length(max = CD_ID_LENGTH)
    @Column(name = "userId", length = CD_ID_LENGTH)
    private int userId;

    @NotNull
    @Length(max = 200)
    @Column(name = "userName")
    private String userName;

    @NotNull
    @Length(max = 200)
    @Column(name = "userType")
    private String userType;

    @NotNull
    @Length(max = 200)
    @Column(name = "fullName")
    private String fullName;

    @NotNull
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;

    @NotNull
    @Length(max = 100)
    @Column(name = "gender")
    private String gender;

    @NotNull
    @Length(max = 500)
    @Column(name = "address")
    private String address;

    @NotNull
    @Length(max = CD_ID_LENGTH)
    @Column(name = "contactNumber", length = CD_ID_LENGTH)
    private int contactNumber;

    @NotNull
    @Length(max = CD_ID_LENGTH)
    @Column(name = "age", length = CD_ID_LENGTH)
    private int age;

    @NotNull
    @Length(max = 100)
    @Column(name = "country")
    private String country;

    @NotNull
    @Length(max = 300)
    @Column(name = "education")
    private String education;

}
