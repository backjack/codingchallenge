package com.nts.program.codingchallenge.recursion;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Set;


/**
 * Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers. By convention, 1 is included.
 *
 * Given a number n, the task is to find n’th Ugly number.
 *
 * Examples:
 * Input  : n = 7
 * Output : 8
 *
 * Input  : n = 10
 * Output : 12
 *
 * Input  : n = 15
 * Output : 24
 *
 * Input  : n = 150
 * Output : 5832
 *
 *
 */
public class UglyNumber {

    public static int getUglyNumber(int n) {

        Set<Integer> divisible = Sets.newHashSet(1, 2, 3, 4, 5);
        int i=6;
        for (; i < Integer.MAX_VALUE; i++) {

            divide(i, divisible);
            if (n == divisible.size()) {
                break;
            }

        }

        return i;
    }

    public static boolean divide(int i, Set<Integer> divisble) {

        if (!divisble.contains(i)) {

            if (i % 2 == 0) {
                return divide(i / 2, divisble)? divisble.add(i):false;

            } else if (i % 3 == 0) {
                return divide(i / 3, divisble)? divisble.add(i):false;

            } else if (i % 5 == 0) {
                return divide(i / 5, divisble)? divisble.add(i):false;
            } else {
                return false;
            }
        } else {
            return true;
        }

    }


    public static void main(String[] args) {

        int n =2000;
        Stopwatch stopwatch =  Stopwatch.createStarted();
        int val =UglyNumber.getUglyNumber(n);
        System.out.println(" N :"+n+"   val:"+val +"------" + stopwatch.stop() );
    }




}
