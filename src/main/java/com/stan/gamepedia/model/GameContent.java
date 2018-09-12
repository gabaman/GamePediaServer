package com.stan.gamepedia.model;



import java.util.HashMap;
import java.util.Map;

public class GameContent {

    private String id;
    private String title;
    private String author;
    private String releaseDate;
    private String updateDate;
    private String content;
    private String icon;
    private String categoryId;
    private String gameId;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public GameContent(String id, String title, String author, String releaseDate, String updateDate, String content, String icon,String categoryId,String gameId){
        super();
        this.id = id;
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.updateDate = updateDate;
        this.content = content;
        this.icon = icon;
        this.categoryId = categoryId;
        this.gameId = gameId;
    }

    @Override
    public String toString() {
        return "GameContent{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", content='" + content + '\'' +
                ", icon='" + icon + '\'' +
                ", gameId='" + gameId + '\'' +
                ", categoryId='" + categoryId + '\'' +

                '}';
    }

    public Map<String,Object> toMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("title", title);
        map.put("author", author);
        map.put("releaseDate", releaseDate);
        map.put("updateDate", updateDate);
        map.put("content", content);
        map.put("icon",icon);
        map.put("categoryId",categoryId);
        map.put("gameId",gameId);

        return map;
    }
    public GameContent(){
        super();
    }
}
