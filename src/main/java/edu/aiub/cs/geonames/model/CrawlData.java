package edu.aiub.cs.geonames.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.sql.Timestamp;

/**
 * Created by Farhan Ar Rafi on 10/17/17.
 */
@Entity
public class CrawlData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Length(max = 500)
    private String collectionSource;

    @NotNull
    @CreationTimestamp
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp collectionTime;
}
