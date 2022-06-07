package cl.uchile.dcc.citricliquid.model.characters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * Test suite for the players of the game.
 *
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater M.</a>.
 * @version 1.0.6-rc.1
 * @since 1.0
 */
public class AbstractCharacterTest {
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
  private final static String WU_NAME = "Aquiles Baeza";
  private final static int CURRENT_HPWU= 8;
  private final static int BASE_ATKWU = 3;
  private final static int BASE_DEFWU = 4;
  private final static int BASE_EVDWU = 1;
  private final static int MAX_HPWU = 18;
  private final static String BU_NAME = "Fin de Semestre";
  private final static int CURRENT_HPBU= 30;
  private final static int BASE_ATKBU = 20;
  private final static int BASE_DEFBU = 5;
  private final static int BASE_EVDBU = -10;
  private final static int MAX_HPBU = 30;
  private final static int n1 = 1;
  private final static int n2 = 2;
  private final static int n3 = 3;

  private Player suguri;
  private Player yoMacaco;
  private WildUnit aquilesBaeza;
  private BossUnit finDeSemestre;


  @BeforeEach
  public void setUp() {

    suguri = new Player(PLAYER_NAME,MAX_HP, 1, -1, 2, CURRENT_HP);
    yoMacaco = new Player(PLAYER2_NAME, MAX_HP2, BASE_ATK2, BASE_DEF2, BASE_EVD2, CURRENT_HP2);
    aquilesBaeza = new WildUnit(WU_NAME,MAX_HPWU,BASE_ATKWU,BASE_DEFWU,BASE_EVDWU,CURRENT_HPWU);
    finDeSemestre = new BossUnit(BU_NAME,MAX_HPBU,BASE_ATKBU,BASE_DEFBU,BASE_EVDBU,CURRENT_HPBU);
  }

  @Test
  public void constructorTest() {
    final var expectedSuguri = new Player(PLAYER_NAME, MAX_HP, BASE_ATK, BASE_DEF, BASE_EVD, CURRENT_HP);
    Assertions.assertEquals(expectedSuguri, suguri);
    final var expectedYoMacaco = new Player(PLAYER2_NAME, MAX_HP2, BASE_ATK2, BASE_DEF2, BASE_EVD2, CURRENT_HP2);
    Assertions.assertEquals(expectedYoMacaco, yoMacaco);
    final var expectedAquilesBaeza = new WildUnit(WU_NAME,MAX_HPWU,BASE_ATKWU,BASE_DEFWU,BASE_EVDWU,CURRENT_HPWU);
    Assertions.assertEquals(expectedAquilesBaeza, aquilesBaeza);
    final var expectedFinDeSemestre = new BossUnit(BU_NAME,MAX_HPBU,BASE_ATKBU,BASE_DEFBU,BASE_EVDBU,CURRENT_HPBU);
    Assertions.assertEquals(expectedFinDeSemestre, finDeSemestre);

  }

  @Test
  public void equalsTest(){
    Assertions.assertFalse(finDeSemestre.equals(aquilesBaeza));
    Assertions.assertFalse(yoMacaco.equals(suguri));
    WildUnit cosmeFulanito = aquilesBaeza.copy();
    Assertions.assertTrue(aquilesBaeza.equals(cosmeFulanito));

  }
  @Test
  public void copyTest(){
    Player cat = suguri.copy();
    Assertions.assertEquals(cat,suguri);
    WildUnit dog = aquilesBaeza.copy();
    Assertions.assertEquals(dog,aquilesBaeza);
    BossUnit boss = finDeSemestre.copy();
    Assertions.assertEquals(boss,finDeSemestre);
  }

  /**Test for all the methods related to stars**/
  @Test
  public void starsTest(){
    Assertions.assertEquals(0, suguri.getStars());
    Assertions.assertEquals(0, aquilesBaeza.getStars());
    Assertions.assertEquals(0, finDeSemestre.getStars());
    suguri.increaseStarsBy(n1);
    Assertions.assertEquals(n1, suguri.getStars());
    suguri.reduceStarsBy(n3);
    Assertions.assertEquals(0, aquilesBaeza.getStars());
    aquilesBaeza.increaseStarsBy(n2);

  }

  @RepeatedTest(100)
  public void StarsConsistencyTest(){
    int randomV = new Random().nextInt();
    int finOrigStars = finDeSemestre.getStars();
    finDeSemestre.increaseStarsBy(randomV);
    Assertions.assertEquals(finDeSemestre.getStars(),finOrigStars + randomV);
    if (finOrigStars >= randomV){
      finDeSemestre.reduceStarsBy(2*randomV);
      Assertions.assertEquals(finDeSemestre.getStars(), finOrigStars - randomV);
    }
    else {
      finDeSemestre.reduceStarsBy(2*randomV);
      Assertions.assertEquals(finDeSemestre.getStars(), 0);
    }
  }

  @Test
  public void getNameTest(){
    Assertions.assertEquals(PLAYER_NAME, suguri.getName());
    Assertions.assertEquals(PLAYER2_NAME, yoMacaco.getName());
    Assertions.assertEquals(WU_NAME, aquilesBaeza.getName());
    Assertions.assertEquals(BU_NAME, finDeSemestre.getName());
  }

  /** Test for the roll method, to check that it generates int values between 1(inclusive) and 6 (inclusive)
   * Also useful to test the setSeed() method
   * **/
  @RepeatedTest(100)
  public void rollConsistencyTest(){
    final long testSeed1 = new Random().nextLong();
    suguri.setSeed(testSeed1);
    final int suguriRoll = suguri.roll();
    Assertions.assertTrue(suguriRoll >= 1 && suguriRoll <=6, "Test failed with seed: " + testSeed1);
    final long testSeed2 = new Random().nextLong();
    yoMacaco.setSeed(testSeed2);
    final int yoMacacoRoll = yoMacaco.roll();
    Assertions.assertTrue(yoMacacoRoll >= 1 && yoMacacoRoll <=6, "Test failed with seed: " + testSeed2);
    final long testSeed3 = new Random().nextLong();
    aquilesBaeza.setSeed(testSeed3);
    final int aquilesBaezaRoll = aquilesBaeza.roll();
    Assertions.assertTrue(aquilesBaezaRoll >= 1 && aquilesBaezaRoll <=6,
            "Test failed with seed: " + testSeed3);
    final long testSeed4 = new Random().nextLong();
    finDeSemestre.setSeed(testSeed4);
    final int finDeSemestreRoll = finDeSemestre.roll();
    Assertions.assertTrue(finDeSemestreRoll >= 1 && finDeSemestreRoll <=6,
            "Test failed with seed: " + testSeed4);

  }

  /**Test for the methods related to the hit points**/
  @Test
  public void HPTest(){
    Assertions.assertEquals(MAX_HP, suguri.getMaxHp());
    Assertions.assertEquals(MAX_HP2, yoMacaco.getMaxHp());
    Assertions.assertEquals(MAX_HPWU, aquilesBaeza.getMaxHp());
    Assertions.assertEquals(MAX_HPBU, finDeSemestre.getMaxHp());
    Assertions.assertEquals(CURRENT_HP, suguri.getCurrentHp());
    Assertions.assertEquals(CURRENT_HP2, yoMacaco.getCurrentHp());
    Assertions.assertEquals(CURRENT_HPWU, aquilesBaeza.getCurrentHp());
    Assertions.assertEquals(CURRENT_HPBU, finDeSemestre.getCurrentHp());
    suguri.setCurrentHp(100);
    Assertions.assertEquals(suguri.getCurrentHp(),suguri.getMaxHp());
    yoMacaco.setCurrentHp(12);
    Assertions.assertEquals(yoMacaco.getCurrentHp(),12);
    aquilesBaeza.setCurrentHp(-15);
    Assertions.assertEquals(aquilesBaeza.getCurrentHp(),0);
    finDeSemestre.setCurrentHp(finDeSemestre.getMaxHp());
    Assertions.assertEquals(finDeSemestre.getCurrentHp(),finDeSemestre.getMaxHp());
  }



  @Test
  public void getAtkTest(){
    Assertions.assertEquals(BASE_ATK, suguri.getAtk());
    Assertions.assertEquals(BASE_ATK2, yoMacaco.getAtk());
    Assertions.assertEquals(BASE_ATKWU, aquilesBaeza.getAtk());
    Assertions.assertEquals(BASE_ATKBU, finDeSemestre.getAtk());
  }

  @RepeatedTest(100)
  public void attackConsistencyTest(){
    final long testSeed1 = new Random().nextLong();
    suguri.setSeed(testSeed1);
    final int suguriAttack = suguri.attack();
    Assertions.assertTrue(suguriAttack >= suguri.getAtk()+ 1 && suguriAttack <= suguri.getAtk()+6,
            "Test failed with seed: " + testSeed1);
    final long testSeed2 = new Random().nextLong();
    yoMacaco.setSeed(testSeed2);
    final int yoMacacoAttack = yoMacaco.attack();
    Assertions.assertTrue(yoMacacoAttack >= 1 + yoMacaco.getAtk() && yoMacacoAttack <=6 + yoMacaco.getAtk(),
            "Test failed with seed: " + testSeed2);
    final long testSeed3 = new Random().nextLong();
    aquilesBaeza.setSeed(testSeed3);
    final int aquilesBaezaAttack = aquilesBaeza.attack();
    Assertions.assertTrue(aquilesBaezaAttack >= aquilesBaeza.getAtk() + 1
                    && aquilesBaezaAttack <=aquilesBaeza.getAtk()+6, "Test failed with seed: " + testSeed3);
    final long testSeed4 = new Random().nextLong();
    finDeSemestre.setSeed(testSeed4);
    final int finDeSemestreAttack = finDeSemestre.attack();
    Assertions.assertTrue(finDeSemestreAttack >= finDeSemestre.getAtk() + 1
                    && finDeSemestreAttack <= finDeSemestre.getAtk() + 6, "Test failed with seed: " + testSeed4);

  }

  @Test
  public void DefTest(){
    Assertions.assertEquals(BASE_DEF, suguri.getDef());
    Assertions.assertEquals(BASE_DEF2, yoMacaco.getDef());
    Assertions.assertEquals(BASE_DEFWU, aquilesBaeza.getDef());
    Assertions.assertEquals(BASE_DEFBU, finDeSemestre.getDef());
  }

  @RepeatedTest(100)
  public void DefenseConsistencyTest() {
    final int attack1 = new Random().nextInt();
    int sugCurHP = suguri.getCurrentHp();
    final long testSeed1 = new Random().nextLong();
    suguri.setSeed(testSeed1);
    suguri.defend(attack1);
    int damage1 = attack1 - 1 - suguri.getDef();      /**Maximo damage posible **/
    int damage6 = attack1 - 6 - suguri.getDef();      /** Minimo damage posible**/
    if (1 > damage1) {
      Assertions.assertEquals(suguri.getCurrentHp(), sugCurHP - 1);
    } else {
      if (damage1 >= sugCurHP) {
        Assertions.assertEquals(suguri.getCurrentHp(), 0);
      } else {
        Assertions.assertTrue(suguri.getCurrentHp() >= sugCurHP - damage1
                && suguri.getCurrentHp() <= sugCurHP - damage6);
      }

    }
    final int attack2 = new Random().nextInt();
    int macCurHP = yoMacaco.getCurrentHp();
    final long testSeed2 = new Random().nextLong();
    yoMacaco.setSeed(testSeed2);
    yoMacaco.defend(attack2);
    int damage1Mac = attack2 - 1 - yoMacaco.getDef();      /**Maximo damage posible **/
    int damage6Mac = attack2 - 6 - yoMacaco.getDef();      /** Minimo damage posible**/
    if (1 > damage1Mac) {
      Assertions.assertTrue(yoMacaco.getCurrentHp() == macCurHP - 1);
    } else {
      if (damage1Mac >= macCurHP) {
        Assertions.assertEquals(yoMacaco.getCurrentHp(), 0);
      } else {
        Assertions.assertTrue(yoMacaco.getCurrentHp() >= macCurHP - damage1Mac
                && yoMacaco.getCurrentHp() <= macCurHP - damage6Mac);
      }

    }
  }



  @Test public void getEvdTest(){
    Assertions.assertEquals(BASE_EVD, suguri.getEvd());
    Assertions.assertEquals(BASE_EVD2, yoMacaco.getEvd());
    Assertions.assertEquals(BASE_EVDWU, aquilesBaeza.getEvd());
    Assertions.assertEquals(BASE_EVDBU, finDeSemestre.getEvd());
  }

  @RepeatedTest(200)
  public void EvdConsistencyTest(){
    final int attack1 = new Random().nextInt();
    int sugCurHP = suguri.getCurrentHp();
    final long testSeed1 = new Random().nextLong();
    suguri.setSeed(testSeed1);
    suguri.evade(attack1);
    int evade1 = suguri.getEvd() + 1;   /**Valor del evade minimo **/
    int evade6 = suguri.getEvd() + 6;   /**Valor del evade maximo**/
    if (attack1 < evade1) {
      Assertions.assertEquals(suguri.getCurrentHp(), sugCurHP);
    }
    if (attack1 > evade6) {
      if (attack1 >= sugCurHP) {
        Assertions.assertEquals(suguri.getCurrentHp(), 0);
      } else {
        Assertions.assertEquals(suguri.getCurrentHp(), sugCurHP - attack1);
      }
    }

    final int attack3 = new Random().nextInt();
    int aquiCurHP = aquilesBaeza.getCurrentHp();
    final long testSeed3 = new Random().nextLong();
    aquilesBaeza.setSeed(testSeed3);
    aquilesBaeza.evade(attack3);
    int evade1aqui = aquilesBaeza.getEvd() + 1;   /**Valor del evade minimo **/
    int evade6aqui = aquilesBaeza.getEvd() + 6;   /**Valor del evade maximo**/
    if (attack3 < evade1aqui) {
      Assertions.assertEquals(aquilesBaeza.getCurrentHp(), aquiCurHP);
    }
    if (attack3 > evade6aqui) {
      if (attack3 >= aquiCurHP) {
        Assertions.assertEquals(aquilesBaeza.getCurrentHp(), 0);
      } else {
        Assertions.assertEquals(aquilesBaeza.getCurrentHp(), aquiCurHP - attack3);
      }
    }

    final int attack4 = new Random().nextInt();
    int finCurHP = finDeSemestre.getCurrentHp();
    final long testSeed4 = new Random().nextLong();
    finDeSemestre.setSeed(testSeed4);
    finDeSemestre.evade(attack4);
    int evade1fin = finDeSemestre.getEvd() + 1;   /**Valor del evade minimo **/
    int evade6fin = finDeSemestre.getEvd() + 6;   /**Valor del evade maximo**/
    if (attack4 < evade1fin) {
      Assertions.assertEquals(finDeSemestre.getCurrentHp(), finCurHP);
    }
    if (attack4 > evade6fin) {
      if (attack4 >= finCurHP) {
        Assertions.assertEquals(finDeSemestre.getCurrentHp(), 0);
      } else {
        Assertions.assertEquals(finDeSemestre.getCurrentHp(), finCurHP - attack4);
      }
    }
  }

  @Test
  public void KoTest(){
    Assertions.assertFalse(suguri.KO());
    Assertions.assertFalse(yoMacaco.KO());
    Assertions.assertFalse(aquilesBaeza.KO());
    Assertions.assertFalse(finDeSemestre.KO());
    finDeSemestre.setCurrentHp(0);
    Assertions.assertTrue(finDeSemestre.KO());
    yoMacaco.setCurrentHp(-500);
    Assertions.assertTrue(yoMacaco.KO());

  }

}