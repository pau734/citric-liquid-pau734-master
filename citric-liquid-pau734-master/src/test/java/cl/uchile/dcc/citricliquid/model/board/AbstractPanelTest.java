package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.characters.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater M.</a>.
 * @version 1.0.6-rc.1
 * @since 1.0
 */
class AbstractPanelTest {
    private final static String PLAYER_NAME = "Suguri";
    private final static int CURRENT_HP= 4;
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
    private final static int id1 = 1;
    private final static int id2 = 2;
    private final static int id3 = 3;
    private final static int id4 = 4;
    private final static int id5 = 5;
    private final static int id6 = 6;
    private final static int id7 = 7;
    private final static int id8 = 8;
    private final static int id10 = 10;
    private IPanel testHomePanel;
    private IPanel testNeutralPanel;
    private IPanel testBonusPanel;
    private IPanel testDropPanel;
    private IPanel testEncounterPanel;
    private IPanel testBossPanel;
    private IPanel testDrawPanel;
    private Player suguri;
    private Player yomacaco;
    private long testSeed;

    @BeforeEach
    public void setUp() {
        testBonusPanel = new BonusPanel(id1);
        testBossPanel = new BossPanel(id2);
        testDropPanel = new DropPanel(id3);
        testEncounterPanel = new EncounterPanel(id4);
        testHomePanel = new HomePanel(id5,suguri);
        testNeutralPanel = new NeutralPanel(id6);
        testDrawPanel = new DrawPanel(id7);
        testSeed = new Random().nextLong();
        suguri = new Player(PLAYER_NAME, MAX_HP, BASE_ATK, BASE_DEF, BASE_EVD,CURRENT_HP);
        yomacaco = new Player(PLAYER2_NAME,MAX_HP2,BASE_ATK2,BASE_DEF2,BASE_EVD2,CURRENT_HP2);
    }

    @Test
    public void constructorTest() {
        final var expectedBonusPanel = new BonusPanel(id1);
        assertEquals(expectedBonusPanel, testBonusPanel);
        final var expectedBossPanel = new BossPanel(id2);
        assertEquals(expectedBossPanel, testBossPanel);
        final var expectedDropPanel = new DropPanel(id3);
        assertEquals(expectedDropPanel, testDropPanel);
        final var expectedEncounterPanel = new EncounterPanel(id4);
        assertEquals(expectedEncounterPanel, testEncounterPanel);
        final var expectedHomePanel = new HomePanel(id5,suguri);
        assertEquals(expectedHomePanel, testHomePanel);
        final var expectedNeutralPanel = new NeutralPanel(id6);
        assertEquals(expectedNeutralPanel, testNeutralPanel);
        final var expectedDrawPanel = new DrawPanel(id7);
        assertEquals(expectedDrawPanel, testDrawPanel);
        assertNotEquals(expectedDrawPanel, testBonusPanel);
        assertNotEquals(expectedBossPanel, testNeutralPanel);
        final var expectedEncounterPanel2 = new EncounterPanel(id10);
        assertNotEquals(expectedEncounterPanel2, testEncounterPanel);
        assertNotEquals(expectedEncounterPanel2, expectedEncounterPanel);
        assertNotEquals(testHomePanel, testDrawPanel);
        assertEquals(expectedHomePanel.hashCode(), testHomePanel.hashCode(),
                "The hash of: " + expectedHomePanel.toString() + " doesn't match the hash of: "
                        + testHomePanel.toString());
        assertEquals(expectedDrawPanel.hashCode(), testDrawPanel.hashCode(),
                "The hash of: " + expectedDrawPanel.toString() + " doesn't match the hash of: "
                        + testDrawPanel.toString());
        assertEquals(expectedDropPanel.hashCode(), testDropPanel.hashCode(),
                "The hash of: " + expectedDropPanel.toString() + " doesn't match the hash of: "
                        + testDropPanel.toString());
        assertEquals(expectedNeutralPanel.hashCode(), testNeutralPanel.hashCode(),
                "The hash of: " + expectedNeutralPanel.toString() + " doesn't match the hash of: "
                        + testNeutralPanel.toString());
        assertEquals(expectedEncounterPanel.hashCode(), testEncounterPanel.hashCode(),
                "The hash of: " + expectedEncounterPanel.toString() + " doesn't match the hash of: "
                        + testEncounterPanel.toString());
        assertEquals(expectedBossPanel.hashCode(), testBossPanel.hashCode(),
                "The hash of: " + expectedBossPanel.toString() + " doesn't match the hash of: "
                        + testBossPanel.toString());
        assertEquals(expectedBonusPanel.hashCode(), testBonusPanel.hashCode(),
                "The hash of: " + expectedBonusPanel.toString() + " doesn't match the hash of: "
                        + testBonusPanel.toString());

    }
    @Test
    public void nextPanelTest() {
        assertTrue(testNeutralPanel.getNextPanels().isEmpty());
        final var expectedPanel1 = new BonusPanel(id8);
        final var expectedPanel2 = new DrawPanel(id3);

        testNeutralPanel.addNextPanel(expectedPanel1);
        assertEquals(1, testNeutralPanel.getNextPanels().size());

        testNeutralPanel.addNextPanel(expectedPanel2);
        assertEquals(2, testNeutralPanel.getNextPanels().size());

        testNeutralPanel.addNextPanel(expectedPanel2);
        assertEquals(2, testNeutralPanel.getNextPanels().size());

        assertEquals(Set.of(expectedPanel1, expectedPanel2),
                testNeutralPanel.getNextPanels());
    }

    @Test
    public void playersOnPanelTest() {
        assertTrue(testDrawPanel.getPlayersOnPanel().isEmpty());
        testDrawPanel.addPlayersOnPanel(suguri);
        assertEquals(1, testDrawPanel.getPlayersOnPanel().size());

        testDrawPanel.addPlayersOnPanel(yomacaco);
        assertEquals(2, testDrawPanel.getPlayersOnPanel().size());

        assertEquals(Set.of(suguri, yomacaco),
                testDrawPanel.getPlayersOnPanel());

        testDrawPanel.removePlayerFromPanel(suguri);
        assertEquals(1, testDrawPanel.getPlayersOnPanel().size());
        assertEquals(Set.of(yomacaco),testDrawPanel.getPlayersOnPanel());

        testDrawPanel.removePlayerFromPanel(yomacaco);
        assertEquals(0, testDrawPanel.getPlayersOnPanel().size());
        assertTrue(testDrawPanel.getPlayersOnPanel().isEmpty());
    }

    @Test
    public void getIdTest(){
        assertTrue(testNeutralPanel.getNextPanels().isEmpty());
        final var expectedPanel1 = new BonusPanel(id8);
        final var expectedPanel2 = new DrawPanel(id3);
        assertEquals(testDropPanel.getId(), expectedPanel2.getId());
        assertEquals(2, testBossPanel.getId());
        assertNotEquals(expectedPanel1.getId(),expectedPanel2.getId());
        assertEquals(8,expectedPanel1.getId());
        assertEquals(3, expectedPanel2.getId());

    }

    @Test
    public void homePanelTest() {
        testHomePanel.activatedBy(suguri);
        assertEquals(suguri.getCurrentHp(),CURRENT_HP+1);

        suguri.setCurrentHp(1);
        testHomePanel.activatedBy(suguri);
        assertEquals(2, suguri.getCurrentHp());
    }

    @Test
    public void neutralPanelTest() {
        final var expectedSuguri = suguri.copy();
        testNeutralPanel.activatedBy(suguri);
        assertEquals(expectedSuguri, suguri);
    }

    @RepeatedTest(100)
    public void dropPanelConsistencyTest() {
        int expectedStars = 30;
        suguri.increaseStarsBy(30);
        assertEquals(expectedStars, suguri.getStars());
        final var testRandom = new Random(testSeed);
        suguri.setSeed(testSeed);
        for (int normaLvl = 1; normaLvl <= 6; normaLvl++) {
            final int roll = testRandom.nextInt(6) + 1;
            testDropPanel.activatedBy(suguri);
            expectedStars = Math.max(expectedStars - roll * normaLvl, 0);
            assertEquals(expectedStars, suguri.getStars(),
                    "Test failed with seed: " + testSeed);
            suguri.normaClear();
        }
    }
    // endregion

    @RepeatedTest(100)
    public void bonusPanelConsistencyTest() {
        int expectedStars = 0;
        assertEquals(expectedStars, suguri.getStars());
        final var testRandom = new Random(testSeed);
        suguri.setSeed(testSeed);
        for (int normaLvl = 1; normaLvl <= 6; normaLvl++) {
            final int roll = testRandom.nextInt(6) + 1;
            testBonusPanel.activatedBy(suguri);
            expectedStars += roll * Math.min(3, normaLvl);
            assertEquals(expectedStars, suguri.getStars(),
                    "Test failed with seed: " + testSeed);
            suguri.normaClear();
        }
    }




}