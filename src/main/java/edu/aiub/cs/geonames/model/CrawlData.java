package edu.aiub.cs.geonames.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;

/**
 * Created by Farhan Ar Rafi on 10/17/17.
 */

/*CREATE TABLE `crawldata` (
        `collectionSource` varchar(500) NOT NULL,
        `collectionTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
        ) ENGINE=InnoDB DEFAULT CHARSET=latin1;*/

@Entity
public class CrawlData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Length(max = 500)
    private String collectionSource;

    @NotNull
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date collectionTime;
}
