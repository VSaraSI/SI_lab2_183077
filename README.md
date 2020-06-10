# Втора лабораториска вежба по Софтверско инженерство #
## Сара Васкоска, бр. на индекс 183077 ##
### Група на код: ###
Ја добив групата на код 2
### Control Flow Graph ###
![image](https://user-images.githubusercontent.com/63445848/84288050-f54de180-ab40-11ea-987e-c6d57c5a5bae.png)
### Цикломатска комплексност ###
Цикломатската комплексност на овој код е 8, преку броење на бројот на региони од Control Flow графот но може да се пресмета и со помош на предикатни јазли+1 или со помош на ребра и јазли.
### Тест случаи според критериумот Every statement ###
@Test
    
    public void TestEveryStatement(){
       RuntimeException ex;
       ex=assertThrows(RuntimeException.class, () -> SILab2.function(null,createList("sara11","nn89","av7")));
       assertTrue(ex.getMessage().contains("The user argument is not initialized!"));
       ex=assertThrows(RuntimeException.class, () ->SILab2.function(newUser(null,"sv.1","s@11.com"),createList("sara11","nn89","av7")));
       аssertTrue(ex.getMessage().contains("User already exists!"));
       assertFalse(SILab2.function(new User("sara","sv.1",null),createList("sara11","nn89","av7")));
       assertTrue(SILab2.function(new User("sara","sv.1","s@11.com"),createList("sara11","nn89","av7")));
       assertFalse(SILab2.function(new User("sara","sv.1","s11com"),createList("sara11","nn89","av7")));
    }
### Тест случаи според критериумот Every path ###
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
### Објаснување на напишаните unit tests ###
EveryPath) <br/>
Овие тестови се пишувани се со цел да се опфатат сите можни патеки во графот со користење на помал број тестови. Но сепак постои одреден број на патеки кои не може да се поминат поради тоа што според дадената функција  и условите во неа, според логика програмата никогаш не може да помине низ нив. Бидејќи има поголем број на патеки има повеќе тестови кои се според EveryPath.<br/>
EveryStatement) <br/>
Според овој критериум имаме помал број на тестови но сепак се опфатени сите можни сценарија.Во овој случај се внимава да се изминат сите јазли со користење на помал број тестови. <br/>
*) Сите тестови се пишувани според условите кои се наведени во функцијата и според различните излези кои може да се добијат од истата се со цел да провериме дали програмата се однесува точно онака како сакаме ние.
Како главни тестови според двата критериуми би издвоила 5 и секој од нив се фокусира на различен можен влез. Првиот тестира дали имаме посакуван излез ако не се внесе овјект од класата User односно кориснички податоци,следниот тестира дали е внесено корисничко име и дали постои веќе корисник со тоа име. Третиот го зафаќа делот со тоа дали е внесен e-mail, следниот е ситуација каде се внесени сите податоци точно. И последниот проверува дали добиваме посакуван резултат доколку корисникот внесе неправилен email. 
