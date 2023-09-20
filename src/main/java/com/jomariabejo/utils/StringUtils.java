package com.jomariabejo.utils;

import java.text.DecimalFormat;

public class StringUtils {

    public static String addDoubleQuotesIfStringHasComma(String str) {
        return str.contains(",") ? "\""+str+"\"" : str;
    }

    public static String addCommaToStrInt(String num) {
        DecimalFormat df = new DecimalFormat("#,###");
        return df.format(Double.valueOf(String.valueOf(num).replace(",","")));
    }

    public static String addCommaAndTwoDecimalsForFloatStr(String num) {
        DecimalFormat df = new DecimalFormat("#,###.##");
        return df.format(Double.valueOf(String.valueOf(num).replace(",","")));
    }

    public static String makeStringLengthToTwenty(String str) {
        int maxLength = 20;

        str = String.format("%-" + maxLength + "s", str);

        return str;
    }
}