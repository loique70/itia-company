package com.itia.sitevitrine.models;

public enum EnumRequestStatus {
    PENDING("PENDING"),
    REJECTED("REJECTED"),
    APPROUVED("APPROUVED");

    private String enumStatus;

    EnumRequestStatus(String enumStatus) {
        this.enumStatus = enumStatus;
    }

    public String getStatus() {
        return this.enumStatus;
    }
}
