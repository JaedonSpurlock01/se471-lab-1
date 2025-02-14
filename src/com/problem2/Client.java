package com.problem2;

public class Client {
    public static void main(String[] args) {
        Game game = new Game();
        String level = game.GetOptionFromUser();
        game.SetupGame(level);
        game.Play();
    }
}