package com.first.zagak.gehirntrainer;

import org.junit.Assert;
import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void createFourRandomNumbersSuccess() {
        final Calculation calculation = new Calculation();
        final int firstNumber = 2;
        final int secondNumber = 3;
        final String plusOperator = "+";

        calculation.calculateRandomMathQuestion(firstNumber, secondNumber, plusOperator);

        Assert.assertEquals(4, calculation.getRandomSolutions().size());
    }

    @Test
    public void createRandomSolutionsNoDuplicatedRandomSolutionsSuccess() {
        final Calculation calculation = new Calculation();
        final int firstNumber = 2;
        final int secondNumber = 3;
        final String plusOperator = "+";

        calculation.calculateRandomMathQuestion(firstNumber, secondNumber, plusOperator);

        for (int i = 0; i < calculation.getRandomSolutions().size(); i++) {
            Assert.assertNotEquals(calculation.getRandomSolutions().get(i).intValue(), calculation.getRandomSolutions().get(i++).intValue());
        }
    }
}