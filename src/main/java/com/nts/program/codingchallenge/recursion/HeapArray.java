package com.nts.program.codingchallenge.recursion;

public class HeapArray {


    static class MaxArrayOutput {

        int start;
        int end;

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public int getMaxCount() {
            return maxCount;
        }

        public void setMaxCount(int maxCount) {
            this.maxCount = maxCount;
        }

        int maxCount;

        public MaxArrayOutput(int start, int end, int count) {

            this.start = start;
            this.end = end;
            this.maxCount = count;
        }

        @Override
        public String toString() {
            return "MaxArrayOutput{" +
                    "start=" + start +
                    ", end=" + end +
                    ", maxCount=" + maxCount +
                    '}';
        }
    }

    public static MaxArrayOutput calculateMaxSumArray(int arr[]) {

        int currentMaxEle=0;  //output
        int start = -1;  //startposition
        int end =-1;   //endposition
        int totalVal = 0;  //intermediate result
        boolean first= true;
        for(int i=0;i<arr.length;i++) {

            totalVal = totalVal + arr[i];
            if(totalVal <0) {
                totalVal =0;
                first=true;

            } else if(totalVal>currentMaxEle){

                if(first) {
                    start =i;
                    first=false;
                }
                   currentMaxEle = totalVal;
                   end = i;
            }


        }
        return new MaxArrayOutput(start,end,currentMaxEle);
    }

    public static MaxArrayOutput calculateMaxSumArrayForNegativeNumbrs(int arr[]) {

        int currentMaxEle=arr[0];  //output
        int start = 0;  //startposition
        int end =0;   //endposition
        int totalVal = arr[0];  //intermediate result
        boolean first= false;
        for(int i=1;i<arr.length;i++) {

            totalVal = totalVal + arr[i];
            if(totalVal < arr[i]) {
                totalVal = arr[i];
                first=true;

            }
            if(totalVal>currentMaxEle){

                if(first) {
                    start =i;
                    first=false;
                }
                currentMaxEle = totalVal;
                end = i;
            }


        }
        return new MaxArrayOutput(start,end,currentMaxEle);
    }

    public static void main(String[] args) {

        //-1,-2,2,3,-5,6,0

         int[] arr = {-1,-2,2,3,-1,6,0};
         System.out.println(calculateMaxSumArray(arr));

        int[] arr1 = {-2,-3,-4,-1,0};
        System.out.println(calculateMaxSumArrayForNegativeNumbrs(arr1));

    }


}
