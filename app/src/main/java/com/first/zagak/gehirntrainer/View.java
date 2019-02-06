package com.first.zagak.gehirntrainer;

import android.os.CountDownTimer;
import android.support.v7.widget.GridLayout;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator;

public class View {


    Button startButton;
    Button exitButton;

    GridLayout gridLayout;

    TextView firstRandomNumber;
    TextView randomAddOrSub;
    TextView secondRandomNumber;
    TextView scoreCount;

    CircularProgressIndicator progressBar;
    int MAX = 30000;
    int STARTINGPOSITION = 30000;
    CountDownTimer countDownTimer;
    int halfMin = 60 * 1000; // 30 sec  in Milli sekunden

    public MainActivity mainActivity;


    // The Method lets the Activity vissible
    public void visible(){
        exitButton.setVisibility(android.view.View.VISIBLE);
        progressBar.setVisibility(android.view.View.VISIBLE);
        firstRandomNumber.setVisibility(android.view.View.VISIBLE);
        randomAddOrSub.setVisibility(android.view.View.VISIBLE);
        secondRandomNumber.setVisibility(android.view.View.VISIBLE);
        scoreCount.setVisibility(android.view.View.VISIBLE);
        gridLayout.setVisibility(android.view.View.VISIBLE);

        startButton.setVisibility(android.view.View.GONE);
    }

    /* FALLS NEUGESTARTET WIRD */
    public void neustart(){
        exitButton.setVisibility(android.view.View.INVISIBLE);
        progressBar.setVisibility(android.view.View.INVISIBLE);
        firstRandomNumber.setVisibility(android.view.View.INVISIBLE);
        randomAddOrSub.setVisibility(android.view.View.INVISIBLE);
        secondRandomNumber.setVisibility(android.view.View.INVISIBLE);
        scoreCount.setVisibility(android.view.View.INVISIBLE);
        gridLayout.setVisibility(android.view.View.INVISIBLE);

        startButton.setVisibility(android.view.View.VISIBLE);

        // ProgressBar zurückgestzt
        progressBar.setEnabled(true);
        progressBar.setCurrentProgress(STARTINGPOSITION);
        countDownTimer.cancel();
    }

    public void timer(){
    /* CountDownTimer startet mit einer halben Minute und jeder onTick ist 10 sekunden */
    countDownTimer = new CountDownTimer(halfMin, 10) {

        @Override
        public void onTick(long millisUntilFinished) {

            Log.i("time",   String.valueOf(millisUntilFinished / 1000));

            progressBar.setCurrentProgress(millisUntilFinished);

        }

        @Override
        public void onFinish() {

            // Hier soll noch ein

            Log.i("info", "Timer ist fertig");

            cancel();

        }
    }.start();

    }


    }

