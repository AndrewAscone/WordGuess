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

    char[] gameWordDisplay;

    ArrayList<Character> usedGuess = new ArrayList<Character>();

    public Hangman(){

    }

    public static void main(String[] args){
        Hangman game = new Hangman();

        game.runGame();

    }

    public void runGame(){
        while(gameFlag){
            System.out.println(announce_game());
            wordFlag = false;
            usedGuess.clear();

            initialize_game_state();

            System.out.println("You have " + numGuess + " tries left");

            displayGameWordState();


            while(!wordFlag){

                char nextGuess = get_next_guess();
                usedGuess.add(nextGuess);
                process(nextGuess);
                wordFlag = is_word_guessed();
                print_current_state();
                if(numGuess == 0){
                    break;
                }
            }

            if(is_word_guessed()){
                System.out.println(player_won());
            }
            else if(!is_word_guessed()){
                System.out.println(player_lost());
            }

            if(ask_to_play_again()){
                continue;
            }
            System.out.println(game_over());
            break;
        }
    }

    public String announce_game(){
        return "Welcome to Hangman!\nLet's play!";
    }

    public String game_over(){
        return "Game Over";
    }

    public void initialize_game_state(){
        Random rand = new Random();
        String[] words = {"cat", "dog", "bat", "farm", "miss", "time", "smash", "cross", "mouse"};

        int randomPick = rand.nextInt(words.length) + 1;
        hiddenWord = words[randomPick];
        this.gameWord = hiddenWord.toCharArray();
        gameWordDisplay = new char[gameWord.length];
        for (int i = 0; i < gameWordDisplay.length; i++) {
            gameWordDisplay[i] = '_';
        }
        this.numGuess = hiddenWord.length();
    }

    public Character get_next_guess(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Guess a letter!");
        char playerLetter = scanner.next().charAt(0);
//
//        if(!usedGuess.contains(playerLetter)){
//            return playerLetter;
//        }
//        else{
//            System.out.println("You've already guessed that letter. Guess another letter");
//            scanner.next();
//            get_next_guess();
//
//        }

        return playerLetter;
    }

    public boolean is_word_guessed(){
        for (int i = 0; i < gameWordDisplay.length; i++) {
            if(gameWordDisplay[i] == '_'){
                return false;
            }
        }
        return true;
    }

    public boolean ask_to_play_again(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Play again? (y/n)");
        String playAgainChoice = scanner.nextLine();

        if(playAgainChoice.equals("y")){
            return true;
        }
        else if(playAgainChoice.equals("n")){
            return false;
        }
        else{
            System.out.println("Please make a valid selection");
            ask_to_play_again();
        }

        return false;
    }

    public void print_current_state(){
        System.out.println("Current Guesses: " + usedGuess);

        System.out.println("You have " + numGuess + " tries left");

        displayGameWordState();
    }

    public void displayGameWordState(){
        System.out.println("Word to guess: ");

        for(char c : gameWordDisplay){
            System.out.print(c + " ");
        }
        System.out.println("");
    }


    public void process(char guess){
        if(letterMatched(guess)){
            saveCharacter(guess);
        }
        else{
            System.out.println("That letter is not in the hidden word");
            numGuess--;
        }

    }

    private boolean letterMatched(char guess) {
        for(int i = 0; i < gameWord.length; i++){
            if(guess == gameWord[i]){
                return true;
            }
        }
        return false;
    }

    public void saveCharacter(char guess){
        for (int i = 0; i < gameWord.length; i++) {
            if(guess == gameWord[i]){
                gameWordDisplay[i] = gameWord[i];
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
