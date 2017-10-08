package edu.aiub.cs.geonames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sk.GolamMuhammad on 9/17/2017.
 */
public class Data {
    private Geoname geoname;
    private User user;

    public Data() {
    }

    public Data(Geoname geoname, User user) {
        this.geoname = geoname;
        this.user = user;
    }

    public Geoname getGeoname() {
        return geoname;
    }

    public void setGeoname(Geoname geoname) {
        this.geoname = geoname;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
