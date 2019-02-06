package com.first.zagak.gehirntrainer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private Calculation calculation = new Calculation();

    /*
    CONTAINS:
    -Restart Method: It restarts the app.
    -Visible Method: It makes the startButton invisible and lets everything else visible.
    -Timer Method: It starts the timer with the CircularProgressIndicator after the startButton is pressed.
     */
    private View view = new View();

    /*
    CONTAINS:
    -RandomNumber Method: It generates a number between 1 and 50.
    -addOrSub Method: It choose randomly witch operator will be used.
    -randomMathQuestion Method: It sets a random generated math question.
    -calculateRandomMathQuestion Method: It answers the random math question.
    -differentAnswer Method: The answer  of answerRandomQuestion is getting a random - or +. We take a random boolean to choose the operator
    -
     */


    // Start Button is will set everything Visible
    public void startButton(android.view.View v) {

        Log.i("Info", "Start Button wurde gedrückt");
        view.visible();

        // Random math question is generated
        // Math Question. Void weil nichts zurück gegeben wird
        view.firstRandomNumber.setText(String.valueOf(calculation.randomNumber()));
        view.randomAddOrSub.setText(String.valueOf(calculation.addOrSub()));
        view.secondRandomNumber.setText(String.valueOf(calculation.randomNumber()));

        int firstNumber = Integer.parseInt(view.firstRandomNumber.getText().toString());
        int secondNumber = Integer.parseInt(view.secondRandomNumber.getText().toString());
        String operator = view.randomAddOrSub.getText().toString();

        // The Random question is answerd
        calculation.calculateRandomMathQuestion(firstNumber, secondNumber, operator);

        // lets the one min timner starts
        view.timer();
    }


    /* EXIT */
    public void exit(android.view.View v) {
        Log.i("Info", "Exit Button wurde gedrückt");
        view.neustart();
    }

    // On Create. Initalize everithig
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view.firstRandomNumber = findViewById(R.id.firstRandomNumber);
        view.randomAddOrSub = findViewById(R.id.randomAddOrSubb);
        view.secondRandomNumber = findViewById(R.id.secondRandomNumber);

        view.startButton = findViewById(R.id.goButton);

        view.exitButton = findViewById(R.id.exitButton);

        view.progressBar = findViewById(R.id.circular_progress);
        view.progressBar.setMaxProgress(view.MAX);
        view.progressBar.setCurrentProgress(view.STARTINGPOSITION);

        view.scoreCount = findViewById(R.id.scoreCount);

        view.gridLayout = findViewById(R.id.gridLayout);

//        view.button1 = findViewById(R.id.button1);
//        view.button2 = findViewById(R.id.button2);
//        view.button3 = findViewById(R.id.button3);
//        view.button4 = findViewById(R.id.button4);
    }
}