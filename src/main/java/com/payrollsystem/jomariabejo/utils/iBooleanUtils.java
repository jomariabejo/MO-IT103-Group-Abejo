package com.payrollsystem.jomariabejo.utils;

public interface iBooleanUtils {

    /**
     * Checks if the first character of a string is a double quote (").
     * @param inputString The String to be tested
     * @return True if it begins double quote, false otherwise.
     */
    default boolean isFirstCharDoubleQuote(String inputString) {
        return  inputString.startsWith("\"");
    }

    /**
     * Checks if the first character of a string is a whitespace ( ).
     * @param inputString The string to be tested
     * @return True if it begins whitespace, false otherwise;
     */
    default boolean isFirstCharWhitespace(String inputString) {
        return inputString.startsWith(" ");
    }
}
