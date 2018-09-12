package com.stan.gamepedia.model;

public class GameDetail {

    private String id;
    private String title;
    private String url;
    private String icon;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public GameDetail(String id,String title,String url,String icon){
        super();
        this.icon = icon;
        this.id = id;
        this.title = title;
        this.url = url;
    }
}
