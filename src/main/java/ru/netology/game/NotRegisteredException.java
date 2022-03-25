package ru.netology.game;

public class NotRegisteredException extends RuntimeException {

    public NotRegisteredException() {
        super("This player(s) non-registered");
    }
}
