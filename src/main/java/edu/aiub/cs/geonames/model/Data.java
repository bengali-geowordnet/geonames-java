package edu.aiub.cs.geonames.model;

import edu.aiub.cs.geonames.model.base.Location;
import edu.aiub.cs.geonames.model.base.Region;

/**
 * Created by Sk.GolamMuhammad on 9/17/2017.
 * <p>

 */
public class Data {

    private int userId;
    private int appInfoId;
    private Location location;
    private Region region;

    public Data() {
    }

    public Data(int userId, int appInfoId, Location location, Region region) {
        this.userId = userId;
        this.appInfoId = appInfoId;
        this.location = location;
        this.region = region;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAppInfoId() {
        return appInfoId;
    }

    public void setAppInfoId(int appInfoId) {
        this.appInfoId = appInfoId;
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
