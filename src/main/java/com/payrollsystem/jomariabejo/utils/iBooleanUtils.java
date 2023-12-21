package com.payrollsystem.jomariabejo.utils;

public interface iBooleanUtils {

    // Return true if the first character is a quote or whitespace, false otherwise
    default boolean isFirstCharQuoteOrWhiteSpace(String str) {
        return str.charAt(0) == ' ' || str.charAt(0) == '\"';
    }
}
