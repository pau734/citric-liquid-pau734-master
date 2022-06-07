package cl.uchile.dcc.citricliquid.model.board;
import cl.uchile.dcc.citricliquid.model.characters.Player;
import cl.uchile.dcc.citricliquid.model.characters.WildUnit;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;

public class EncounterPanel extends AbstractPanel{
    public EncounterPanel(int id){

        super(id);
    }

    @Override
    public void activatedBy(final @NotNull Player player){
        /**
         * lo dejo comentado para la tarea siguiente

        player.playerBattlesWildUnit();
         **/
    }
}



