package com.payrollsystem.jomariabejo.utils;

public class IntegerUtil {
    private static int removeComma(String inputNumber) {
        return  Integer.parseInt(inputNumber.replaceAll(",",""));
    }
    private static String removeDoubleQuote(String strNumber) {
        return strNumber.replaceAll("\"", "");
    }
    public static int fixInteger(String inputInteger) {
        return removeComma(removeDoubleQuote(inputInteger));
    }
}
