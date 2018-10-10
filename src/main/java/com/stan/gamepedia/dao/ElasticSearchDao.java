package com.stan.gamepedia.dao;

import com.stan.gamepedia.model.EsResult;
import com.stan.gamepedia.model.GameContent;
import com.stan.gamepedia.model.ZeldaTemple;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public interface ElasticSearchDao {


    GameContent save(GameContent gameContent);

    void delete(GameContent gameContent);

    EsResult searchAll(String name, Integer start, Integer size);

    public ZeldaTemple saveTemple(ZeldaTemple zeldaTemple,boolean isTemple);

    Boolean saveType(String type,Object object);

}
