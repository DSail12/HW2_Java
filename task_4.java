package hw2_java;

import java.util.Scanner;
import java.util.logging.*;

public class task_4 {
    static Scanner scanner = new Scanner(System.in);

    private static final Logger logger = Logger.getLogger(task_4.class.getName());

    public static void main(String[] args) throws Exception {
        Handler fileHandler = new FileHandler("log_task4.xml", true); 
        logger.setUseParentHandlers(false);
        logger.addHandler(fileHandler);

        int num1 = getInt();
        int num2 = getInt();
        System.out.printf("Enter operation: " + System.lineSeparator());
        char operation = getOperation();
        float result = calculator(num1, num2, operation);
        System.out.println("Result of operation: " + result);
    }
    public static int getInt() throws Exception {
        System.out.println("Enter the number: ");
        int num;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        } else {
            System.out.println("Wrong number, try again.");
            logger.info("Error: Wrong number, try again." );
            scanner.next();
            num = getInt();
        }
        return num;
    }
    public static char getOperation() {
        System.out.println("Choose operation + - * / ");
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Wrong operation, try again + - * /");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }
    public static float calculator(int num1, int num2, char operation) throws Exception {
        float result = 0;
        switch (operation) {
            case '+':
                result = num1 + num2;
                logger.info("Calculation result: " + num1 + " " + operation + " " + num2 + " = " + result);
                break;
            case '-':
                result = num1 - num2;
                logger.info("Calculation result: " + num1 + " " + operation + " " + num2 + " = " + result);
                break;
            case '*':
                result = num1 * num2;
                logger.info("Calculation result: " + num1 + " " + operation + " " + num2 + " = " + result);
                break;
            case '/':
                try {
                    result = num1 / num2;
                    logger.info("Calculation result: " + num1 + " " + operation + " " + num2 + " = " + result);
                } catch (ArithmeticException e) {
                    System.out.println("Error: Division by zero.");
                    logger.info("Error: Division by zero.");
                }
                break;
            default:
                System.out.println("Error: Wrong operation, try again.");
                logger.info("Error: {" + operation + "} Wrong operation, try again." );
                result = calculator(num1, num2, getOperation()); // Рекурсия
        }
        return result;
    }
}
