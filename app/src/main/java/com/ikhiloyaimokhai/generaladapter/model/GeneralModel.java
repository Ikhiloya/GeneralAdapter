package com.ikhiloyaimokhai.generaladapter.model;

import static com.ikhiloyaimokhai.generaladapter.model.Constant.*;

public class GeneralModel {
    private int icon;
    private String title;
    private String subTitle;
    private String date;
    private String modelType;


    public GeneralModel(int icon, String title, String subTitle, String date) {
        this.icon = icon;
        this.title = title;
        this.subTitle = subTitle;
        this.date = date;
        this.modelType = LAYOUT_A;
    }


    public GeneralModel(String title, String subTitle, String date) {
        this.title = title;
        this.subTitle = subTitle;
        this.date = date;
        this.modelType = LAYOUT_B;

    }


    public GeneralModel(int icon, String title, String date) {
        this.icon = icon;
        this.title = title;
        this.date = date;
        this.modelType = LAYOUT_C;
    }

    public GeneralModel(String title) {
        this.title = title;
        this.modelType = GENERAL_LAYOUT;

    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    @Override
    public String toString() {
        return "GeneralModel{" +
                "icon=" + icon +
                ", title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", date='" + date + '\'' +
                ", modelType='" + modelType + '\'' +
                '}';
    }
}
