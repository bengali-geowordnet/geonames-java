package edu.aiub.cs.geonames.model.base;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import static edu.aiub.cs.geonames.utility.Constants.CD_ID_LENGTH;

/**
 * Created by Farhan Ar Rafi on 10/17/17.
 */

/*CREATE TABLE `appregister` (
        `registerId` int(11) NOT NULL,
        `userId` int(11) NOT NULL,
        `appId` int(11) NOT NULL
        ) ENGINE=InnoDB DEFAULT CHARSET=latin1;*/

@Entity
public class AppRegister {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Length(max = CD_ID_LENGTH)
    private int registerId;

    @NotNull
    @Length(max = CD_ID_LENGTH)
    private int userId;

    @NotNull
    @Length(max = CD_ID_LENGTH)
    private int appId;

    public AppRegister(int userId, int appId) {
        this.userId = userId;
        this.appId = appId;
    }

    public int getRegisterId() {
        return registerId;
    }

    public void setRegisterId(int registerId) {
        this.registerId = registerId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }
}
