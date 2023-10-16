package com.practice.yhl.springDataJPA.artist.dto;

import javax.persistence.Id;

public class LabelDTO {

    private int labelCode;
    private String labelName;
    private String location;
    private String founder;

    public LabelDTO() {
    }

    public LabelDTO(int labelCode, String labelName, String location, String founder) {
        this.labelCode = labelCode;
        this.labelName = labelName;
        this.location = location;
        this.founder = founder;
    }

    public int getLabelCode() {
        return labelCode;
    }

    public void setLabelCode(int labelCode) {
        this.labelCode = labelCode;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    @Override
    public String toString() {
        return "LabelDTO{" +
                "labelCode=" + labelCode +
                ", labelName='" + labelName + '\'' +
                ", location='" + location + '\'' +
                ", founder='" + founder + '\'' +
                '}';
    }
}
