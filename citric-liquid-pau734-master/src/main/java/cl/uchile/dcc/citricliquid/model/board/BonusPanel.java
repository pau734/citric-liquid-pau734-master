package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.characters.Player;
import org.jetbrains.annotations.NotNull;

public class BonusPanel extends AbstractPanel{

    /**Constructor*/
    public BonusPanel(int id){
        super(id);
    }


    /**Reduces the player's star count by the D6 roll multiplied by the maximum between the player's
      norma level and three */
    @Override
    public void activatedBy(final @NotNull Player player) {
        player.increaseStarsBy(player.roll() * Math.min(player.getNormaLevel(), 3));
    }
}
