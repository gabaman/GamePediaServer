package com.stan.gamepedia.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.HashMap;
import java.util.Map;


@Table(name = "zelda_shield")
public class ZeldaShield extends ZeldaItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String image;
    private String downcompedium;
    private String upcompedium;
    private String strength;
    private String durability;
    private String description;
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
//        map.put("downCompedium", downcompedium);
//        map.put("upCompedium", upcompedium);
//        map.put("strength", strength);
//        map.put("durability",durability);
        map.put("description",description);
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

    public String getDowncompedium() {
        return downcompedium;
    }

    public void setDowncompedium(String downcompedium) {
        this.downcompedium = downcompedium;
    }

    public String getUpcompedium() {
        return upcompedium;
    }

    public void setUpcompedium(String upcompedium) {
        this.upcompedium = upcompedium;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getDurability() {
        return durability;
    }

    public void setDurability(String durability) {
        this.durability = durability;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid;
    }
}
