package com.ilionx.musicapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MusicInstrument {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String name;
    private String orchestraGroup;
    private Boolean hasStrings;
    private int numberInOrchestra;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrchestraGroup() {
        return orchestraGroup;
    }

    public void setOrchestraGroup(String orchestraGroup) {
        this.orchestraGroup = orchestraGroup;
    }

    public Boolean getHasStrings() {
        return hasStrings;
    }

    public void setHasStrings(Boolean hasStrings) {
        this.hasStrings = hasStrings;
    }

    public int getNumberInOrchestra() {
        return numberInOrchestra;
    }

    public void setNumberInOrchestra(int numberInOrchestra) {
        this.numberInOrchestra = numberInOrchestra;
    }

    public long getId() {
        return id;
    }
}
