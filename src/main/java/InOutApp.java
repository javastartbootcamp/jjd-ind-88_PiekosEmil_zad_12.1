import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class InOutApp {
    static FileWriter fileWriter;
    static BufferedWriter writer;

    protected static double getResult(String operator, double number1, double number2) {
        double result;
        result = switch (operator) {
            case "+" -> number1 + number2;
            case "-" -> number1 - number2;
            case "*" -> number1 * number2;
            case "/" -> number1 / number2;
            default -> 0;
        };
        return result;
    }

    protected static void writeResult(File file, double number1, String operator, double number2, double result) {
        try {
            fileWriter = new FileWriter(file, true);
            writer = new BufferedWriter(fileWriter);
            writer.write(number1 + " " + operator + " " + number2 + " = " + result);
            writer.write(System.lineSeparator());
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected static void writerCloser() throws IOException {
        writer.close();
    }

    protected static void printResult(double number1, String operator, double number2, double result) {
        System.out.println(number1 + " " + operator + " " + number2 + " = " + result);
    }
}
