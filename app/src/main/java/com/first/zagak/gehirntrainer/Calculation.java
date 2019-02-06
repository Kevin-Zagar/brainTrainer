package com.first.zagak.gehirntrainer;

import java.util.ArrayList;
import java.util.Random;


public class Calculation {

    private int solution;
    private ArrayList<Integer> randomSolutions = new ArrayList<>();

    public int getSolution() {
        return solution;
    }

    public void setSolution(int solution) {
        this.solution = solution;
    }

    public ArrayList<Integer> getRandomSolutions() {
        return randomSolutions;
    }

    public void setRandomSolutions(ArrayList<Integer> randomSolutions) {
        this.randomSolutions = randomSolutions;
    }

    public int randomNumber() {
        int max = 0;
        int min = 50;
        return (int) (Math.random() * ((max - min) + 1)) + min;

    }

    /* Random + or - */
    public char addOrSub() {
        Random r = new Random();
        String plusMinus = "+-";
        final char c = plusMinus.charAt(r.nextInt(plusMinus.length()));
        return c;
    }

    // We check what came out as an operator and than do the math
    public void calculateRandomMathQuestion(int firstNumber, int secondNumber, String operator) {

        if (operator.equals("-")) {
            solution = firstNumber - secondNumber;
        } else {
            solution = firstNumber + secondNumber;
        }
        setRandomSolutions();
    }

    private boolean checkIfDuplicatedRandomSolutionExits() {
        for (int i = 0; i < randomSolutions.size(); i++) {
            if (randomSolutions.get(i).intValue() == randomSolutions.get(i++).intValue()) {
                return false;
            }
        }
        return true;
    }

    private void setRandomSolutions() {
        for (int i = 0; i < 4; i++) {
            randomSolutions.add(generateRandomSolution());
        }
    }

    private int generateRandomSolution() {
        int max = 1;
        int min = 10;
        int randomNumberBetweenOneAndTen = (int) (Math.random() * ((max - min) + 1)) + min;

        int randomSolution;

        Random r = new Random();
        boolean generateRandomMinusCalculation = r.nextBoolean();

        if (generateRandomMinusCalculation) {
            randomSolution = solution - randomNumberBetweenOneAndTen;

            for (int number : randomSolutions) {
                if (number == randomSolution) {
                    while (checkIfDuplicatedRandomSolutionExits()) {
                        randomNumberBetweenOneAndTen = (int) (Math.random() * ((max - min) + 1)) + min;
                        randomSolution = solution - randomNumberBetweenOneAndTen;
                    }
                }
            }
            return randomSolution;
        } else {
            randomSolution = solution + randomNumberBetweenOneAndTen;

            for (int number : randomSolutions) {
                if (number == randomSolution) {
                    while (checkIfDuplicatedRandomSolutionExits()) {
                        randomNumberBetweenOneAndTen = (int) (Math.random() * ((max - min) + 1)) + min;
                        randomSolution = solution + randomNumberBetweenOneAndTen;
                    }
                }
            }
            return randomSolution;
        }
    }
}
