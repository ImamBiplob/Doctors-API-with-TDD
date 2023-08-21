package com.imambiplob.doctorsapi.entity;

public enum DoctorType {

    MEDICAL("Medical", "M"),
    DENTAL("Dental", "D");

    private final String label;
    private final String shortLabel;

    DoctorType(String label, String shortLabel) {
        this.label = label;
        this.shortLabel = shortLabel;
    }
}
