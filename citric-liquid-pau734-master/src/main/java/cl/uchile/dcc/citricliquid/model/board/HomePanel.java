package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.characters.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class HomePanel extends AbstractPanel{
    Player owner;
    //Constructor
    public HomePanel(int id, Player owner){
        super(id);
        this.owner = owner;

    }


    @Override
    //Restores a player's HP in 1
    public void activatedBy(final @NotNull Player player) {

        player.setCurrentHp(player.getCurrentHp() + 1);
        player.normaCheck();
    }



}
