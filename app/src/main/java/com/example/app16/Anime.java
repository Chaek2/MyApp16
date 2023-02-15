package com.example.app16;

public class Anime {
    private int ID;
    private String TitleName;
    private String AvtorName;

    public Anime(int ID, String TitleName, String AvtorName){
        this.ID = ID;
        this.TitleName = TitleName;
        this.AvtorName = AvtorName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitleName() {
        return TitleName;
    }

    public void setTitleName(String titleName) {
        TitleName = titleName;
    }

    public String getAvtorName() {
        return AvtorName;
    }

    public void setAvtorName(String avtorName) {
        AvtorName = avtorName;
    }
}
