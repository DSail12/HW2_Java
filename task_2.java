// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

package hw2_java;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.*;

public class task_2 {
    private static final Logger logger = Logger.getLogger(task_2.class.getName());

    public static void main(String[] args) throws Exception {

        Handler fileHandler = new FileHandler("log_task2.xml");
        logger.setUseParentHandlers(false);
        logger.addHandler(fileHandler);
        
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите размер массива: ");
        int size_arr = iScanner.nextInt();
        int [] arr = new int[size_arr];
        for (int i = 0; i < size_arr; i++){
            System.out.printf("Введите " + (i + 1) + " элемент массива: ");
            arr[i] = iScanner.nextInt();
        }
        System.out.println("Введенные элементы массива: " + Arrays.toString(arr));
        boolean isSorted = false;
        int buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < size_arr-1; i++) {
                if(arr[i] > arr[i+1]){
                    isSorted = false;
                    buf = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = buf;
                    logger.info("Iteratio element array: " + arr[i]);
                }
            }
        }
        System.out.println("Результат сортировки: " + Arrays.toString(arr));
        iScanner.close();
    }   
}
