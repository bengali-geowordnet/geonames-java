package edu.aiub.cs.geonames.model.base;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static edu.aiub.cs.geonames.utility.Constants.CD_ID_LENGTH;

/**
 * Created by Farhan Ar Rafi on 10/17/17.
 */
/*
CREATE TABLE `appregister` (
        `registerId` long(11) NOT NULL,
        `userId` long(11) NOT NULL,
        `appId` long(11) NOT NULL
        ) ENGINE=InnoDB DEFAULT CHARSET=latin1;*/

@Entity
public class AppInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "appId")
    private long appId;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "type")
    private String type;

    public AppInfo() {
    }

    public AppInfo(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public long getAppId() {
        return appId;
    }

    public void setAppId(long appId) {
        this.appId = appId;
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
