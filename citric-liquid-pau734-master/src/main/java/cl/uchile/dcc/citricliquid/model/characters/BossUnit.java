package cl.uchile.dcc.citricliquid.model.characters;

import java.util.ArrayList;
import java.util.List;

public class BossUnit extends AbstractCharacter{
    private int stars;
    public BossUnit(final String name,final int maxHp,final int atk,
                    final int def,final int evd, int currentHp){
        super(name,maxHp,atk,def,evd,currentHp);
        this.stars = 0;
    }


    /** Cosas que dejo comentadas para usarlas en la proxima entrega cuando sea necesario implementar las batallas

    public void bossUnitWinsBattle(Player player){
        int plusStars = (player.getStars())/2;
        this.increaseStarsBy(plusStars);

    }

    public void bossUnitLosesBattle(Player player){
        this.reduceStarsBy(this.getStars());
        this.setCurrentHp(this.getMaxHp());
    }
    public static BossUnit getStoreManager(){
        BossUnit storeManager = new BossUnit("Store Manager", 8, 3, 2, -1, 8);
        return storeManager;
    }

    public static BossUnit getShifuRobot(){
        BossUnit shifuRobot = new BossUnit("Shifu Robot", 7, 2, 3, -2, 7);
        return shifuRobot;
    }

    public static BossUnit getFlyingCastle(){
        BossUnit flyingCastle = new BossUnit("Flying Castle", 10, 2, 1, -3, 10);
        return flyingCastle;
    }


    public static List<BossUnit> createBossList() {
        List<BossUnit> boss = new ArrayList<BossUnit>();
        boss.add(BossUnit.getStoreManager());
        boss.add(BossUnit.getShifuRobot());
        boss.add(BossUnit.getFlyingCastle());
        return boss;
    }
    **/

    @Override
    public BossUnit copy() {
        return new BossUnit(this.getName(),this.getMaxHp(),this.getAtk(),this.getDef(),this.getEvd(),this.getCurrentHp());
    }
}

