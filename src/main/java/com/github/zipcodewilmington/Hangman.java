package com.github.zipcodewilmington;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
//Andrew Ascone

public class Hangman {

    boolean gameFlag = true;

    boolean wordFlag = false;

    Integer numGuess = 0;

    String hiddenWord = "";

    char[] gameWord;

    ArrayList<Character> usedGuess = new ArrayList<Character>();

    public Hangman(){

    }

    public static void main(String[] args){
        Hangman game = new Hangman();

        game.runGame();

    }

    public void runGame(){
        while(gameFlag){
            announce_game();
            wordFlag = false;

            initialize_game_state();


            while(!wordFlag){
                print_current_state();
                char nextGuess = get_next_guess();
                usedGuess.add(nextGuess);
                process(nextGuess);

            }

            if(ask_to_play_again()){
                continue;
            }
            break;
        }
        game_over();

    }

    public String announce_game(){
        return "Welcome to Hangman!\nLet's play!";
    }

    public String game_over(){
        return "Game Over";
    }

    public void initialize_game_state(){
        Random rand = new Random();
        String[] threeLetters = {"cat", "dog", "bat", "wit", "tin", "hat"};
        //String[] fourLetters = {};
        int randomPick = rand.nextInt(5) + 1;
        this.hiddenWord = threeLetters[randomPick];
        this.gameWord = hiddenWord.toCharArray();
        //this.gameWord = ['_','_','_'];
        this.numGuess = hiddenWord.length();
    }

    public Character get_next_guess(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Guess a letter!");
        numGuess--;
        return scanner.next().charAt(0);
    }

    public boolean is_word_guessed(){
        return false;
    }

    public boolean ask_to_play_again(){
        System.out.println("Play again?");
        return false;
    }

    public void print_current_state(){
        System.out.println("Current Guesses: " + usedGuess);

        System.out.println("You have " + numGuess + " tries left");
    }

    public void process(char guess){
        for(int i = 0; i < gameWord.length; i++){
            if(guess == gameWord[i]){


            }
        }
    }

    public String player_won(){
        return "You win!";
    }

    public String player_lost(){
        return "You lose :(";
    }
}
