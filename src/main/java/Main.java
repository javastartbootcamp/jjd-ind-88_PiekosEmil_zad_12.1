import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "operations.txt";
        File file = new File(fileName);
        Scanner scan = new Scanner(file);

        while (scan.hasNextDouble() | scan.hasNextLine()) {
            double number1 = scan.nextInt();
            String operator = scan.next();
            double number2 = scan.nextInt();
            double result = 0;
            if (operator.equals("+")) {
                result = number1 + number2;
            } else if (operator.equals("-")) {
                result = number1 - number2;
            } else if (operator.equals("*")) {
                result = number1 * number2;
            } else if (operator.equals("/")) {
                result = number1 / number2;
            }
            System.out.println(number1 + " " + operator + " " + number2 + " = " + result);
        }
        scan.close();
    }
}