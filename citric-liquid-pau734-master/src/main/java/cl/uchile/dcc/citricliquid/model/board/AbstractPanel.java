package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.characters.Player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/**
 * Class that represents a panel in the board of the game.
 *
 * @author <a href="mailto:ignacio.slater@ug.uchile.cl">Ignacio Slater Muñoz</a>.
 * @version 1.1.222804
 * @since 1.0
 */
public abstract class AbstractPanel implements IPanel {

  private final int id;
  private final Set<IPanel> nextPanels;
  private Set<Player> playersOnPanel;

  public AbstractPanel(int id) {

    this.id = id;
    this.nextPanels = new HashSet<>();
    this.playersOnPanel = new HashSet<>();  /* Al comienzo del juego, los paneles deberian estar vacios*/
  }


  public int getId(){

    return id;
  }

  /**
   * Returns a copy of this panel's next ones.
   */

  public Set<IPanel> getNextPanels() {

    return Set.copyOf(nextPanels);
  }

  /**
   * Adds a new adjacent panel to this one.
   *
   * @param panel the panel to be added.
   */
  public void addNextPanel(final IPanel panel) {

    nextPanels.add(panel);
  }

  public Set<Player> getPlayersOnPanel() {

    return Set.copyOf(playersOnPanel);
  }

  public void addPlayersOnPanel(Player player) {

    playersOnPanel.add(player);
  }
  /**
   * Executes the appropriate action to the player according to this panel's type.
   */

  public void removePlayerFromPanel(Player player){
    playersOnPanel.remove(player);
  }

  @Override
  public int hashCode() {
    return Objects.hash(IPanel.class, id, nextPanels, playersOnPanel);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof IPanel) {
      var other = (IPanel) obj;
      return (this.id == other.getId() && this.nextPanels.equals(other.getNextPanels())
              && this.playersOnPanel.equals(other.getPlayersOnPanel()));
    }
    return false;
  }

  public abstract void activatedBy(Player player);
}
