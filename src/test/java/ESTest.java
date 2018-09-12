import com.github.abel533.entity.Example;
import com.stan.gamepedia.GamePediaApplication;
import com.stan.gamepedia.mapper.GameMapper;
import com.stan.gamepedia.model.*;
import javafx.application.Application;
import com.stan.gamepedia.model.GameContent;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.stan.gamepedia.service.GameContentService;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GamePediaApplication.class)
public class ESTest {

    @Autowired
    private GameContentService service;


    @Before
    public void before(){

    }

    @Test
    public void testUpload(){

//        List<ZeldaTemple> list = service.getAllTemple();
//        for (ZeldaTemple game: list) {
//            System.out.println(game.getTitle());
//            System.out.println(game.getContent());
//
//        }
        List<ZeldaTemple> list = service.getPicOneTemple();
        System.out.println("getdata");

        System.out.println(list.size());


        for (ZeldaTemple temple: list) {
            System.out.println(temple.getTitle());
            System.out.println(temple.getContent());
            service.saveTemple(temple);
        }


//


    }

    @Test
    public void testSaveAll(){

//        testSaveItem("zeldaweapon");
//        testSaveItem("zeldashield");
//        testSaveItem("zeldaarmor");
//        testSaveItem("zeldamaterial");
//        testSaveItem("zeldafood");

    }

    public void testSaveItem(String type){
//        List<ZeldaItem> list = service.getZeldaItem(type);
//
//        for (ZeldaItem it:list) {
//            service.saveItem(type,it);
//        }
    }
    @Test
    public void getItem(){
//        ZeldaFood food =  (ZeldaFood) service.getItemByTypeId("600096");
//        System.out.println(food.getName());
    }



    @Test
    public void testSave(){



//        GameContent gameContent = new GameContent("1002","逆水寒神像打本攻略","stan","23-FEB-2017","23-FEB-2017","无脑按1，就完事了","www.baidu.com","1","1");
//        GameContent content = service.save(gameContent);


    }



    @Test
    public void  findAll(){
//        EsResult result = service.findAll("风顶");
//        System.out.println(result.totalHits+"========="+result.totalTime);
//
//        for (int i = 0; i < result.list.size(); i++) {
//
//            Map<String,Object> map = result.list.get(i);
//
//            System.out.println(map.get("name")+"=========="+map.get("description"));
//
//        }
    }
    /*
    * @Test
    public void testFindOne() {

        Book book = new Book("1001", "Elasticsearch Basics", "Rambabu Posa", "23-FEB-2017");
        bookService.save(book);

        Book testBook = bookService.findOne(book.getId());

        assertNotNull(testBook.getId());
        assertEquals(testBook.getTitle(), book.getTitle());
        assertEquals(testBook.getAuthor(), book.getAuthor());
        assertEquals(testBook.getReleaseDate(), book.getReleaseDate());

    }


    * */

}
