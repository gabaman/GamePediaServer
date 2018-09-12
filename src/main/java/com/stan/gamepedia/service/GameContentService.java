package com.stan.gamepedia.service;


import com.github.pagehelper.Page;
import com.stan.gamepedia.model.*;

import java.util.List;


public interface GameContentService {

    GameContent save(GameContent gameContent);

    void delete(GameContent gameContent);

    EsResult findAll(String query);


    List<Game> getGameList();

    List<ZeldaTemple> getTempleByTypeId(String typeid);

    ZeldaItem getItemByTypeId(String typeid);

    List<ZeldaTemple> getAllTemple();

    List<ZeldaTemple> getPicOneTemple();

    ZeldaTemple saveTemple(ZeldaTemple zeldaTemple);

    void saveItem(String type,ZeldaItem zeldaItem);

    List<ZeldaItem> getZeldaItem(String type);

}
