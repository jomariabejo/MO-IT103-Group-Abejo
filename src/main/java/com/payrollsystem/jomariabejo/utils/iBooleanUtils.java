package com.payrollsystem.jomariabejo.utils;

import java.util.Arrays;
import java.util.Set;

public interface iBooleanUtils {

    /**
     * Checks if the first character of a string is a double quote (").
     * @param inputString The String to be tested
     * @return True if it begins double quote, false otherwise.
     */
    static boolean isFirstCharDoubleQuote(String inputString) {
        return  inputString.startsWith("\"");
    }

    /**
     * Checks if the first character of a string is a whitespace ( ).
     * @param inputString The string to be tested
     * @return True if it begins whitespace, false otherwise;
     */
    static boolean isFirstCharWhitespace(String inputString) {
        return inputString.startsWith(" ");
    }

    /**
     * Check if the last character of a string is a double quote (").
     * @param inputString The string to be tested
     * @return True if it ends with ("), false otherwise.
     */
    static boolean isTrailingCharDoubleQuote(String inputString) {
        return inputString.endsWith("\"");
    }

}
