package edu.aiub.cs.geonames.model.base;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static edu.aiub.cs.geonames.utility.Constants.CD_ID_LENGTH;

/**
 * Created by Sk Golam Muhammad Hasnain on 10/19/17.
 */

/*CREATE TABLE `region` (
        `regionId` int(200) NOT NULL,
        `regionName` varchar(100) NOT NULL,
        `regionType` varchar(100) NOT NULL
        ) ENGINE=InnoDB DEFAULT CHARSET=latin1;*/

@Entity
public class Region {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Length(max = CD_ID_LENGTH)
    @Column(name = "regionId", length = CD_ID_LENGTH)
    private int regionId;

    @NotNull
    @Length(max = 100)
    @Column(name = "name")
    private String name;

    @NotNull
    @Length(max = 100)
    @Column(name = "type")
    private String type;

    public Region() {
    }

    public Region(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
