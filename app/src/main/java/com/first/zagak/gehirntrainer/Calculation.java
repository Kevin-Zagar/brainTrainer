package com.first.zagak.gehirntrainer;

import android.util.Log;
import android.widget.Button;

import java.util.Random;


public class Calculation {

    View view = new View();

    Button button1;
    Button button2;
    Button button3;
    Button button4;

    Random r = new Random();

    /* Mathe Aufgaben */
    public int randomNumber(){
        int max = 0;
        int min = 50;
        return (int) (Math.random() * ((max-min) + 1)) + min;

    }

    /* Random + - */
    public char addOrSub(){
        String plusMinus = "+-";
        final char c = plusMinus.charAt(r.nextInt(plusMinus.length()));
        return c;
    }



    // We check what came out as an operator and than do the math
    public int answerRandomMathQuestion(){
        int first = Integer.parseInt((String) view.firstRandomNumber.getText());
        int second = Integer.parseInt((String) view.secondRandomNumber.getText());
        String operator = (String) view.randomAddOrSub.getText();

        if (operator.equals("-")){
            int answer = first - second;
            Log.i("info", "Lösung: " + String.valueOf(answer));
            return answer;
        }else {
            int answer = first + second;
            Log.i("info", "Lösung: " + String.valueOf(answer));
            return answer;

        }

    }

    /*
    The answer  of answerRandomQuestion is getting a rando - or +
    We take a random boolean to choose the operator
    */
    private int differentAnswers(){

        int max = 1;
        int min = 10;
        int oneToTen = (int) (Math.random() * ((max - min) + 1)) + min;

        boolean value = r.nextBoolean();

        if(value){
            return answerRandomMathQuestion() - oneToTen;
        }else return answerRandomMathQuestion() + oneToTen;

    }

    /**
     * Noch nicht fertig
     */
    public void noMoreThanOneSameAnswer(){

        do {
            button1.setText(String.valueOf(differentAnswers()));
            button2.setText(String.valueOf(differentAnswers()));
            button3.setText(String.valueOf(differentAnswers()));
            button4.setText(String.valueOf(differentAnswers()));
        } while(button1.getText().equals(button2.getText()) && button1.getText().equals(button3.getText()) &&
                button1.getText().equals(button4.getText()) && button2.getText().equals(button3.getText()) &&
                button2.getText().equals(button4.getText()) && button3.getText().equals(button4.getText()));
    }


     public void rightAnswer(int min, int max){

     // This only works in newer APi`s:  int buttons = ThreadLocalRandom.current().nextInt(1,4);

         final int buttons = r.nextInt(2) + 2;

     Log.i("Info", buttons + "Button wurde genommen");

     if(buttons == 1){
     button1.setText(String.valueOf(answerRandomMathQuestion()));
     }else if(buttons == 2){
     button2.setText(String.valueOf(answerRandomMathQuestion()));
     }else if(buttons == 3){
     button3.setText(String.valueOf(answerRandomMathQuestion()));
     }else button4.setText(String.valueOf(answerRandomMathQuestion()));
     }

}
