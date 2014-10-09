package me.alexrs.cervantes.core.datamodel;

import com.google.gson.annotations.Expose;

public class Meaning {

    @Expose
    private String meaning;
    @Expose
    private String meta;

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

}
