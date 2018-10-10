package com.stan.gamepedia.service;

import com.github.abel533.entity.Example;
import com.stan.gamepedia.dao.ElasticSearchDao;
import com.stan.gamepedia.mapper.*;
import com.stan.gamepedia.model.*;
import com.stan.gamepedia.utils.COSClientUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConsoleService {

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
    @Autowired
    private GameContentService contentService;

    public  List<FinderModel> finderModelList(String key){
        List<FinderModel> totalList = new ArrayList<>();

        totalList.addAll(getFinderModelByType("zeldaweapon",key));
        totalList.addAll(getFinderModelByType("zeldashield",key));
        totalList.addAll(getFinderModelByType("zeldaarmor",key));
        totalList.addAll(getFinderModelByType("zeldamaterial",key));
        totalList.addAll(getFinderModelByType("zeldafood",key));

        return totalList;
    }

    public  int replaceKey(String key,String replace){

        int tag = 0;

        for (FinderModel model: getFinderModelByType("zeldaweapon",key)) {
            ZeldaWeapon wp = (ZeldaWeapon)contentService.getItemByTypeId(model.getTypeId());
            if (model.getTypeName().equals("name")){

                String tmp = wp.getName().replace(key,replace);

                wp.setName(tmp);

            }else if(model.getTypeName().equals("description")){

                String tmp = wp.getDescription().replace(key,replace);

                wp.setDescription(tmp);

            }
            tag++;
        }


        for (FinderModel model: getFinderModelByType("zeldashield",key)) {
            ZeldaShield wp = (ZeldaShield)contentService.getItemByTypeId(model.getTypeId());
            if (model.getTypeName().equals("name")){

                String tmp = wp.getName().replace(key,replace);

                wp.setName(tmp);

            }else if(model.getTypeName().equals("description")){

                String tmp = wp.getDescription().replace(key,replace);

                wp.setDescription(tmp);

            }
            tag++;

        }

        for (FinderModel model: getFinderModelByType("zeldaarmor",key)) {
            ZeldaArmor wp = (ZeldaArmor)contentService.getItemByTypeId(model.getTypeId());
            if (model.getTypeName().equals("name")){

                String tmp = wp.getName().replace(key,replace);

                wp.setName(tmp);

            }else if(model.getTypeName().equals("description")){

                String tmp = wp.getDescription().replace(key,replace);

                wp.setDescription(tmp);

            }else if(model.getTypeName().equals("effect")){

                String tmp = wp.getEffect().replace(key,replace);

                wp.setEffect(tmp);

            }
            tag++;

        }

        for (FinderModel model: getFinderModelByType("zeldamaterial",key)) {
            ZeldaMaterial wp = (ZeldaMaterial)contentService.getItemByTypeId(model.getTypeId());
            if (model.getTypeName().equals("name")){

                String tmp = wp.getName().replace(key,replace);

                wp.setName(tmp);

            }else if(model.getTypeName().equals("description")){

                String tmp = wp.getDescription().replace(key,replace);

                wp.setDescription(tmp);

            }else if(model.getTypeName().equals("location")){

                String tmp = wp.getLocation().replace(key,replace);

                wp.setLocation(tmp);

            }
            tag++;

        }

        for (FinderModel model: getFinderModelByType("zeldafood",key)) {
            ZeldaFood wp = (ZeldaFood)contentService.getItemByTypeId(model.getTypeId());
            if (model.getTypeName().equals("name")){

                String tmp = wp.getName().replace(key,replace);

                wp.setName(tmp);

            }else if(model.getTypeName().equals("description")){

                String tmp = wp.getDescription().replace(key,replace);

                wp.setDescription(tmp);

            }else if(model.getTypeName().equals("ingredient")){

                String tmp = wp.getIngredient().replace(key,replace);

                wp.setIngredient(tmp);

            }else if(model.getTypeName().equals("effect")){

                String tmp = wp.getEffect().replace(key,replace);

                wp.setEffect(tmp);

            }
            tag++;

        }

        return tag;
    }



    public List<FinderModel> getFinderModelByType(String type,String key) {
        Example example = null;
        if (type.equals("zeldaweapon") ){
            example = new Example(ZeldaWeapon.class);
            example.createCriteria().andIsNotNull("id");
            List<ZeldaWeapon> list = weaponMapper.selectByExample(example);
            List<FinderModel> temp = new ArrayList<>();
            for (ZeldaWeapon wp:list) {
                if (wp.getDescription().contains(key)){
                    FinderModel model = new FinderModel(wp.getTypeid(),type,"description",wp.getDescription());
                    temp.add(model);
                }

                if (wp.getName().contains(key)){
                    FinderModel model = new FinderModel(wp.getTypeid(),type,"name",wp.getName());
                    temp.add(model);
                }


            }
            return temp;
        }else if(type.equals("zeldashield")){
            example = new Example(ZeldaShield.class);
            example.createCriteria().andIsNotNull("id");
            List<ZeldaShield> list = shieldMapper.selectByExample(example);
            List<FinderModel> temp = new ArrayList<>();
            for (ZeldaShield wp:list) {
                if (wp.getDescription().contains(key)){
                    FinderModel model = new FinderModel(wp.getTypeid(),type,"description",wp.getDescription());
                    temp.add(model);
                }

                if (wp.getName().contains(key)){
                    FinderModel model = new FinderModel(wp.getTypeid(),type,"name",wp.getName());
                    temp.add(model);
                }


            }
            return temp;

        }else if(type.equals("zeldaarmor") ){
            example = new Example(ZeldaArmor.class);
            example.createCriteria().andIsNotNull("id");
            List<ZeldaArmor> list = armorMapper.selectByExample(example);
            List<FinderModel> temp = new ArrayList<>();
            for (ZeldaArmor wp:list) {
                if (wp.getDescription().contains(key)){
                    FinderModel model = new FinderModel(wp.getTypeid(),type,"description",wp.getDescription());
                    temp.add(model);
                }

                if (wp.getName().contains(key)){
                    FinderModel model = new FinderModel(wp.getTypeid(),type,"name",wp.getName());
                    temp.add(model);
                }

                if (wp.getEffect().contains(key)){
                    FinderModel model = new FinderModel(wp.getTypeid(),type,"effect",wp.getEffect());
                    temp.add(model);
                }

            }
            return temp;

        }else if(type.equals("zeldamaterial") ){
            example = new Example(ZeldaMaterial.class);
            example.createCriteria().andIsNotNull("id");
            List<ZeldaMaterial> list = materialMapper.selectByExample(example);
            List<FinderModel> temp = new ArrayList<>();
            for (ZeldaMaterial wp:list) {
                if (wp.getDescription().contains(key)){
                    FinderModel model = new FinderModel(wp.getTypeid(),type,"description",wp.getDescription());
                    temp.add(model);
                }

                if (wp.getName().contains(key)){
                    FinderModel model = new FinderModel(wp.getTypeid(),type,"name",wp.getName());
                    temp.add(model);
                }
                if (wp.getLocation().contains(key)){
                    FinderModel model = new FinderModel(wp.getTypeid(),type,"location",wp.getLocation());
                    temp.add(model);
                }

            }
            return temp;

        }else if(type.equals("zeldafood") ){
            example = new Example(ZeldaFood.class);
            example.createCriteria().andIsNotNull("id");
            List<ZeldaFood> list = foodMapper.selectByExample(example);
            List<FinderModel> temp = new ArrayList<>();
            for (ZeldaFood wp:list) {
                if (wp.getDescription().contains(key)){
                    FinderModel model = new FinderModel(wp.getTypeid(),type,"description",wp.getDescription());
                    temp.add(model);
                }

                if (wp.getName().contains(key)){
                    FinderModel model = new FinderModel(wp.getTypeid(),type,"name",wp.getName());
                    temp.add(model);
                }
                if (wp.getEffect().contains(key)){
                    FinderModel model = new FinderModel(wp.getTypeid(),type,"effect",wp.getEffect());
                    temp.add(model);
                }
                if (wp.getIngredient().contains(key)){
                    FinderModel model = new FinderModel(wp.getTypeid(),type,"ingredient",wp.getIngredient());
                    temp.add(model);
                }

            }
            return temp;

        }

        return null;
    }

    public GPResult update(ConsoleUpdater updater){

        if (!findTypeId(updater.getTypeid())){
            return GPResult.build(400, "未能找到typeId");
        }

        if (updater.getTypeid().startsWith("0000")){
            return GPResult.build(400, "神庙内容不能更新");
        }else if (updater.getTypeid().startsWith("1000")){
            return GPResult.build(400, "主线内容不能更新");

        }else if (updater.getTypeid().startsWith("2000")){
            ZeldaWeapon wp = (ZeldaWeapon)this.getItemByTypeId(updater.getTypeid());

                if (updater.getDescription() != null){
                    wp.setDescription(updater.getDescription());
                }
                if (updater.getName()!= null){
                    wp.setName(updater.getName());

                }
                if (updater.getDowncompedium() != null){
                    wp.setDowncompedium(updater.getDowncompedium());

                }
                if (updater.getUpcompedium() != null){
                    wp.setUpcompedium(updater.getUpcompedium());

                }
                if (updater.getAttack() != null){
                    wp.setAttack(updater.getAttack());

                }
                if (updater.getDurability() != null){
                    wp.setDurability(updater.getDurability());

                }
                weaponMapper.updateByPrimaryKeySelective(wp);

        }else if (updater.getTypeid().startsWith("3000")){
            ZeldaShield sh = (ZeldaShield)this.getItemByTypeId(updater.getTypeid());

            if (updater.getDescription() != null){
                sh.setDescription(updater.getDescription());
            }
            if (updater.getName()!= null){
                sh.setName(updater.getName());

            }
            if (updater.getDowncompedium() != null){
                sh.setDowncompedium(updater.getDowncompedium());

            }
            if (updater.getUpcompedium() != null){
                sh.setUpcompedium(updater.getUpcompedium());

            }
            if (updater.getStrength() != null){
                sh.setStrength(updater.getStrength());

            }
            if (updater.getDurability() != null){
                sh.setDurability(updater.getDurability());

            }
            shieldMapper.updateByPrimaryKeySelective(sh);

        }else if (updater.getTypeid().startsWith("4000")){
            ZeldaArmor sh = (ZeldaArmor)this.getItemByTypeId(updater.getTypeid());

            if (updater.getDescription() != null){
                sh.setDescription(updater.getDescription());
            }
            if (updater.getName()!= null){
                sh.setName(updater.getName());

            }
            if (updater.getDefense() != null){
                sh.setDefense(updater.getDefense());

            }
            if (updater.getEffect() != null){
                sh.setEffect(updater.getEffect());

            }
            armorMapper.updateByPrimaryKeySelective(sh);

        }else if (updater.getTypeid().startsWith("5000")){
            ZeldaMaterial sh = (ZeldaMaterial)this.getItemByTypeId(updater.getTypeid());

            if (updater.getDescription() != null){
                sh.setDescription(updater.getDescription());
            }
            if (updater.getName()!= null){
                sh.setName(updater.getName());
            }
            if (updater.getQuality() != null){
                sh.setQuality(updater.getQuality());

            }
            if (updater.getLocation() != null){
                sh.setLocation(updater.getLocation());
            }
            if (updater.getAdditionaluse() != null){
                sh.setAdditionaluse(updater.getAdditionaluse());

            }
            if (updater.getValue() != null){
                sh.setValue(updater.getValue());
            }
            materialMapper.updateByPrimaryKeySelective(sh);

        }else if (updater.getTypeid().startsWith("6000")){
            ZeldaFood sh = (ZeldaFood)this.getItemByTypeId(updater.getTypeid());

            if (updater.getDescription() != null){
                sh.setDescription(updater.getDescription());
            }
            if (updater.getName()!= null){
                sh.setName(updater.getName());
            }

            if (updater.getIngredient() != null){
                sh.setIngredient(updater.getIngredient());

            }
            if (updater.getEffect() != null){
                sh.setEffect(updater.getEffect());
            }
            foodMapper.updateByPrimaryKeySelective(sh);

        }else{
            return GPResult.build(400, "typeId错误");

        }
        return GPResult.ok();
    }




    private ZeldaItem getItemByTypeId(String typeid){
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

    public List retrieveData(String categoryId){
        if (!categoryId.equals("10001")&&!categoryId.equals("10002")){
            return this.getZeldaItem(categoryId);

        }else{
            return this.getZeldaTemple(categoryId);

        }
    }

    private  List getZeldaTemple(String categoryId) {

        Example example = new Example(ZeldaTemple.class);
        example.createCriteria().andIsNotNull("id");
        List<ZeldaTemple> list = zeldaTempleMapper.selectByExample(example);
        List<ZeldaTemple> temp = new ArrayList<>();
        int tag = 1;
        for (int i = 0; i < list.size(); i++) {
            ZeldaTemple temple = list.get(i);

            Boolean isTemple = categoryId.equals("10001");
            Boolean condition = temple.getTypeid().startsWith("0");





            if (isTemple) {
                if (!condition) {
                    continue;
                }
            } else {
                if (condition) {
                    continue;
                }
            }
            System.out.println("==============");
            System.out.println(temple.getTypeid());
            System.out.println(temple.getTitle());
            temp.add(temple);
        }

        return temp;
    }

    private List getZeldaItem(String categoryId) {

       if (categoryId.equals("10003")){
            Example example = new Example(ZeldaWeapon.class);
            example.createCriteria().andIsNotNull("id");
            List<ZeldaWeapon> list = weaponMapper.selectByExample(example);
            return list;
        }if (categoryId.equals("10004")){
            Example example = new Example(ZeldaShield.class);
            example.createCriteria().andIsNotNull("id");
            List<ZeldaShield> list = shieldMapper.selectByExample(example);
            return list;
        }if (categoryId.equals("10005")){
            Example example = new Example(ZeldaArmor.class);
            example.createCriteria().andIsNotNull("id");
            List<ZeldaArmor> list = armorMapper.selectByExample(example);
            return list;
        }if (categoryId.equals("10006")){
            Example example = new Example(ZeldaMaterial.class);
            example.createCriteria().andIsNotNull("id");
            List<ZeldaMaterial> list = materialMapper.selectByExample(example);
            return list;
        }if (categoryId.equals("10007")){
            Example example = new Example(ZeldaFood.class);
            example.createCriteria().andIsNotNull("id");
            List<ZeldaFood> list = foodMapper.selectByExample(example);
            return  list;
        }


        return null;

    }

    public GPResult esSaveAll(){

        List<Map> temp = new ArrayList<>();

        temp.addAll(esSaveItem("zeldaweapon","10003"));
        temp.addAll(esSaveItem("zeldashield","10004"));
        temp.addAll(esSaveItem("zeldaarmor","10005"));
        temp.addAll(esSaveItem("zeldamaterial","10006"));
        temp.addAll(esSaveItem("zeldafood","10007"));

        if (temp.size() <1){
            return GPResult.ok();
        }else{
            return GPResult.build(400,"同步数据错误",temp);
        }
    }

    private List<Map> esSaveItem(String type,String categoryId){
        List<ZeldaItem> list = this.getZeldaItem(categoryId);

        List<Map> temp = new ArrayList<>();

        for (ZeldaItem it:list) {
            Boolean isSuccess = gameDao.saveType(type,it);
            if (!isSuccess){
                Map map = new HashMap();
                map.put("type",type);
                map.put("error",it);
                temp.add(map);
            }
        }

        return temp;
    }

    public GPResult uploadImageWithTypeId(MultipartFile file,String typeId) throws Exception {

        COSClientUtil util = new COSClientUtil();

        if (typeId.startsWith("1")||typeId.startsWith("0")) {
            return GPResult.build(400, "不能修改temple和主线的图片");
        }
        if (!findTypeId(typeId)){
            return GPResult.build(400, "未能找到typeId");
        }

        String name = util.uploadFile2Cos(file,"content/"+typeId+".jpg");
        String imgUrl = util.getImgUrl(name);
        String[] split = imgUrl.split("\\?");

        return GPResult.ok(split[0]);

    }


    private boolean findTypeId(String typeId){
        Example example1 = new Example(ZeldaWeapon.class);
        example1.createCriteria().andEqualTo("typeid",typeId);
        List<ZeldaWeapon> list1 = weaponMapper.selectByExample(example1);
        if (list1.size()>0){return true;}
        Example example2 = new Example(ZeldaShield.class);
        example2.createCriteria().andEqualTo("typeid",typeId);
        List<ZeldaShield> list2 = shieldMapper.selectByExample(example2);
        if (list2.size()>0){return true;}
        Example example3 = new Example(ZeldaArmor.class);
        example3.createCriteria().andEqualTo("typeid",typeId);
        List<ZeldaArmor> list3 = armorMapper.selectByExample(example3);
        if (list3.size()>0){return true;}
        Example example4 = new Example(ZeldaMaterial.class);
        example4.createCriteria().andEqualTo("typeid",typeId);
        List<ZeldaMaterial> list4 = materialMapper.selectByExample(example4);
        if (list4.size()>0){return true;}
        Example example5 = new Example(ZeldaFood.class);
        example5.createCriteria().andEqualTo("typeid",typeId);
        List<ZeldaFood> list5 = foodMapper.selectByExample(example5);
        if (list5.size()>0){return true;}
        return false;

    }

    public GPResult delete(String typeId){
        if (typeId.startsWith("1")||typeId.startsWith("0")) {
            return GPResult.build(400, "不能修改temple和主线的图片");
        }
        if (!findTypeId(typeId)){
            return GPResult.build(400, "未能找到typeId");
        }

        if (typeId.startsWith("2")){
            Example example = new Example(ZeldaWeapon.class);
            example.createCriteria().andEqualTo("typeid",typeId);
            weaponMapper.deleteByExample(example);
        }
        if (typeId.startsWith("3")){
            Example example = new Example(ZeldaShield.class);
            example.createCriteria().andEqualTo("typeid",typeId);
            shieldMapper.deleteByExample(example);
        }
        if (typeId.startsWith("4")){
            Example example = new Example(ZeldaArmor.class);
            example.createCriteria().andEqualTo("typeid",typeId);
            armorMapper.deleteByExample(example);
        }
        if (typeId.startsWith("5")){
            Example example = new Example(ZeldaMaterial.class);
            example.createCriteria().andEqualTo("typeid",typeId);
            materialMapper.deleteByExample(example);
        }
        if (typeId.startsWith("6")){
            Example example = new Example(ZeldaFood.class);
            example.createCriteria().andEqualTo("typeid",typeId);
            foodMapper.deleteByExample(example);
        }


        return GPResult.ok();

    }

    public GPResult add(ConsoleUpdater updater,String categoryId){
        if (!findTypeId(updater.getTypeid())){
            return GPResult.build(400, "未能找到typeId");
        }

         if (categoryId.equals("10003")){
            ZeldaWeapon wp = (ZeldaWeapon)this.getItemByTypeId(updater.getTypeid());

            if (updater.getDescription() != null){
                wp.setDescription(updater.getDescription());
            }
            if (updater.getName()!= null){
                wp.setName(updater.getName());

            }
            if (updater.getDowncompedium() != null){
                wp.setDowncompedium(updater.getDowncompedium());

            }
            if (updater.getUpcompedium() != null){
                wp.setUpcompedium(updater.getUpcompedium());

            }
            if (updater.getAttack() != null){
                wp.setAttack(updater.getAttack());

            }
            if (updater.getDurability() != null){
                wp.setDurability(updater.getDurability());

            }
            weaponMapper.updateByPrimaryKeySelective(wp);

        }else if (categoryId.equals("10004")){
            ZeldaShield sh = (ZeldaShield)this.getItemByTypeId(updater.getTypeid());

            if (updater.getDescription() != null){
                sh.setDescription(updater.getDescription());
            }
            if (updater.getName()!= null){
                sh.setName(updater.getName());

            }
            if (updater.getDowncompedium() != null){
                sh.setDowncompedium(updater.getDowncompedium());

            }
            if (updater.getUpcompedium() != null){
                sh.setUpcompedium(updater.getUpcompedium());

            }
            if (updater.getStrength() != null){
                sh.setStrength(updater.getStrength());

            }
            if (updater.getDurability() != null){
                sh.setDurability(updater.getDurability());

            }
            shieldMapper.updateByPrimaryKeySelective(sh);

        }else if (categoryId.equals("10005")){
            ZeldaArmor sh = (ZeldaArmor)this.getItemByTypeId(updater.getTypeid());

            if (updater.getDescription() != null){
                sh.setDescription(updater.getDescription());
            }
            if (updater.getName()!= null){
                sh.setName(updater.getName());

            }
            if (updater.getDefense() != null){
                sh.setDefense(updater.getDefense());

            }
            if (updater.getEffect() != null){
                sh.setEffect(updater.getEffect());

            }
            armorMapper.updateByPrimaryKeySelective(sh);

        }else if (categoryId.equals("10006")){
            ZeldaMaterial sh = (ZeldaMaterial)this.getItemByTypeId(updater.getTypeid());

            if (updater.getDescription() != null){
                sh.setDescription(updater.getDescription());
            }
            if (updater.getName()!= null){
                sh.setName(updater.getName());
            }
            if (updater.getQuality() != null){
                sh.setQuality(updater.getQuality());

            }
            if (updater.getLocation() != null){
                sh.setLocation(updater.getLocation());
            }
            if (updater.getAdditionaluse() != null){
                sh.setAdditionaluse(updater.getAdditionaluse());

            }
            if (updater.getValue() != null){
                sh.setValue(updater.getValue());
            }
            materialMapper.updateByPrimaryKeySelective(sh);

        }else if (categoryId.equals("10007")){
            ZeldaFood sh = (ZeldaFood)this.getItemByTypeId(updater.getTypeid());

            if (updater.getDescription() != null){
                sh.setDescription(updater.getDescription());
            }
            if (updater.getName()!= null){
                sh.setName(updater.getName());
            }

            if (updater.getIngredient() != null){
                sh.setIngredient(updater.getIngredient());

            }
            if (updater.getEffect() != null){
                sh.setEffect(updater.getEffect());
            }
            foodMapper.updateByPrimaryKeySelective(sh);

        }else{
            return GPResult.build(400, "typeId错误");

        }
        return GPResult.ok();
    }

    private String findLargestTypeId(String categoryId){
        
    }
}
