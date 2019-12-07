package com.nts.program.codingchallenge.recursion;

import com.google.common.base.Stopwatch;
import com.nts.program.codingchallenge.recursion.FibonacciRecursion;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class FibonacciRecursionTest {



    @Test
    public void testFibonnaci() {

        FibonacciRecursion f = new FibonacciRecursion();
        Stopwatch timer = Stopwatch.createStarted();
        long output = f.recurse(50);
        System.out.println("F(50) "+output);
        System.out.println("Execution time "+ timer.stop());
        assertEquals(output,12586269025l);

        timer = Stopwatch.createStarted();
        output = f.recurse(30);
        System.out.println("F(30) "+ output);
        System.out.println("Execution time "+ timer.stop());
        assertEquals(output,832040l);


        timer = Stopwatch.createStarted();
        output = f.recurse(0);
        System.out.println("F(0) "+ output);
        System.out.println("Execution time "+ timer.stop());
        assertEquals(output,0l);
    }


    /**
     * Fibonacci Series with memoization with dynamic programming. The time required to execute this program is
     * less than above recursive program execution
     * F(0)= 0
     * F(1) =1
     * F(2) =1
     * F(3)=2
     * F(4) =5 .....
     *
     */
    @Test
    public void testFibonnaciDynamicProgramming() {

        FibonacciRecursion f = new FibonacciRecursion();
        Stopwatch timer = Stopwatch.createStarted();
        long output = f.recurseDynamicProgramming(50);
        System.out.println("F(50) "+ output);
        System.out.println("Execution time "+ timer.stop());
        assertEquals(output,12586269025l);

        timer = Stopwatch.createStarted();
        output = f.recurseDynamicProgramming(30);
        System.out.println("F(30) "+ output);
        System.out.println("Execution time "+ timer.stop());
        assertEquals(output,832040l);


        timer = Stopwatch.createStarted();
        output = f.recurseDynamicProgramming(0);
        System.out.println("F(0) "+ output);
        System.out.println("Execution time "+ timer.stop());
        assertEquals(output,0l);
    }
}
