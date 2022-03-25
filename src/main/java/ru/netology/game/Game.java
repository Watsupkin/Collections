package ru.netology.game;

import ru.netology.domain.Player;


import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players = new ArrayList<>();

    public void register(Player player) {
        this.players.add(player);
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equalsIgnoreCase(name)/* == name*/) {
                return player;
            }
        }
        return null;
    }


    public int round(String playerName1, String playerName2) {
        var first = findByName(playerName1);
        var second = findByName(playerName2);
        if (first == null || second == null) {
            throw new NotRegisteredException();
        }
        /*else if (findByName(playerName2) == null){
          throw new NotRegisteredException(playerName2);
        }*/
        var result = first.getStrength() - second.getStrength();
        if (result > 0) {
            return 1;
        } else if (result < 0) {
            return 2;
        }
        return 0;
        /*players.
        return playerName1.compareTo(playerName2);

        if(findByName(playerName1) != null) {}*/
    }

    //public List<Player> findAll() {return items;}

    /*public void removeById(int id) {
     this.players.removeIf(element -> element.getId() == id);}

    public void saveAll(Collection<? extends Player> items) {
    this.items.addAll(items);}
     */


}
