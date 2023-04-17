import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
* This program finds the maximum run of lines in a file.
*
* @author Logan S
* @version 1.0
* @since 2023-04-10
*/

public final class IntMaxRun {

    /**
    * For style checker.
    *
    * @exception IllegalStateException Utility class.
    * @see IllegalStateException
    */

    private IntMaxRun() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * Print messages.
    *
    * @param args Unused
    */

    public static void main(String[] args) {

        // Declare a list to store the lines of the input file.
        final ArrayList<String> lines = new ArrayList<>();

        try {
            // Choose a file to read input from.
            final File inputFile = new File("input.txt");
            final Scanner scanner = new Scanner(inputFile);

            // Choose (or create) a file to write output to.
            final FileWriter output = new FileWriter("output.txt");

            // Read each line of the input file and add it to the list.
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }

            // Call the findMaxRun function for each line and write the result
            // to the output file.
            for (String line : lines) {
                final int maxRun = intMaxRun(line);
                System.out.println(maxRun);
                output.write(maxRun + "\n");
            }

            // Close the output writer.
            output.close();
        } catch (IOException err) {
            // Print an error message if there is an error reading the input
            // file or writing the output file.
            System.err.println("Error: " + err.getMessage());
        }
    }

    /**
    * This program finds the maximum run of lines in a file.
    *
    * @param line from file
    * @return max run of line
    */
    public static int intMaxRun(String line) {
        // Program will declare variables.
        int currentRun = 1;
        int maxRun = 0;

        // Checks the line. (maxRun is already set to 0 for 0-length lines.)
        if (line.length() == 1) {
            maxRun = 1;
        }

        // array of all characters in the line
        // in this section
        char[] lineArr = new char[line.length()];
        lineArr = line.toCharArray();

        // check if the current character is equivalent
        // iterate through the array.
        // If the line contains fewer than two, the for loop won't run.
        for (int counter = 0; counter < lineArr.length - 1; counter++) {
            if (lineArr[counter] == lineArr[counter + 1]) {
                currentRun++;
            } else {
                currentRun = 1;
            }
            if (currentRun > maxRun) {
                maxRun = currentRun;
            }
        }
        return maxRun;
    }

}
