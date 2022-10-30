package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;
import ru.netology.exception.NotRegisteredException;

public class GameManagerTest {

    GameManager manager = new GameManager();

    Player player1 = new Player(1, "Оля", 200);
    Player player2 = new Player(2, "Аня", 100);
    Player player3 = new Player(3, "Леся", 100);

    @BeforeEach
    void setUp() {
        manager.register(player1);
        manager.register(player2);
        manager.register(player3);
    }

    @Test
    public void shouldWinPlayerName1() {

        int actual = 1;
        int expected = manager.round(player1.getName(), player2.getName());

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void shouldWinPlayerName2() {

        int actual = 2;
        int expected = manager.round(player3.getName(), player1.getName());

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void shouldDraw() {

        int actual = 0;
        int expected = manager.round(player2.getName(), player3.getName());

        Assertions.assertEquals(actual, expected);
    }

    @Test
    void shouldNotRegistered1() {
        Assertions.assertThrows(NotRegisteredException.class, () -> manager.round("Оля", "Макс"));
    }

    @Test
    void shouldNotRegistered2() {
        Assertions.assertThrows(NotRegisteredException.class, () -> manager.round("Макс", "Оля"));
    }
}


