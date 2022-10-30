package ru.netology.manager;

import ru.netology.domain.Player;
import ru.netology.exception.NotRegisteredException;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private List<Player> playerList = new ArrayList<>();

    public boolean register(Player player) {
        return playerList.add(player);
    }

    public int round(String playerName1, String playerName2) {
        int index1 = findByCollection(playerName1);
        int index2 = findByCollection(playerName2);
        if (index1 == -1) {
            throw new NotRegisteredException("Первый игрок не зарегистрирован в турнире");
        } else if (index2 == -1) {
            throw new NotRegisteredException("Второй игрок не зарегистрирован в турнире");
        }
        if (playerList.get(index1).getStrength() > playerList.get(2).getStrength()) {
            return 1;
        } else if (playerList.get(index1).getStrength() < playerList.get(index2).getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }

    public int findByCollection(String playerName) {
        for (Player player : playerList) {
            if (player.getName().equalsIgnoreCase(playerName)) {
                return playerList.indexOf(player);
            }
        }
        return -1;
    }
}

