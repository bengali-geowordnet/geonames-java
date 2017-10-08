package edu.aiub.cs.geonames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Farhan on 9/18/2017.
 * This is the structure of the database table for storing geonames data.
 */
@Entity
public class Geoname {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long geonameId;
    private String name;
    private String asciiname;
    private String alternatenames;
    private double latitude;
    private double longitude;
    private String feature_class;
    private String feature_code;
    private String country_code;
    private String cc2;
    private String admin1_code;
    private String admin2_code;
    private String admin3_code;
    private String admin4_code;
    private long population;
    private int elevation;
    private long dem;
    private String timezone;
    private String modification_date;

    public Geoname() {

    }

    public Geoname(long geonameId, String name, String asciiname, String alternatenames, double latitude, double longitude, String feature_class, String feature_code, String country_code, String cc2, String admin1_code, String admin2_code, String admin3_code, String admin4_code, long population, int elevation, long dem, String timezone, String modification_date) {
        this.geonameId = geonameId;
        this.name = name;
        this.asciiname = asciiname;
        this.alternatenames = alternatenames;
        this.latitude = latitude;
        this.longitude = longitude;
        this.feature_class = feature_class;
        this.feature_code = feature_code;
        this.country_code = country_code;
        this.cc2 = cc2;
        this.admin1_code = admin1_code;
        this.admin2_code = admin2_code;
        this.admin3_code = admin3_code;
        this.admin4_code = admin4_code;
        this.population = population;
        this.elevation = elevation;
        this.dem = dem;
        this.timezone = timezone;
        this.modification_date = modification_date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getGeonameId() {
        return geonameId;
    }

    public void setGeonameId(long geonameId) {
        this.geonameId = geonameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAsciiname() {
        return asciiname;
    }

    public void setAsciiname(String asciiname) {
        this.asciiname = asciiname;
    }

    public String getAlternatenames() {
        return alternatenames;
    }

    public void setAlternatenames(String alternatenames) {
        this.alternatenames = alternatenames;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getFeature_class() {
        return feature_class;
    }

    public void setFeature_class(String feature_class) {
        this.feature_class = feature_class;
    }

    public String getFeature_code() {
        return feature_code;
    }

    public void setFeature_code(String feature_code) {
        this.feature_code = feature_code;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getCc2() {
        return cc2;
    }

    public void setCc2(String cc2) {
        this.cc2 = cc2;
    }

    public String getAdmin1_code() {
        return admin1_code;
    }

    public void setAdmin1_code(String admin1_code) {
        this.admin1_code = admin1_code;
    }

    public String getAdmin2_code() {
        return admin2_code;
    }

    public void setAdmin2_code(String admin2_code) {
        this.admin2_code = admin2_code;
    }

    public String getAdmin3_code() {
        return admin3_code;
    }

    public void setAdmin3_code(String admin3_code) {
        this.admin3_code = admin3_code;
    }

    public String getAdmin4_code() {
        return admin4_code;
    }

    public void setAdmin4_code(String admin4_code) {
        this.admin4_code = admin4_code;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public int getElevation() {
        return elevation;
    }

    public void setElevation(int elevation) {
        this.elevation = elevation;
    }

    public long getDem() {
        return dem;
    }

    public void setDem(long dem) {
        this.dem = dem;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getModification_date() {
        return modification_date;
    }

    public void setModification_date(String modification_date) {
        this.modification_date = modification_date;
    }
}
