package com.stan.gamepedia.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.HashMap;
import java.util.Map;


@Table(name = "zelda_material")
public class ZeldaMaterial extends ZeldaItem{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String image;
    private String quality;
    private String location;
    private String description;
    private String additionaluse;
    private String value;
    private String typeid;

    public Map<String,Object> toMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("title", name);
        map.put("content",description);
        map.put("typeid",typeid);
//        map.put("id", id);
//        map.put("name", name);
        map.put("image", image);
//        map.put("quality", quality);
//        map.put("location", location);
        map.put("description",description);
//        map.put("additionalUse",additionaluse);
//        map.put("value",value);
//        map.put("typeid",typeid);

        return map;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdditionaluse() {
        return additionaluse;
    }

    public void setAdditionaluse(String additionaluse) {
        this.additionaluse = additionaluse;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid;
    }
}
