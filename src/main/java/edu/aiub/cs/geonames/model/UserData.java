package edu.aiub.cs.geonames.model;

import edu.aiub.cs.geonames.model.base.Location;
import edu.aiub.cs.geonames.model.base.Region;

/**
 * Created by Sk.GolamMuhammad on 9/17/2017.
 * <p>
 */
public class UserData {

    private String userKey;
    private String appKey;
    private Location location;
    private Region region;

    public UserData() {
    }

    public UserData(String userKey, String appKey, Location location, Region region) {
        this.userKey = userKey;
        this.appKey = appKey;
        this.location = location;
        this.region = region;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
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
