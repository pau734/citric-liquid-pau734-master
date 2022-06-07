package cl.uchile.dcc.citricliquid.model.characters;

public interface ICharacter {
    int getStars();
    String getName();
    ICharacter copy();
    int getAtk();
    int getDef();
    int getEvd();
    int getMaxHp();
    int getCurrentHp();
    void reduceStarsBy(final int amount);
    void increaseStarsBy(final int amount);
    boolean equals(Object o);
    int attack();
    void evade(int enemyAttack);
    void defend(int enemyAttack);

}
