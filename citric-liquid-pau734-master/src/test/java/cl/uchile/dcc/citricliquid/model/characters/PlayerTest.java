package cl.uchile.dcc.citricliquid.model.characters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class PlayerTest {
    private final static String PLAYER_NAME = "Suguri";
    private final static int CURRENT_HP = 4;
    private final static int BASE_ATK = 1;
    private final static int BASE_DEF = -1;
    private final static int BASE_EVD = 2;
    private final static int MAX_HP = 10;
    private final static String PLAYER2_NAME = "YOMACACO";
    private final static int CURRENT_HP2= 6;
    private final static int BASE_ATK2 = -1;
    private final static int BASE_DEF2 = 3;
    private final static int BASE_EVD2 = -2;
    private final static int MAX_HP2 = 15;
    private final static int wins1 = 12;
    private final static int wins2 = 2;
    private final static int wins3 = 6;
    private final static int normaLevel2 = 2;
    private final static int normaLevel4 = 4;

    private Player suguri;
    private Player yoMacaco;

    @BeforeEach
    public void setUp() {

        suguri = new Player(PLAYER_NAME, MAX_HP, BASE_ATK,BASE_DEF,BASE_EVD,CURRENT_HP);
        yoMacaco = new Player(PLAYER2_NAME, MAX_HP2, BASE_ATK2, BASE_DEF2, BASE_EVD2, CURRENT_HP2);
    }

    /** In this class the constructor will not be tested since it was already tested in the AbstractCharacterTest,
     * methods related to battle (apart from attack,evade and defense) won't be tested for now, since it was said
     * that it wasn't necessary for this homework submission
     **/


    @Test
    public void equalsTest(){
        Assertions.assertFalse(suguri.equals(yoMacaco));
        Player mister = suguri.copy();
        Assertions.assertTrue(suguri.equals(mister));
    }
    /**Test for methods which get or modify the wins value**/
    @Test
    public void WinsTest(){
        Assertions.assertEquals(suguri.getWins(),0);
        Assertions.assertEquals(yoMacaco.getWins(),0);
        suguri.increaseWins(wins3);
        Assertions.assertEquals(suguri.getWins(),wins3);
        yoMacaco.increaseWins(wins1);
        Assertions.assertEquals(yoMacaco.getWins(),wins1);
        suguri.reduceWins(wins1);
        Assertions.assertEquals(suguri.getWins(),0);
        yoMacaco.reduceWins(wins2);
        Assertions.assertEquals(yoMacaco.getWins(),10);
    }

    @Test
    public void normaObjectiveTest(){
        Assertions.assertEquals(suguri.getNormaObjective(),"Stars");
        suguri.setNormaObjective("Wins");
        Assertions.assertEquals(suguri.getNormaObjective(),"Wins");
    }

    @Test
    public void playerHomePanelTest(){
        Assertions.assertNull(suguri.getHomePanel());
        Assertions.assertNull(yoMacaco.getHomePanel());
    }

    @Test
    public void normaLevelTest(){
        Assertions.assertEquals(suguri.getNormaLevel(),1);
        Assertions.assertEquals(yoMacaco.getNormaLevel(),1);
        suguri.setNormaLevel(normaLevel2);
        Assertions.assertEquals(suguri.getNormaLevel(),2);
        yoMacaco.setNormaLevel(normaLevel4);
        Assertions.assertEquals(yoMacaco.getNormaLevel(),normaLevel4);
        suguri.normaClear();
        Assertions.assertEquals(suguri.getNormaLevel(),3);
        yoMacaco.normaClear();
        Assertions.assertEquals(yoMacaco.getNormaLevel(),5);
        suguri.setNormaObjective("Wins");
        suguri.increaseWins(5);
        suguri.normaCheck();
        Assertions.assertEquals(suguri.getNormaLevel(),4);
        yoMacaco.increaseStarsBy(200);
        yoMacaco.normaCheck();
        Assertions.assertEquals(yoMacaco.getNormaLevel(),6);
        suguri.normaCheck();
        Assertions.assertEquals(suguri.getNormaLevel(),4);
    }

    @RepeatedTest(100)
    public void normaLevelConsistencyTest(){
        final int testSeed1 = new Random().nextInt();
        suguri.setSeed(testSeed1);
        int sugLevel = testSeed1;
        suguri.setNormaLevel(sugLevel);
        if (sugLevel <= 6 && sugLevel >= 1) {
            Assertions.assertEquals(suguri.getNormaLevel(), sugLevel);
        }
        else{
            Assertions.assertEquals(suguri.getNormaLevel(),1);
        }
        int sugCurrentLevel = suguri.getNormaLevel();
        suguri.normaClear();
        Assertions.assertTrue(suguri.getNormaLevel() == sugCurrentLevel+1 | suguri.getNormaLevel() == 6);
        final int testSeed2 = new Random().nextInt();
        yoMacaco.setSeed(testSeed2);
        int macLevel = testSeed2;
        yoMacaco.setNormaLevel(macLevel);
        if (macLevel <= 6 && macLevel >= 1) {
            Assertions.assertEquals(yoMacaco.getNormaLevel(), macLevel);
        }
        else{
            Assertions.assertEquals(yoMacaco.getNormaLevel(),1);
        }
        int macCurrentLevel = yoMacaco.getNormaLevel();
        yoMacaco.normaClear();
        Assertions.assertTrue(yoMacaco.getNormaLevel() == macCurrentLevel+1 | yoMacaco.getNormaLevel() == 6);


    }
}

