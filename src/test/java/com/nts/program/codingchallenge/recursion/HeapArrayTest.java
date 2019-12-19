package com.nts.program.codingchallenge.recursion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HeapArrayTest {

    @Test
    public void testMaxArray() {

        int arr[] ={1,2,3,4 ,5 ,6};
        HeapArray.MaxArrayOutput output = HeapArray.calculateMaxSumArray(arr);
        assertEquals(output.getStart(),0);
        assertEquals(output.getEnd(),5);
        assertEquals(output.getMaxCount(),21);

        output = HeapArray.calculateMaxSumArrayForNegativeNumbrs(arr);
        assertEquals(output.getStart(),0);
        assertEquals(output.getEnd(),5);
        assertEquals(output.getMaxCount(),21);
    }

    @Test
    public void testMaxArraySingleElement() {

        int arr[] ={1};
        HeapArray.MaxArrayOutput output = HeapArray.calculateMaxSumArray(arr);
        assertEquals(output.getStart(),0);
        assertEquals(output.getEnd(),0);
        assertEquals(output.getMaxCount(),1);

         output = HeapArray.calculateMaxSumArrayForNegativeNumbrs(arr);
        assertEquals(output.getStart(),0);
        assertEquals(output.getEnd(),0);
        assertEquals(output.getMaxCount(),1);
    }

    @Test
    public void testMaxArrayAllNegativeElement() {

        int arr[] ={-1,-2,-3};
        HeapArray.MaxArrayOutput output = HeapArray.calculateMaxSumArray(arr);
        assertEquals(output.getStart(),-1);
        assertEquals(output.getEnd(),-1);
        assertEquals(output.getMaxCount(),0);

        output = HeapArray.calculateMaxSumArrayForNegativeNumbrs(arr);
        assertEquals(output.getStart(),0);
        assertEquals(output.getEnd(),0);
        assertEquals(output.getMaxCount(),-1);
    }

    @Test
    public void testMaxArrayAllNegativeElementReverse() {

        int arr[] ={-3,-2,-1,0};

        HeapArray.MaxArrayOutput output = HeapArray.calculateMaxSumArrayForNegativeNumbrs(arr);
        assertEquals(output.getStart(),3);
        assertEquals(output.getEnd(),3);
        assertEquals(output.getMaxCount(),0);
    }

    @Test
    public void testMaxArrayMixElement() {

        int[] arr = {-1,-2,2,3,-1,6,0};
        HeapArray.MaxArrayOutput output = HeapArray.calculateMaxSumArray(arr);
        assertEquals(output.getStart(),2);
        assertEquals(output.getEnd(),5);
        assertEquals(output.getMaxCount(),10);

        output = HeapArray.calculateMaxSumArrayForNegativeNumbrs(arr);
        assertEquals(output.getStart(),2);
        assertEquals(output.getEnd(),5);
        assertEquals(output.getMaxCount(),10);
    }

    @Test
    public void testMaxArrayStartsWithPositiveElements() {

        int[] arr = {1,2,3,-6,-7,-8};
        HeapArray.MaxArrayOutput output = HeapArray.calculateMaxSumArray(arr);
        assertEquals(output.getStart(),0);
        assertEquals(output.getEnd(),2);
        assertEquals(output.getMaxCount(),6);

        output = HeapArray.calculateMaxSumArrayForNegativeNumbrs(arr);
        assertEquals(output.getStart(),0);
        assertEquals(output.getEnd(),2);
        assertEquals(output.getMaxCount(),6);
    }

    @Test
    public void testMaxArrayStartsWithPositiveElements2() {

        int[] arr = {4,2,-6,-7,1,3,0};
        HeapArray.MaxArrayOutput output = HeapArray.calculateMaxSumArray(arr);
        assertEquals(output.getStart(),0);
        assertEquals(output.getEnd(),1);
        assertEquals(output.getMaxCount(),6);

        output = HeapArray.calculateMaxSumArrayForNegativeNumbrs(arr);
        assertEquals(output.getStart(),0);
        assertEquals(output.getEnd(),1);
        assertEquals(output.getMaxCount(),6);
    }


}
