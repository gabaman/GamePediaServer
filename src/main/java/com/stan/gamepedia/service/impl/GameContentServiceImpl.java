package com.stan.gamepedia.service.impl;

import com.github.abel533.entity.Example;
import com.github.pagehelper.Page;
import com.stan.gamepedia.dao.ElasticSearchDao;
import com.stan.gamepedia.mapper.*;
import com.stan.gamepedia.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stan.gamepedia.service.GameContentService;

import java.util.*;

@Service
public class GameContentServiceImpl implements GameContentService {

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

//    @Override
//    public GameContent save(GameContent gameContent) {
//
//        gameContent.setReleaseDate(new Date().toString());
//        gameContent.setUpdateDate(new Date().toString());
//        return gameDao.save(gameContent);
//
//
//    }
//
//    @Override
//    public void delete(GameContent gameContent) {
//
//    }
//
    @Override
    public EsResult findAll(String query) {
        return gameDao.searchAll(query,0,10);
    }
//
//


    @Override
    public List<Game> getGameList() {



        Example example = new Example(Game.class);
        example.createCriteria().andIsNull("typeid");
        List<Game> list = gameMapper.selectByExample(example);


        return list;
    }

    @Override
    public List<Game> getGameCategory(Long gameid) {

        Example example = new Example(Game.class);
        example.createCriteria().andEqualTo("gameid",gameid);
        List<Game> list = gameMapper.selectByExample(example);
        return list;
    }

    @Override
    public List<ZeldaTemple> getTempleByTypeId(String typeid) {

        Example example = new Example(ZeldaTemple.class);
        example.createCriteria().andEqualTo("typeid",typeid);
        List<ZeldaTemple> list = zeldaTempleMapper.selectByExample(example);

        return list;
    }

    @Override
    public void updateTemple() {

        Example example = new Example(ZeldaTemple.class);
        example.createCriteria().andIsNotNull("id");
        List<ZeldaTemple> list = zeldaTempleMapper.selectByExample(example);

        for (ZeldaTemple temple:list) {
            if (Integer.valueOf(temple.getTypeid())<1000){
               String newString = "0000" + temple.getTypeid();
               temple.setTypeid(newString);
               zeldaTempleMapper.updateByPrimaryKeySelective(temple);
            }
        }


    }


    @Override
    public List<ZeldaContent> getContentList(String categoryId) {

        if (categoryId.equals("10001")){
            List<ZeldaTemple> list = this.getPicOneTemple(true);
//            Example example = new Example(ZeldaTemple.class);
//            example.createCriteria().andLike("typeid","1000");
//            List<ZeldaTemple> list = zeldaTempleMapper.selectByExample(example);
            List<ZeldaContent> temp = new ArrayList<>();
            for (ZeldaTemple temple : list){
                ZeldaContent content = new ZeldaContent();
                content.setId(temple.getId());
                content.setImage(temple.getContent());
                content.setDescription("");
                content.setName(temple.getTitle());
                content.setTypeid(temple.getTypeid());
                temp.add(content);
            }

            return temp;
        }else if (categoryId.equals("10002")){
//            Example example = new Example(ZeldaTemple.class);
//            example.createCriteria().andLike("typeid","2000");
//
//            List<ZeldaTemple> list = zeldaTempleMapper.selectByExample(example);
            List<ZeldaTemple> list = this.getPicOneTemple(false);
            List<ZeldaContent> temp = new ArrayList<>();
            for (ZeldaTemple temple : list){
                ZeldaContent content = new ZeldaContent();
                content.setId(temple.getId());
                content.setImage(temple.getContent());
                content.setDescription("");
                content.setName(temple.getTitle());
                content.setTypeid(temple.getTypeid());
                temp.add(content);

            }
            return temp;
        }if (categoryId.equals("10003")){
            Example example = new Example(ZeldaWeapon.class);
            example.createCriteria().andIsNotNull("id");
            List<ZeldaWeapon> list = weaponMapper.selectByExample(example);
            List<ZeldaContent> temp = new ArrayList<>();
            for (ZeldaWeapon temple : list){
                ZeldaContent content = new ZeldaContent();
                content.setId(temple.getId());
                content.setImage(temple.getImage());
                content.setDescription(temple.getDescription());
                content.setName(temple.getName());
                content.setTypeid(temple.getTypeid());
                temp.add(content);

            }
            return temp;
        }if (categoryId.equals("10004")){
            Example example = new Example(ZeldaShield.class);
            example.createCriteria().andIsNotNull("id");
            List<ZeldaShield> list = shieldMapper.selectByExample(example);
            List<ZeldaContent> temp = new ArrayList<>();
            for (ZeldaShield temple : list){
                ZeldaContent content = new ZeldaContent();
                content.setId(temple.getId());
                content.setImage(temple.getImage());
                content.setDescription(temple.getDescription());
                content.setName(temple.getName());
                content.setTypeid(temple.getTypeid());
                temp.add(content);

            }
            return temp;
        }if (categoryId.equals("10005")){
            Example example = new Example(ZeldaArmor.class);
            example.createCriteria().andIsNotNull("id");
            List<ZeldaArmor> list = armorMapper.selectByExample(example);
            List<ZeldaContent> temp = new ArrayList<>();
            for (ZeldaArmor temple : list){
                ZeldaContent content = new ZeldaContent();
                content.setId(temple.getId());
                content.setImage(temple.getImage());
                content.setDescription(temple.getDescription());
                content.setName(temple.getName());
                content.setTypeid(temple.getTypeid());
                temp.add(content);

            }
            return temp;
        }if (categoryId.equals("10006")){
            Example example = new Example(ZeldaMaterial.class);
            example.createCriteria().andIsNotNull("id");
            List<ZeldaMaterial> list = materialMapper.selectByExample(example);
            List<ZeldaContent> temp = new ArrayList<>();
            for (ZeldaMaterial temple : list){
                ZeldaContent content = new ZeldaContent();
                content.setId(temple.getId());
                content.setImage(temple.getImage());
                content.setDescription(temple.getDescription());
                content.setName(temple.getName());
                content.setTypeid(temple.getTypeid());
                temp.add(content);

            }
            return temp;
        }if (categoryId.equals("10007")){
            Example example = new Example(ZeldaFood.class);
            example.createCriteria().andIsNotNull("id");
            List<ZeldaFood> list = foodMapper.selectByExample(example);
            List<ZeldaContent> temp = new ArrayList<>();
            for (ZeldaFood temple : list){
                ZeldaContent content = new ZeldaContent();
                content.setId(temple.getId());
                content.setImage(temple.getImage());
                content.setDescription(temple.getDescription());
                content.setName(temple.getName());
                content.setTypeid(temple.getTypeid());
                temp.add(content);

            }
            return temp;
        }


            return null;

    }

    public ZeldaItem getItemByTypeId(String typeid){
        String beginTag = typeid.substring(0,1);
        if (beginTag.equals("2")){
            Example example = new Example(ZeldaWeapon.class);
            example.createCriteria().andEqualTo("typeid",typeid);
            List<ZeldaWeapon> list = weaponMapper.selectByExample(example);

            return list.get(0);
        }
        if (beginTag.equals("3")){
            Example example = new Example(ZeldaShield.class);
            example.createCriteria().andEqualTo("typeid",typeid);
            List<ZeldaShield> list = shieldMapper.selectByExample(example);

            return list.get(0);
        }
        if (beginTag.equals("4")){
            Example example = new Example(ZeldaArmor.class);
            example.createCriteria().andEqualTo("typeid",typeid);
            List<ZeldaArmor> list = armorMapper.selectByExample(example);

            return list.get(0);
        }
        if (beginTag.equals("5")){
            Example example = new Example(ZeldaMaterial.class);
            example.createCriteria().andEqualTo("typeid",typeid);
            List<ZeldaMaterial> list = materialMapper.selectByExample(example);

            return list.get(0);
        }
        if (beginTag.equals("6")){
            Example example = new Example(ZeldaFood.class);
            example.createCriteria().andEqualTo("typeid",typeid);
            List<ZeldaFood> list = foodMapper.selectByExample(example);

            return list.get(0);
        }
        return  null;
    }



    @Override
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

    @Override
    public ZeldaTemple saveTemple(ZeldaTemple zeldaTemple) {
        return null;
    }

//    @Override
//    public List<ZeldaTemple> getAllTemple() {
////        Example example = new Example(ZeldaTemple.class);
////        example.createCriteria().andEqualTo("istext",1);
////        List<ZeldaTemple> list = zeldaTempleMapper.selectByExample(example);
////        for (int i = 0; i < list.size(); i++) {
////
////        }
////        return list;
//        Example example = new Example(ZeldaTemple.class);
//        example.createCriteria().andEqualTo("istext",1);
//        List<ZeldaTemple> list = zeldaTempleMapper.selectByExample(example);
//        List<ZeldaTemple> temp = new ArrayList<>();
//        int tag = 1;
//        for (int i = 0; i < list.size(); i++) {
//            ZeldaTemple temple = list.get(i);
//
//
//            if (Integer.valueOf(temple.getTypeid()) > 10000){
//                continue;
//            }
//            System.out.println(temple.getTypeid());
//            String tagStr = String.valueOf(tag);
//            System.out.println(tagStr);
//
//            if (temple.getTypeid().equals(tagStr)) {
//                tag++;
//                System.out.println("tag="+tag);
//                temp.add(temple);
//            }
//        }
//        return temp;
//    }

    public List<ZeldaTemple> getTemplePic(){
        Example example = new Example(ZeldaTemple.class);
        example.createCriteria().andEqualTo("istext",1);
        List<ZeldaTemple> list = zeldaTempleMapper.selectByExample(example);
        return list;
    }

    @Override
    public void updateTemple(ZeldaTemple temple) {
        zeldaTempleMapper.updateByPrimaryKeySelective(temple);
    }

    @Override
    public void updateItem(String type, ZeldaItem item) {
        if (type.equals("zeldaweapon") ){
            ZeldaWeapon wp = (ZeldaWeapon)item;
            weaponMapper.updateByPrimaryKeySelective(wp);

        }else if(type.equals("zeldashield")){
            ZeldaShield wp = (ZeldaShield)item;
            shieldMapper.updateByPrimaryKeySelective(wp);

        }else if(type.equals("zeldaarmor") ){
            ZeldaArmor wp = (ZeldaArmor)item;
            armorMapper.updateByPrimaryKeySelective(wp);
        }else if(type.equals("zeldamaterial") ){
            ZeldaMaterial wp = (ZeldaMaterial)item;
            materialMapper.updateByPrimaryKeySelective(wp);

        }else if(type.equals("zeldafood") ){
            ZeldaFood wp = (ZeldaFood)item;
            foodMapper.updateByPrimaryKeySelective(wp);

        }
    }



//    @Override
//    public ZeldaTemple saveTemple(ZeldaTemple zeldaTemple) {
//
//        return gameDao.saveTemple(zeldaTemple);
//    }

    @Override
    public void saveItem(String type,ZeldaItem zeldaItem) {
        gameDao.saveType(type,zeldaItem);
    }

    @Override
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
