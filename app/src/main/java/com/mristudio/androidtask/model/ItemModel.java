package com.mristudio.androidtask.model;

import java.io.Serializable;

public class ItemModel implements Serializable {
    String tittle;
    String description;

    public ItemModel(String tittle, String description) {
        this.tittle = tittle;
        this.description = description;
    }


    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
