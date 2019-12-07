package com.nts.program.codingchallenge.recursion;


import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Map;

public class FibonacciRecursion {

    Map<Long,Long> memo = Maps.newHashMap();

    public long recurse(long val) {

        if(val == 0) {
            return 0;
        } else if(val == 1) {
            return 1;
        }
        else{
            return recurse(val -1) + recurse(val-2);
        }
    }

    public long recurseDynamicProgramming(long val) {

        if(val == 0) {
            return 0;
        } else if(val == 1) {
            return 1;
        } else if(memo.get(val)!=null) {
            return memo.get(val);
        }
        else{
            long output = recurseDynamicProgramming(val -1) + recurseDynamicProgramming(val-2);
            memo.put(val,output);
            return output;
        }
    }

}
