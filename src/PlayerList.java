import java.util.ArrayList;
import java.util.List;

public class PlayerList {

    private static final List<Player> listOfPlayers = new ArrayList<>();

    public static List<Player> getListOfPlayers() {
        return listOfPlayers;
    }

    public void addPlayerToList(String str) {
        Player player=new Player();
        player.setName(str);
        listOfPlayers.add(player);
    }
}


