package com.example.tobySpring;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import java.io.IOException;
import static org.hamcrest.CoreMatchers.*;
public class CalcSumTest {


    @Test
    public void sumOfNumbers() throws IOException {
        Calculator calculator = new Calculator();

        int sum = calculator.calcSum("/Users/etoos/Desktop/numbers.txt");
        assertThat(sum,is(10));
    }
}
