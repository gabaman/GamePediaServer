package com.stan.gamepedia.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.HashMap;
import java.util.Map;

@Table(name = "zelda_weapon")
public class ZeldaWeapon extends ZeldaItem{

    /*
    * self.name = name
       self.image = image
       self.downCompedium = downCompedium
       self.upCompedium = upCompedium
       self.attack = attack
       self.durability = durability
       self.description = description
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String image;
    private String downcompedium;
    private String upcompedium;
    private String attack;
    private String durability;
    private String description;
    private String typeid;


    public Map<String,Object> toMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("title", name);
        map.put("content",description);
        map.put("typeid",typeid);
//        map.put("image", image);
//        map.put("downCompedium", downcompedium);
//        map.put("upCompedium", upcompedium);
//        map.put("attack", attack);
//        map.put("durability",durability);
//        map.put("description",description);


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

    public String getDdowncompedium() {
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

    public String getAttack() {
        return attack;
    }

    public void setAttack(String attack) {
        this.attack = attack;
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
