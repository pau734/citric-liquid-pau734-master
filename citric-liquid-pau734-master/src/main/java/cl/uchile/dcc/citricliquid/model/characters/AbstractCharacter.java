package cl.uchile.dcc.citricliquid.model.characters;

import java.util.Random;
import java.util.Objects;

public abstract class AbstractCharacter implements ICharacter{
    private final String name;
    private final int maxHp;
    private final int atk;
    private final int def;
    private final int evd;
    private int currentHp;
    private int stars;
    private final Random random;


    public AbstractCharacter(final String name,final int maxHp,final int atk,
                             final int def,final int evd, int currentHp){
        this.name = name;
        this.maxHp = maxHp;
        this.atk = atk;
        this.def = def;
        this.evd = evd;
        this.currentHp = currentHp;
        this.stars = 0;
        random = new Random();

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, maxHp, atk, def, evd, currentHp);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof final cl.uchile.dcc.citricliquid.model.characters.AbstractCharacter abstractCharacter)) {
            return false;
        }
        return (getMaxHp() == abstractCharacter.getMaxHp()
                && this.atk == abstractCharacter.getAtk()
                && this.def == abstractCharacter.getDef()
                && this.evd == abstractCharacter.getEvd()
                && this.currentHp == abstractCharacter.getCurrentHp()
                && this.name.equals(abstractCharacter.getName())
                && this.stars == abstractCharacter.getStars());
    }

    /**
     * Set's the seed for this player's random number generator.
     *
     * <p>The random number generator is used for taking non-deterministic decisions, this method is
     * declared to avoid non-deterministic behaviour while testing the code.
     */
    public void setSeed(final long seed) {
        random.setSeed(seed);
    }

    /**
     * Returns a uniformly distributed random value in [1, 6].
     */
    public int roll() {
        return random.nextInt(6) + 1;
    }
    /**
     * Increases this player's star count by an amount.
     */
    public void increaseStarsBy(final int amount) {

        this.stars += amount;
    }

    /**
     * Reduces this player's star count by a given amount.
     *
     * <p>The star count will must always be greater or equal to 0
     */
    public void reduceStarsBy(final int amount) {
        int currentStars = this.getStars();
        this.stars = Math.max(0, currentStars - amount);
    }

    /**
     * Returns this player's star count.
     */
    public int getStars() {

        return stars;
    }

    /**
     * Returns the character's name.
     */
    public String getName() {

        return name;
    }

    /**
     * Returns the character's max hit points.
     */
    public int getMaxHp() {

        return maxHp;
    }

    /**
     * Returns the current character's attack points.
     */
    public int getAtk() {

        return atk;
    }

    /**
     * Returns the current character's defense points.
     */
    public int getDef() {

        return def;
    }

    /**
     * Returns the current character's evasion points.
     */
    public int getEvd() {

        return evd;
    }

    /**
     * Returns the current hit points of the character.
     */
    public int getCurrentHp() {

        return currentHp;
    }

    /**
     * Sets the current character's hit points.
     *
     * <p>The character's hit points have a constraint to always be between 0 and maxHP, both
     * inclusive.
     */
    public void setCurrentHp(final int newHp) {

        this.currentHp = Math.max(Math.min(newHp, maxHp), 0);
    }



    public int attack(){
        int rollATK = this.roll();
        return this.atk + rollATK;
    }

    public void defend(int attack){
        int curHitP = this.getCurrentHp();
        int dice = this.roll();
        int damageHp = Math.max(1,attack - (dice + this.def));
        this.setCurrentHp(curHitP-damageHp);
    }

    public void evade(int attack){
        int curHitP = this.getCurrentHp();
        int dice = this.roll();
        if (dice + this.evd <= attack){
            this.setCurrentHp(curHitP-attack);
        }
        else{
            this.setCurrentHp(curHitP);
        }
    }




    public boolean KO(){
        return (this.getCurrentHp() == 0);
    }




}



