package edu.aiub.cs.geonames.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Sk.GolamMuhammad on 9/17/2017.
 * <p>
 */
@Entity
public class Data {

    @Id
    @NotNull
    @Column(name = "dataId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long dataId;

    @NotNull
    @Column(name = "userId")
    private long userId;

    @NotNull
    @Column(name = "appInfoId")
    private long appInfoId;

    @NotNull
    @Column(name = "locationId")
    private long locationId;

    @NotNull
    @Column(name = "regionId")
    private long regionId;

    public Data() {
    }

    public Data(long userId, long appInfoId, long locationId, long regionId) {
        this.userId = userId;
        this.appInfoId = appInfoId;
        this.locationId = locationId;
        this.regionId = regionId;
    }

    public long getDataId() {
        return dataId;
    }

    public void setDataId(long dataId) {
        this.dataId = dataId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getAppInfoId() {
        return appInfoId;
    }

    public void setAppInfoId(long appInfoId) {
        this.appInfoId = appInfoId;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public long getRegionId() {
        return regionId;
    }

    public void setRegionId(long regionId) {
        this.regionId = regionId;
    }
}
