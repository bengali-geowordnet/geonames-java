package edu.aiub.cs.geonames.model.base;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

    /**
     * for android it will be the package name
     */
    @NotNull
    @Column(name = "name")
    private String name;

    /**
     * generated app token for data exchange
     */
    @NotNull
    @Column(name = "token")
    private String token;

    /**
     * developer email address for identification of
     */
    @NotNull
    @Column(name = "email")
    private String email;

    /**
     * type of application like game, educational, navigation
     */
    @NotNull
    @Column(name = "type")
    private String type;

    public AppInfo() {
    }

    public AppInfo(String name, String token, String email, String type) {
        this.name = name;
        this.token = token;
        this.email = email;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
