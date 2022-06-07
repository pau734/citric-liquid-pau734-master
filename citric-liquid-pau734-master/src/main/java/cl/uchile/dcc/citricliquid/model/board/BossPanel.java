package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.characters.BossUnit;
import cl.uchile.dcc.citricliquid.model.characters.Player;
import cl.uchile.dcc.citricliquid.model.board.EncounterPanel;
import cl.uchile.dcc.citricliquid.model.characters.WildUnit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BossPanel extends AbstractPanel{

    public BossPanel(int id){

        super(id);
    }

    //List<BossUnit> bosses = BossUnit.createBossList();


    @Override
    public void activatedBy(Player player1){
        /** Estos 3 players se definiran solo, por ahora, despues con el controlador deberiamos ser capaces
         * de ocupar a los 3 otros players que no activaron el panel
         */

        /** Lo comento para la siguiente tarea
        Player player2 = new Player("ola",6,3,2,-1,10);
        Player player3 = new Player("ola",6,3,2,-1,10);
        Player player4 = new Player("ola",6,3,2,-1,10);

        if (player1.getNormaLevel() == 4 | player2.getNormaLevel() == 4 | player3.getNormaLevel() == 4 |
            player4.getNormaLevel() == 4) {
            int l = bosses.size();
            if (l != 0) {
                int random = new Random().nextInt(l);
                BossUnit randomBoss = bosses.get(random);
                player1.battle(randomBoss);
                if (player1.KO() && !(randomBoss.KO())) {
                    player1.playerLosesVsBoss(randomBoss);
                    randomBoss.bossUnitWinsBattle(player1);
                }
                if (!(player1.KO()) && randomBoss.KO()) {
                    player1.playerWinsVsBoss(randomBoss);
                    randomBoss.bossUnitLosesBattle(player1);
                }
                bosses.remove(randomBoss);
            } else {
                player1.playerBattlesWildUnit();
            }
        }
        else {
            player1.playerBattlesWildUnit();
        }
        **/

    }


}
