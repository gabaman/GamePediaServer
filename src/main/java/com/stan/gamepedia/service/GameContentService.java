package com.stan.gamepedia.service;


import com.github.pagehelper.Page;
import com.stan.gamepedia.model.*;

import java.util.List;


public interface GameContentService {


//
    EsResult findAll(String query);


    List<Game> getGameList();

    List<Game> getGameCategory(Long gameid);

    List<ZeldaTemple> getTempleByTypeId(String typeid);

    ZeldaItem getItemByTypeId(String typeid);


    List<ZeldaTemple> getPicOneTemple(boolean isTemple);

    ZeldaTemple saveTemple(ZeldaTemple zeldaTemple);

    void saveItem(String type,ZeldaItem zeldaItem);

    List<ZeldaItem> getZeldaItem(String type);

    public List<ZeldaContent> getContentList(String categoryId);

    public void updateItem(String type, ZeldaItem item);

    public void updateTemple();

    public void updateTemple(ZeldaTemple temple);
}
