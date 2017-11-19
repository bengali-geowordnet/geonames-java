package edu.aiub.cs.geonames.model;

import edu.aiub.cs.geonames.model.base.AppRegister;
import edu.aiub.cs.geonames.model.base.Location;
import edu.aiub.cs.geonames.model.base.Region;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static edu.aiub.cs.geonames.utility.Constants.CD_ID_LENGTH;

/**
 * Created by Sk.GolamMuhammad on 9/17/2017.
 * <p>
 * {
 * "appRegisterID": 111,
 * "location": {
 * "name": "",
 * "longitude": 12.33,
 * "latitude": 222.36,
 * "altitude": 10,
 * "elevation": 10,
 * "type": ""
 * },
 * "region": {
 * "name": "",
 * "type": ""
 * }
 * }
 */
public class Data {

    private int appRegisterID;
    private Location location;
    private Region region;

    public Data() {
    }

    public Data(int appRegisterID, Location location, Region region) {
        this.appRegisterID = appRegisterID;
        this.location = location;
        this.region = region;
    }

    public int getAppRegisterID() {
        return appRegisterID;
    }

    public void setAppRegisterID(int appRegisterID) {
        this.appRegisterID = appRegisterID;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
