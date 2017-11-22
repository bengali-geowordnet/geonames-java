package edu.aiub.cs.geonames.model.base;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Farhan Ar Rafi on 10/17/17.
 */

/*CREATE TABLE `appregister` (
        `registerId` long(11) NOT NULL,
        `userId` long(11) NOT NULL,
        `appId` long(11) NOT NULL
        ) ENGINE=InnoDB DEFAULT CHARSET=latin1;*/

@Entity
public class AppRegister {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "registerId")
    private long registerId;

    @NotNull
    @Column(name = "userId")
    private long userId;

    @NotNull
    @Column(name = "appId")
    private long appId;

    public AppRegister(long userId, long appId) {
        this.userId = userId;
        this.appId = appId;
    }

    public long getRegisterId() {
        return registerId;
    }

    public void setRegisterId(long registerId) {
        this.registerId = registerId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getAppId() {
        return appId;
    }

    public void setAppId(long appId) {
        this.appId = appId;
    }
}
