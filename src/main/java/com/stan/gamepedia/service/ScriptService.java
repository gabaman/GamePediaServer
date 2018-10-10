package com.stan.gamepedia.service;


import com.github.abel533.entity.Example;
import com.stan.gamepedia.dao.ElasticSearchDao;
import com.stan.gamepedia.mapper.*;
import com.stan.gamepedia.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScriptService {

    @Autowired
    private ElasticSearchDao gameDao;

    @Autowired
    private GameMapper gameMapper;

    @Autowired
    private ZeldaTempleMapper zeldaTempleMapper;


    @Autowired
    private ZeldaWeaponMapper weaponMapper;
    @Autowired
    private ZeldaShieldMapper shieldMapper;
    @Autowired
    private ZeldaArmorMapper armorMapper;
    @Autowired
    private ZeldaMaterialMapper materialMapper;
    @Autowired
    private ZeldaFoodMapper foodMapper;


    public void dumpToEs(){

        saveTempleOrPrinciple(true);
        saveTempleOrPrinciple(false);
        saveAllItem();

    }

    public void saveTempleOrPrinciple(boolean isTemple){
        List<ZeldaTemple> list = this.getPicOneTemple(isTemple);

        for (ZeldaTemple temple: list) {
            System.out.println(temple.getTitle());
            System.out.println(temple.getContent());
            gameDao.saveTemple(temple,isTemple);
        }
    }

    //获取typeid中的一个temple
    public List<ZeldaTemple> getPicOneTemple(boolean isTemple) {
        Example example = new Example(ZeldaTemple.class);
        example.createCriteria().andEqualTo("istext",1);
        List<ZeldaTemple> list = zeldaTempleMapper.selectByExample(example);
        List<ZeldaTemple> temp = new ArrayList<>();
        int tag = 1;
        for (int i = 0; i < list.size(); i++) {
            ZeldaTemple temple = list.get(i);

            Boolean condition = temple.getTypeid().startsWith("0");


            System.out.println("==============");
            System.out.println(temple.getTypeid());

            if (isTemple){
                if (!condition){
                    continue;
                }
            }else {
                if (condition){
                    continue;
                }
            }



            System.out.println(temple.getTypeid());
            String prefix = isTemple?"0000":"10001";
            String tagStr = prefix + String.valueOf(tag);
            System.out.println(tagStr);

            if (temple.getTypeid().equals(tagStr)) {
                tag++;
                System.out.println("tag="+tag);
                temp.add(temple);
            }
        }
        return temp;
    }

    public void saveAllItem(){

        saveItem("zeldaweapon");
        saveItem("zeldashield");
        saveItem("zeldaarmor");
        saveItem("zeldamaterial");
        saveItem("zeldafood");

    }

    public void saveItem(String type){
        List<ZeldaItem> list = this.getZeldaItem(type);

        for (ZeldaItem it:list) {
            gameDao.saveType(type,it);

        }
    }

    public List<ZeldaItem> getZeldaItem(String type) {
        Example example = null;
        if (type.equals("zeldaweapon") ){
            example = new Example(ZeldaWeapon.class);
            example.createCriteria().andIsNotNull("id");
            List<ZeldaWeapon> list = weaponMapper.selectByExample(example);
            List<ZeldaItem> temp = new ArrayList<>();
            for (ZeldaWeapon wp:list) {
                ZeldaItem it = (ZeldaItem)wp;
                temp.add(it);
            }
            return temp;
        }else if(type.equals("zeldashield")){
            example = new Example(ZeldaShield.class);
            example.createCriteria().andIsNotNull("id");
            List<ZeldaShield> list = shieldMapper.selectByExample(example);
            List<ZeldaItem> temp = new ArrayList<>();
            for (ZeldaShield wp:list) {
                ZeldaItem it = (ZeldaItem)wp;
                temp.add(it);
            }
            return temp;

        }else if(type.equals("zeldaarmor") ){
            example = new Example(ZeldaArmor.class);
            example.createCriteria().andIsNotNull("id");
            List<ZeldaArmor> list = armorMapper.selectByExample(example);
            List<ZeldaItem> temp = new ArrayList<>();
            for (ZeldaArmor wp:list) {
                ZeldaItem it = (ZeldaItem)wp;
                temp.add(it);
            }
            return temp;

        }else if(type.equals("zeldamaterial") ){
            example = new Example(ZeldaMaterial.class);
            example.createCriteria().andIsNotNull("id");
            List<ZeldaMaterial> list = materialMapper.selectByExample(example);
            List<ZeldaItem> temp = new ArrayList<>();
            for (ZeldaMaterial wp:list) {
                ZeldaItem it = (ZeldaItem)wp;
                temp.add(it);
            }
            return temp;

        }else if(type.equals("zeldafood") ){
            example = new Example(ZeldaFood.class);
            example.createCriteria().andIsNotNull("id");
            List<ZeldaFood> list = foodMapper.selectByExample(example);
            List<ZeldaItem> temp = new ArrayList<>();
            for (ZeldaFood wp:list) {
                ZeldaItem it = (ZeldaItem)wp;
                temp.add(it);
            }
            return temp;

        }

        return null;
    }


}
