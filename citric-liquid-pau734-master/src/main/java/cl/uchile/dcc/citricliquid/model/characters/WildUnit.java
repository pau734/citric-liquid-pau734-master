package cl.uchile.dcc.citricliquid.model.characters;

import java.util.ArrayList;
import java.util.List;

public class WildUnit extends AbstractCharacter{
    private int stars;
    public WildUnit(final String name,final int maxHp,final int atk,
                    final int def,final int evd, int currentHp){
        super(name,maxHp,atk,def,evd,currentHp);
        stars = 0;
    }

    @Override
    public WildUnit copy() {
        return new WildUnit(this.getName(),this.getMaxHp(),this.getAtk(),this.getDef(),this.getEvd(),this.getCurrentHp());
    }

    /** Util para el futuro proximo
    public void wildUnitWinsBattle(Player enemy){
        int plusStars = (enemy.getStars())/2;
        this.increaseStarsBy(plusStars);
    }


    public WildUnit wildUnitLosesBattle(AbstractCharacter enemy){
        this.reduceStarsBy(this.getStars());
        this.setCurrentHp(this.getMaxHp());
        return this.copy();

    }

    public static WildUnit getChicken(){
        WildUnit chicken = new WildUnit("Chicken",3,-1,-1,1,3);
        return chicken;
    }

    public static WildUnit getRoboBall(){
        WildUnit roboBall = new WildUnit("Robo Ball", 3,-1,1,-1,3);
        return roboBall;
    }

    public static WildUnit getSeagull(){
        WildUnit seagull = new WildUnit("Seagull",3,1,-1,-1,3);
        return seagull;
    }


    public static List<WildUnit> createWildList() {
        List<WildUnit> wildUnits = new ArrayList<WildUnit>();
        wildUnits.add(WildUnit.getChicken());
        wildUnits.add(WildUnit.getRoboBall());
        wildUnits.add(WildUnit.getSeagull());
        return wildUnits;
    }
     **/
}
