package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.characters.Player;

import java.util.Set;

public interface IPanel {
    int getId();
    Set<IPanel> getNextPanels();
    void addNextPanel(IPanel panel);
    Set<Player> getPlayersOnPanel();
    void addPlayersOnPanel(Player player);
    void removePlayerFromPanel(Player player);
    boolean equals(Object o);
    void activatedBy(Player player);


}
