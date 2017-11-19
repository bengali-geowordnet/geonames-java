package edu.aiub.cs.geonames.model.base;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static edu.aiub.cs.geonames.utility.Constants.CD_ID_LENGTH;

/**
 * Created by Sk Golam Muhammad Hasnain on 10/19/17.
 */

/*CREATE TABLE `location` (
        `locationId` int(11) NOT NULL,
        `locName` varchar(300) NOT NULL,
        `lattitude` varchar(200) NOT NULL,
        `longitudde` varchar(200) NOT NULL,
        `locType` varchar(200) NOT NULL
        ) ENGINE=InnoDB DEFAULT CHARSET=latin1;*/

@Entity
public class Location {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Length(max = CD_ID_LENGTH)
    @Column(name = "locationId", length = CD_ID_LENGTH)
    private int locationId;

    @NotNull
    @Length(max = 300)
    @Column(name = "name")
    private String name;

    @NotNull
    @Length(max = 200)
    @Column(name = "latitude")
    private String latitude;

    @NotNull
    @Length(max = 200)
    @Column(name = "longitude")
    private String longitude;

    @Length(max = 200)
    @Column(name = "altitude")
    private int altitude;

    @Length(max = 200)
    @Column(name = "elevation")
    private int elevation;

    @NotNull
    @Length(max = 200)
    @Column(name = "type")
    private String type;

    public Location() {
    }

    public Location(String name, String latitude, String longitude, int altitude, int elevation, String type) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.elevation = elevation;
        this.type = type;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String locName) {
        this.name = name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public int getElevation() {
        return elevation;
    }

    public void setElevation(int elevation) {
        this.elevation = elevation;
    }

    public String getType() {
        return type;
    }

    public void setType(String locType) {
        this.type = type;
    }
}
