import com.github.abel533.entity.Example;
import com.stan.gamepedia.GamePediaApplication;
import com.stan.gamepedia.mapper.GameMapper;
import com.stan.gamepedia.model.*;
import com.stan.gamepedia.service.ConsoleService;
import javafx.application.Application;
import com.stan.gamepedia.model.GameContent;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.stan.gamepedia.service.GameContentService;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GamePediaApplication.class)
public class ESTest {

    @Autowired
    private GameContentService service;

    @Autowired
    private ConsoleService console;

    @Before
    public void before(){

    }

    @Test
    public void test(){

        List list = console.retrieveData("10003");
        System.out.println("==========");

        System.out.println(list.size());
    }


}
