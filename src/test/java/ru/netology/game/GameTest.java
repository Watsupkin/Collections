package ru.netology.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game = new Game();
    Player player1 = new Player(1, "Vasya", 10);
    Player player2 = new Player(2, "Kolya", 10);
    Player player3 = new Player(3, "Sasha", 9);
    Player player4 = new Player(4, "Semen", 8);
    Player player5 = new Player(5, "Oleg", 1000);


    @BeforeEach
    public void setUp() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

    }

    @Test
    void shouldThrowException() {
        assertThrows(NotRegisteredException.class,
                () -> {
                    game.round(player4.getName(), player5.getName());
                });
    }

    @Test
    void shouldRoundDraw() {
        int exception = 0;
        int actual = game.round("Vasya", "Kolya");

        assertEquals(exception, actual);
    }

    @Test
    void shouldRoundLose() {
        //int exception = 0;
        int actual = game.round(player4.getName(), player2.getName());

        assertEquals(2, actual);
    }

    @Test
    void shouldRoundWin() {
        int actual = game.round(player3.getName(), player4.getName());

        assertEquals(1, actual);
    }

}