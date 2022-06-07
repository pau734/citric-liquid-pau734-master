package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.characters.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Set;

public class DropPanel extends AbstractPanel{
    public DropPanel(int id){

        super(id);
    }

    //Reduces the player's star count by the D6 roll multiplied by the player's norma level
    @Override
    public void activatedBy(final @NotNull Player player) {
        player.reduceStarsBy(player.roll() * player.getNormaLevel());
    }
}
