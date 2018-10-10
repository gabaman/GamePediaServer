package com.stan.gamepedia.controller;


import com.stan.gamepedia.model.ConsoleUpdater;
import com.stan.gamepedia.model.GPResult;
import com.stan.gamepedia.model.GameContent;
import com.stan.gamepedia.service.ConsoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RequestMapping(value = "/console")
@Controller
public class ConsoleController {

    @Autowired
    private ConsoleService service;

    @RequestMapping(value = "/replace", method = RequestMethod.POST)
    @ResponseBody
    public GPResult query(HttpServletRequest request, String key, String replace) {
        int tag = service.replaceKey(key, replace);
        return GPResult.ok(tag);
    }

    @RequestMapping(value = "/finder", method = RequestMethod.POST)
    @ResponseBody
    public GPResult save(HttpServletRequest request, String key) {

        return GPResult.ok(service.finderModelList(key));
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public GPResult list(HttpServletRequest request, String categoryId) {

        return GPResult.ok(service.retrieveData(categoryId));
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public GPResult update(HttpServletRequest request, ConsoleUpdater updater) {

        return service.update(updater);
    }

    @RequestMapping(value = "/sync", method = RequestMethod.POST)
    @ResponseBody
    public GPResult synchron(HttpServletRequest request) {

        return service.esSaveAll();
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public GPResult upload(HttpServletRequest request, @RequestParam("file") MultipartFile file, String typeId) throws Exception {

        return service.uploadImageWithTypeId(file,typeId);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public GPResult delete(HttpServletRequest request,  String typeId) throws Exception {

        return service.delete(typeId);
    }

}