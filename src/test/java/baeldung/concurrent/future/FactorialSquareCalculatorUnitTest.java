package baeldung.concurrent.future;

import concurrent.future.FactorialSquareCalculator;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ForkJoinPool;

public class FactorialSquareCalculatorUnitTest {

    @Test
    public void whenCalculatesFactorialSquare_thenReturnCorrectValue() {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        FactorialSquareCalculator calculator = new FactorialSquareCalculator(10);

        forkJoinPool.execute(calculator);

        Assert.assertEquals("The sum of the squares from 1 to 10 is 385", 385, calculator.join().intValue());
    }

}
