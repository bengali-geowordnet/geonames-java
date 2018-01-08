package edu.aiub.cs.geonames.model.wn;

import javax.persistence.Entity;

/**
 * Created by bjit on 1/8/18.
 */
public class Word {

    String id;
    String lemma;
    String gloss;

    public Word(String id, String lemma, String gloss) {
        this.id = id;
        this.lemma = lemma;
        this.gloss = gloss;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLemma() {
        return lemma;
    }

    public void setLemma(String lemma) {
        this.lemma = lemma;
    }

    public String getGloss() {
        return gloss;
    }

    public void setGloss(String gloss) {
        this.gloss = gloss;
    }
}
