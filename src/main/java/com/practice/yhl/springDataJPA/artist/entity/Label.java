package com.practice.yhl.springDataJPA.artist.entity;

import javax.persistence.*;

@Entity(name="TBL_LABEL")
@Table(name="TBL_LABEL")
public class Label {

    @Id
    @Column(name="LABEL_CODE")
    private int labelCode;
    @Column(name="LABEL_NAME")
    private String labelName;
    @Column(name="LOCATION")
    private String location;
    @Column(name="FOUNDER")
    private String founder;

    protected Label(){}

    public Label(int labelCode, String labelName, String location, String founder) {
        this.labelCode = labelCode;
        this.labelName = labelName;
        this.location = location;
        this.founder = founder;
    }

    public int getLabelCode() {
        return labelCode;
    }

    public String getLabelName() {
        return labelName;
    }

    public String getLocation() {
        return location;
    }

    public String getFounder() {
        return founder;
    }

    @Override
    public String toString() {
        return "Label{" +
                "labelCode=" + labelCode +
                ", labelName='" + labelName + '\'' +
                ", location='" + location + '\'' +
                ", founder='" + founder + '\'' +
                '}';
    }
}
