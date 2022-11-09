package com.github.zipcodewilmington;


import java.util.Scanner;

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
//Andrew Ascone

public class Hangman {

    public Hangman(){

    }

    public static void main(String[] args){
        Hangman game = new Hangman();
        game.runGame();

//        boolean gameRun = true;
//        Scanner input = new Scanner(System.in);
//        String[] threeLetters = {"cat", "dog", "bat", "wit", "tin", "hat", "far", "not", "dig", "fly"};
//        String[] fourLetters = {};
//
//        System.out.println("Let's play Word Guesser v1");
//
//        while(gameRun){
//
//        }
    }

    public void runGame(){

    }

    public String announce_game(){
        return null;
    }

    public String game_over(){
        return null;
    }

    public void initialize_game_state(){

    }

    public Character get_next_guess(){
        return null;
    }

    public boolean is_word_guessed(){
        return false;
    }

    public boolean ask_to_play_again(){
        return false;
    }

    public void print_current_state(){

    }

    public void process(){

    }

    public String player_won(){
        return "You win!";
    }

    public String player_lost(){
        return "You lose :(";
    }
}
