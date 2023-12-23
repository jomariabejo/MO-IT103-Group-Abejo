import com.payrollsystem.jomariabejo.data.CSVFileNames;
import com.payrollsystem.jomariabejo.utils.DateChecker;
import com.payrollsystem.jomariabejo.utils.MonthChecker;
import com.payrollsystem.jomariabejo.utils.iBooleanUtils;
import com.payrollsystem.jomariabejo.utils.iStringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Sample implements iStringUtils {
    private static String formatDoubleSpace(String inputString) {
        return inputString.replace(",  ", ", ");
    }

    // TODO: 12/23/2023 Replace double spaces with single spaces in Birthday field.
    // TODO: 12/23/2023 Reintroduce commas in the address data.
    // TODO: 12/23/2023 Add commas to monetary values for consistency.

    public static void addAllEmployee() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(CSVFileNames.EMPLOYEE_DETAILS_CSV));

        reader.readLine(); // This will read the first line and skip it.

        String line;

        while ((line = reader.readLine()) != null) {

            ArrayList<String> employeeProcessedData = new ArrayList();

            // Split the line into an array using comma as delimiter
            String[] rowData = line.split(",");

            // Declare a boolean as flag that our concatenator is open
            boolean concatOpen = false;
            /**
             * Declare a string builder for modifying string content.
             * Think of it like a dark room and we have a small bag(string) and large bag(string builder).
             * Then we start to get things, we put small things(unmodified string) to small bag,
             * meanwhile we put large things inside the larger bag(modified string).
             *
             * We use flag(concatOpen)to determine whether the string needs to be modified.
             * We continue to modify large things(modified string) until we're satisfied.
             */
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < rowData.length; i++) {
                String string = rowData[i];

                if (concatOpen) {
                    boolean isAddressProcessing = false;
                    // project means String if satisfied na tayo
                    /**
                     * Verify whether the string has double quotes (") at the end of it.
                     * if it does, we will turn off the concatOpen
                     */
                    if (iBooleanUtils.isTrailingCharDoubleQuote(string)) {
                        concatOpen = false;

                        /**
                         * ⚠️ Since the comma serves as our delimiter to cut the row line into multiple strings,
                         * we'll include it once more to validate our birthday string.
                         *
                         *
                         * ✅ Check if the string contains a month.
                         * if it does, we will add a comma, otherwise, the string won't be changed.
                         */

                        boolean strHasMonth = MonthChecker.isStringContainsMonth(stringBuilder.toString());

                        if (strHasMonth) {
                            String year = string;
                            stringBuilder.append("," + year);
                        }
                        // Verifying if the previously added employee processing data is birthday.
                        else if (DateChecker.isStringBirthday(employeeProcessedData.get(employeeProcessedData.size() - 1))) {
                            // addressStringBuilder to create the address to be process
                            StringBuilder address = new StringBuilder();
                            boolean endsWithDoubleQuote = true;

                            while (!endsWithDoubleQuote) {
                                address.append(string);
                                if (iBooleanUtils.isTrailingCharDoubleQuote(string)) {
                                    address.append(string);
                                    employeeProcessedData.add(address.toString());
                                    break;
                                } else {
                                    address.append(", " + string);
                                    isAddressProcessing = true;
                                }
                            }
                        } else {
                            stringBuilder.append(string);
                        }

                        employeeProcessedData.add(stringBuilder.toString());
                        // Reset the StringBuilder for reuse.
                        stringBuilder.setLength(0);
                    } else {
                        stringBuilder.append(string);
                        /**
                         * isAddressProcessing = employeeProcessedData.stream().anyMatch(x -> {
                         *                             return MonthChecker.isStringContainsMonth(x);
                         *                         });
                         *                         if (isAddressProcessing) {
                         *                             stringBuilder.append(", " + string);
                         *                         } else
                         */
                    }
                } else {
                    if (iBooleanUtils.isFirstCharDoubleQuote(string) || iBooleanUtils.isFirstCharWhitespace(string)) {
                        stringBuilder.append(string + ",");
                        concatOpen = true;
                    } else {
                        employeeProcessedData.add(string);
                    }
                }
            }
            employeeProcessedData.stream().forEach(System.out::println);
        }
    }


    public static void main(String[] args) throws IOException {
        addAllEmployee();
    }
}
