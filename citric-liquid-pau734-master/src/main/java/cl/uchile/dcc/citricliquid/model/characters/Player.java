package cl.uchile.dcc.citricliquid.model.characters;


import cl.uchile.dcc.citricliquid.model.board.HomePanel;

import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * This class represents a player in the game 99.7% Citric Liquid.
 *
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater
 *     Muñoz</a>.
 * @version 1.1.222804
 * @since 1.0
 */
public class Player extends AbstractCharacter{

    private String normaObjective;
    private int normaLevel;
    private int wins;
    private int stars;
    private cl.uchile.dcc.citricliquid.model.board.HomePanel homePanel;






    /**
     * Creates a new character.
     *
     * @param name
     *     the character's name.
     * @param currentHp
     *     the initial (and max) hit points of the character.
     * @param atk
     *     the base damage the character does.
     * @param def
     *     the base defense of the character.
     * @param evd
     *     the base evasion of the character.
     */
    public Player(final String name, int maxHp, final int atk, final int def,
                  final int evd, final int currentHp) {
        super(name,maxHp,atk,def,evd, currentHp);

        normaLevel = 1;
        normaObjective = "Stars";
        wins = 0;
        stars = 0;
        homePanel = null;


    }






    public void setNormaObjective(String objective){
        if (objective.equals("Stars")| objective.equals("Wins")){
            this.normaObjective = objective;
        }
    }

    public void setNormaLevel(int level){
        if (level >= 1 && level <=6){
            this.normaLevel = level;
        };
    }

    public void increaseWins(int wins){
        this.wins += wins;
    }

    public void reduceWins(int wins){
        int currentWins = this.getWins();
        this.wins = Math.max(0,currentWins-wins);
    }

    public HomePanel getHomePanel(){
        return homePanel;
    }
    public void setHomePanel(){
        /**el homePanel del player deberia ser asignado despues de que el panel ha sido creado, lo cual deberia ser en
         * el controller o en view (en el futuro) asi ya sabriamos el id del panel al momento de hacer el set
         */

    }

    public int getWins(){
        return wins;
    }

    public String getNormaObjective(){
        return normaObjective;
    }

    public void normaClear(){
        if (this.getNormaLevel()<6) {
            int level = this.getNormaLevel();
            this.setNormaLevel(level + 1);
        }
    }
    /**
     * Returns the current norma level.
     */
    public int getNormaLevel() {
        return normaLevel;
    }





    @Override
    public Player copy() {
        return new Player(this.getName(),this.getMaxHp(),this.getAtk(),this.getDef(),this.getEvd(),this.getCurrentHp());
    }

    /**
     * Returns a copy of this character.
     */



    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof final cl.uchile.dcc.citricliquid.model.characters.Player player)) {
            return false;
        }
        return (super.equals(player) && this.normaLevel == player.getNormaLevel()
                && this.normaObjective.equals(player.getNormaObjective()) && this.wins == player.getWins()
                && Objects.equals(this.homePanel,player.getHomePanel()) && this.stars == player.getStars());
    }

    /** Al paracer lo de las batallas es para la otra semana, asi que lo dejare comentado por ahora
    public void battle(AbstractCharacter enemy) {
        int attack = this.attack();
        int r = new Random().nextInt(2);
        if (r == 0) {
            enemy.evade(attack);
        } else {
            enemy.defend(attack);
        }
        int enemyAttack = enemy.attack();
        int r2 = new Random().nextInt(2);
        if (r2 == 0) {
            this.evade(enemyAttack);
        } else {
            this.defend(enemyAttack);
        }
    }

    public void playerBattlesWildUnit(){
        int r = new Random().nextInt(3);
        List<WildUnit> wU = WildUnit.createWildList();
        WildUnit randomWildUnit = wU.get(r);
        this.battle(randomWildUnit);
        if (this.KO() && !(randomWildUnit.KO())){
            this.playerLosesVsWild(randomWildUnit);
            randomWildUnit.wildUnitWinsBattle(this);
        }
        if (!(this.KO()) && randomWildUnit.KO()){
            this.playerWinsVsWild(randomWildUnit);
            randomWildUnit.wildUnitLosesBattle(this);
        }
    }

    public void playerWinsVsPlayer(Player playerEnemy){

        this.increaseWins(2);
        int s = (playerEnemy.getStars())/2;
        this.increaseStarsBy(s);

    }

    public void playerLosesVsPlayer(Player playerEnemy){
        int s = (this.getStars())/2;
        this.reduceStarsBy(s);
    }
    public void playerWinsVsWild(WildUnit wildEnemy){
        this.increaseWins(1);
        int s = wildEnemy.getStars();
        this.increaseStarsBy(s);
    }

    public void playerLosesVsWild(WildUnit wildEnemy){
        int s = (this.getStars())/2;
        this.reduceStarsBy(s);
    }

    public void playerWinsVsBoss(BossUnit bossEnemy){
        this.increaseWins(3);
        int s = bossEnemy.getStars();
        this.increaseStarsBy(s);
    }

    public void playerLosesVsBoss(BossUnit bossEnemy){
        int s = (this.getStars())/2;
        this.reduceStarsBy(s);
    }
    **/

    public void normaCheck(){
        if (this.getNormaLevel() == 1 && this.getStars() >= 10){
            this.normaClear();
        }
        if((this.getNormaLevel() == 2 && Objects.equals(this.getNormaObjective(), "Stars") && this.getStars() >= 30) |
                (this.getNormaLevel() == 2 && Objects.equals(this.getNormaObjective(), "Wins") && this.getWins() >= 2)){
            this.normaClear();
        }
        if((this.getNormaLevel() == 3 && Objects.equals(this.getNormaObjective(), "Stars") && this.getStars() >= 70) |
                (this.getNormaLevel() == 3 && Objects.equals(this.getNormaObjective(), "Wins") && this.getWins() >= 5)) {
            this.normaClear();
        }

        if((this.getNormaLevel() == 4 && Objects.equals(this.getNormaObjective(), "Stars") && this.getStars() >= 120) |
                (this.getNormaLevel() == 4 && Objects.equals(this.getNormaObjective(), "Wins") && this.getWins() >= 9)) {
            this.normaClear();
        }

        if((this.getNormaLevel() == 5 && Objects.equals(this.getNormaObjective(), "Stars") && this.getStars() >= 200) |
                (this.getNormaLevel() == 5 && Objects.equals(this.getNormaObjective(), "Wins") && this.getWins() >= 14)) {
            this.normaClear();
        }
    }





}
