package com.stan.gamepedia.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.HashMap;
import java.util.Map;


@Table(name = "zelda_food")
public class ZeldaFood extends ZeldaItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String image;
    private String ingredient;
    private String effect;
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
//        map.put("ingredient", ingredient);
//        map.put("effect", effect);
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

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
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
