import com.sun.tools.javac.util.List;
import org.junit.Test;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class SILab2Test {

    public SILab2Test(){};

    ArrayList<String> createList(String...e){
    return new ArrayList<String>(Arrays.asList(e));
    }

    @Test
    public void testEveryPath(){
        RuntimeException ex;

        //1,2,3,19
        ex=assertThrows(RuntimeException.class, () -> SILab2.function(null,createList("sara11","nn89","av7")));
        assertTrue(ex.getMessage().contains("The user argument is not initialized!"));

        //1,2,4,5,6,19
        ex=assertThrows(RuntimeException.class, () -> SILab2.function(new User(null,"sv.1","s@11.com"),createList("sara11","nn89","av7")));
        assertTrue(ex.getMessage().contains("User already exists!"));
        ex=assertThrows(RuntimeException.class, () -> SILab2.function(new User("sara","sv.1","s@11.com"),createList("sara","nn89","av7")));
        assertTrue(ex.getMessage().contains("User already exists!"));

        //1,2,4,5,7,8,9,19
        assertFalse(SILab2.function(new User("sara","sv.1",null),createList("sara11","nn89","av7")));

        //1,2,4,5,7,8,10,11.1,11.2,(12,13,14,15,11.3,11.2), 16,17,19
        //ne moze da se sluci bidejkji ako uspee da vleze vo uslovite vo for uslovot od 16-tat redica ne moze da e ispolnet

        //1,2,4,5,7,8,10,11.1,11.2,(12,13,14,15,11.3,11.2), 16,18,19
       assertTrue(SILab2.function(new User("sara","sv.1","s@11.com"),createList("sara11","nn89","av7")));

        //1,2,4,5,7,8,10,11.1,11.2,(12,14,15,11.3,11.2), 16,17,19
        // ne e moze da se sluci bidejkji ako ne uspee vlezot vo prviot uslov od for vo vtoriot nemoze da se vleze

        //1,2,4,5,7,8,10,11.1,11.2,(12,14,15,11.3,11.2), 16,18,19
        // ne e moze da se sluci bidejkji ako ne uspee vlezot vo prviot uslov od for vo vtoriot nemoze da se vleze

        //1,2,4,5,7,8,10,11.1,11.2,(12,14,11.3,11.2),16 ,17,19
        assertFalse(SILab2.function(new User("sara","sv.1","s11com"),createList("sara11","nn89","av7")));

        //1,2,4,5,7,8,10,11.1,11.2,(12,14,11.3,11.2),16 ,18,19
        //ne moze da se sluci bidejkji ako uslovite vo for ne se tocni kje vleze vo uslovot posle for, ne moze da se zaobikoli
        //a so ovaa pateka toa se pravi

        //1,2,4,5,7,8,10,11.1,11.2,(12,13,14,11.3,11.2),16 ,17,19
        assertFalse(SILab2.function(new User("sara","sv.1","s@11com"),createList("sara11","nn89","av7")));

        //1,2,4,5,7,8,10,11.1,11.2,(12,13,14,11.3,11.2),16 ,18,19
        //ne moze da se sluci bidejkji ako vtoriot uslov vo for ne e tocen kje vleze vo uslovot posle for, ne moze da se zaobikoli,
        //a so ovaa pateka toa se pravi
    }
    @Test
    public void TestEveryBranch(){
        RuntimeException ex;
        boolean f;
        ex=assertThrows(RuntimeException.class, () -> SILab2.function(null,createList("sara11","nn89","av7")));
        assertTrue(ex.getMessage().contains("The user argument is not initialized!"));

        ex=assertThrows(RuntimeException.class, () -> SILab2.function(new User(null,"sv.1","s@11.com"),createList("sara11","nn89","av7")));
        assertTrue(ex.getMessage().contains("User already exists!"));

        assertFalse(SILab2.function(new User("sara","sv.1",null),createList("sara11","nn89","av7")));

        assertTrue(SILab2.function(new User("sara","sv.1","s@11.com"),createList("sara11","nn89","av7")));

        assertFalse(SILab2.function(new User("sara","sv.1","s11com"),createList("sara11","nn89","av7")));

    }
}