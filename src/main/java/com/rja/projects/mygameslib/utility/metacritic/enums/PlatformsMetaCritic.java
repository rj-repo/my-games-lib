package com.rja.projects.mygameslib.utility.metacritic.enums;

public enum PlatformsMetaCritic {

    /*
    playstation
     */
    PS5("playstation-5"),
    PS4("playstation-4"),
    PS3("playstation-3"),

    /*
       xbox
     */
    XONE("xbox-one"),
    XSERIESX("xbox-series-x"),
    X360("xbox-360"),

    /*
    PC
     */
    PC("pc"),

    /*
    switch
     */
    SWITCH("switch");

    private final String value;

    PlatformsMetaCritic(String value) {
        this.value = value;
    }

    public static PlatformsMetaCritic valueOfLabel(String label) {
        for (PlatformsMetaCritic e : values()) {
            if (e.value.equals(label)) {
                return e;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }
}
