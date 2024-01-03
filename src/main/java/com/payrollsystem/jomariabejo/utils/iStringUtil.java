package com.payrollsystem.jomariabejo.utils;

import java.text.DecimalFormat;

public interface iStringUtil {
    /**
     * Checks the given string for the presence of a comma.
     * If not present, encloses the string with quotes using its first and last indices.
     *
     * @param str The string value to be examined.
     * @return A string enclosed with quotes at the beginning and end if no comma is found; otherwise, returns the original string.
     */
    default String encloseWithQuotes(String str) {
        return str.contains(",") ? str : "\"" + str + "\"";
    }

    default String toCommaSeparatedValue(String [] employeeLeaveDetails) {
        // Connect each items
        return String.join(",",employeeLeaveDetails);
    }


    /**
     * Formats a given numerical string by adding commas to represent thousands separator.
     *
     * @param num The numerical string to be formatted.
     * @return A string with commas added as a thousands separator.
     */
    default String formatNumberWithCommas(String num) {
        // Create a DecimalFormat instance to format the number with commas
        DecimalFormat df = new DecimalFormat("#,###");

        // Remove existing commas from the input string and convert it to a double value
        String numWithoutCommas = String.valueOf(num).replace(",", "");
        double parsedNum = Double.valueOf(numWithoutCommas);

        // Format the number with commas using DecimalFormat
        return df.format(parsedNum);
    }


    /**
     * Formats a floating-point numerical string by adding commas as thousands separators and fixing the decimal precision to two places.
     *
     * @param floatingNum The floating-point numerical string to be formatted.
     * @return A string with commas as thousands separators and two decimal places fixed.
     */
    default String formatFloatingNumber(String floatingNum) {
        // Create a DecimalFormat instance to format the number with commas and two decimal places
        DecimalFormat decimalFormat = new DecimalFormat("#,###.##");

        // Remove existing commas from the input string and convert it to a double value
        String numWithoutCommas = floatingNum.replace(",", "");
        double parsedNum = Double.parseDouble(numWithoutCommas);

        // Format the number with commas and two decimal places using DecimalFormat
        return decimalFormat.format(parsedNum);
    }

    static String formatDoubleSpace(String inputString) {
        return inputString.replace(",  ", ", ");
    }

    static String removeQuotes(String inputString) {
        return inputString.replaceAll("\"","");
    }

    static String addCommaToStrInt(String number) {
        StringBuilder result = new StringBuilder(number);
        int length = result.length();

        for (int i = length - 3; i > 0; i -= 3) {
            result.insert(i, ',');
        }
        return result.toString();
    }

    static String addCommaToStrFloat(String number) {
        StringBuilder result = new StringBuilder(number);
        int length = result.length();

        result.delete(length - 3, length);

        boolean initialComma = true;
        for (int i = length - 3; i > 0; i -= 3) {
            if (initialComma) initialComma = false;
            else result.insert(i, ',');
        }
        return result.toString();
    }

    static String addCommaToStrInt(int number) {
        StringBuilder result = new StringBuilder(number);
        int length = result.length();

        for (int i = length - 3; i > 0; i -= 3) {
            result.insert(i, ',');
        }

        return result.toString();
    }

    static String addDoubleQuotesIfStringHasComma(String input) {
        if (input.contains(",")) {
            return "\"" + input + "\"";
        }
        return input;
    }

}
