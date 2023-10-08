package com.jomariabejo.foreachsample;

public class SampleForEach {
    public static void main(String[] args) {
        short [] i = {1,23,4,5,6,10}; // sample inputs of array
        short sum = 0; // starting point ng sum
        /**
         * Iterate I hanggang mareach niya pinakahuling value which is 10
         */
        for (short number : i) { // number means current value of array which is named i line 5
            sum += number;
        }
        System.out.println("Sum = " + sum);
    }
}
