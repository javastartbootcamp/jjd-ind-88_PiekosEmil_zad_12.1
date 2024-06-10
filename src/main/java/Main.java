import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        String fileInput = "operations.txt";
        String fileOutput = "results.txt";
        File inputFile = new File(fileInput);
        File outputFile = new File(fileOutput);
        Scanner scan = new Scanner(inputFile);
        double number1 = 0;
        String operator = null;
        double number2 = 0;
        double result = 0;

        while (scan.hasNextDouble() | scan.hasNextLine()) {
            number1 = scan.nextDouble();
            operator = scan.next();
            number2 = scan.nextDouble();
            result = InOutApp.getResult(operator, number1, number2);
            InOutApp.printResult(number1, operator, number2, result);
            InOutApp.writeResult(outputFile, number1, operator, number2, result);
        }
        InOutApp.writerCloser();
        scan.close();
    }
}