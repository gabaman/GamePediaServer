package com.stan.gamepedia.controller;

import com.stan.gamepedia.model.*;
import com.stan.gamepedia.service.GameContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "/game")
@Controller
public class GameContentController {

    @Autowired
    private GameContentService service;



    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public GPResult query(HttpServletRequest request,String query) {
        return GPResult.ok(service.findAll(query));
    }


    @RequestMapping(value = "/gameList", method = RequestMethod.POST)
    @ResponseBody
    public GPResult gameList(HttpServletRequest request) {

        return GPResult.ok(service.getGameList());
    }

    @RequestMapping(value = "/templeDetail", method = RequestMethod.POST)
    @ResponseBody
    public GPResult temple(HttpServletRequest request, String typeId) {

        return GPResult.ok(service.getTempleByTypeId(typeId));
    }

    @RequestMapping(value = "/itemDetail", method = RequestMethod.POST)
    @ResponseBody
    public GPResult item(HttpServletRequest request, String typeId) {

        ZeldaItem item = service.getItemByTypeId(typeId);
        String beginTag = typeId.substring(0,1);



        if (beginTag.equals("2")) {
            ZeldaWeapon it   = (ZeldaWeapon)item;
            return GPResult.ok(it);
        }
        if (beginTag.equals("3")) {
            ZeldaShield it   = (ZeldaShield)item;
            return GPResult.ok(it);
        }
        if (beginTag.equals("4")) {
            ZeldaArmor it   = (ZeldaArmor)item;
            return GPResult.ok(it);
        }
        if (beginTag.equals("5")) {
            ZeldaMaterial it   = (ZeldaMaterial) item;
            return GPResult.ok(it);
        }
        if (beginTag.equals("6")) {
            ZeldaFood it   = (ZeldaFood)item;
            return GPResult.ok(it);
        }
        return GPResult.build(400,"error data");
    }
    @RequestMapping(value = "/gameCategory", method = RequestMethod.POST)
    @ResponseBody
    public GPResult gameCategory(HttpServletRequest request, String gameId) {



        return GPResult.ok(service.getGameCategory(Long.valueOf(gameId)));
    }

    @RequestMapping(value = "/contentList", method = RequestMethod.POST)
    @ResponseBody
    public GPResult contentList(HttpServletRequest request, String categoryId) {


        return GPResult.ok(service.getContentList(categoryId));
    }
}
