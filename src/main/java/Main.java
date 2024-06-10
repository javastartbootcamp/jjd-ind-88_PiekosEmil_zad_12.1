import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        String fileInput = "operations.txt";
        String fileOutput = "results.txt";
        File inputFile = new File(fileInput);
        File outputFile = new File(fileOutput);
        String operator;
        double number2;
        double number1;
        double result;

        try (
                Scanner scan = new Scanner(inputFile).useLocale(Locale.US);
        ) {
            while (scan.hasNextLine()) {
                number1 = scan.nextDouble();
                operator = scan.next();
                number2 = scan.nextDouble();
                result = InOutApp.getResult(operator, number1, number2);
                InOutApp.printResult(number1, operator, number2, result);
                InOutApp.writeResult(outputFile, number1, operator, number2, result);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}