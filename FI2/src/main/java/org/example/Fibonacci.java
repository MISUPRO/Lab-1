package org.example;

import java.util.Scanner;

public class Fibonacci {

    // Антипаттерн: God Object
    // Этот класс делает слишком много: считывает ввод, вычисляет числа Фибоначчи и выводит результат.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int n = scanner.nextInt();

        // Антипаттерн: Hard Code
        // Жестко закодированное значение, которое может быть изменено только через код.
        if (n < 0) {
            System.out.println("Число должно быть неотрицательным.");
            return;
        }

        // Антипаттерн: Magic Number
        // Использование числа 2 без объяснения его значения.
        if (n == 0) {
            System.out.println(0);
        } else if (n == 1) {
            System.out.println(1);
        } else {
            System.out.println(fibonacci(n));
        }

        // Вызов всех методов для демонстрации
        printFibonacciSeries(n);
        printEvenFibonacci(n);
        printOddFibonacci(n);
        FibonacciHelper helper = new FibonacciHelper();
        int[] fibArray = helper.generateFibonacciArray(n);
        System.out.println("Sum of Fibonacci series: " + sumOfFibonacci(fibArray));
        ExtendedFibonacci extendedFibonacci = new ExtendedFibonacci();
        extendedFibonacci.doSomethingElse();
        RecursiveFibonacciCalculator recursiveCalculator = new RecursiveFibonacciCalculator();
        System.out.println("Recursive Fibonacci: " + recursiveCalculator.calculate(n));
        FibonacciWithTempField tempFieldFibonacci = new FibonacciWithTempField();
        System.out.println("Fibonacci with Temp Field: " + tempFieldFibonacci.calculateFibonacci(n));
        AnotherFibonacciCalculator anotherCalculator = new AnotherFibonacciCalculator();
        System.out.println("Another Fibonacci Calculator: " + anotherCalculator.computeFibonacci(n));
        printFibonacciWithComments(n);
        IncompleteFibonacciLibrary incompleteLibrary = new IncompleteFibonacciLibrary();
        System.out.println("Incomplete Library Fibonacci: " + incompleteLibrary.getFibonacci(n));
        oldFibonacciMethod();
        printFibonacciWithMessageChain(n);
    }

    // Антипаттерн: Spaghetti Code
    // Код сложно читать и понять из-за отсутствия структуры и логики.
    public static int fibonacci(int n) {
        // Антипаттерн: Deeply Nested Code
        // Глубоко вложенные условия делают код трудно читаемым.
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            // Антипаттерн: Recursive Overhead
            // Рекурсивный вызов без оптимизации, что приводит к избыточным вычислениям.
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    // Антипаттерн: Dead Code
    // Этот метод никогда не вызывается и не используется.
    public static void unusedMethod() {
        System.out.println("Этот метод никогда не вызывается.");
    }

    // Антипаттерн: Long Method
    // Метод слишком длинный и выполняет слишком много задач.
    public static void printFibonacciSeries(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
    }

    // Антипаттерн: Duplicated Code
    // Повторяющийся код, который можно было бы вынести в отдельный метод.
    public static void printEvenFibonacci(int n) {
        for (int i = 0; i < n; i++) {
            int fib = fibonacci(i);
            if (fib % 2 == 0) {
                System.out.print(fib + " ");
            }
        }
        System.out.println();
    }

    public static void printOddFibonacci(int n) {
        for (int i = 0; i < n; i++) {
            int fib = fibonacci(i);
            if (fib % 2 != 0) {
                System.out.print(fib + " ");
            }
        }
        System.out.println();
    }

    // Антипаттерн: Feature Envy
    // Метод слишком много знает о внутренней структуре другого класса (в данном случае, о массиве).
    public static int sumOfFibonacci(int[] fibArray) {
        int sum = 0;
        for (int fib : fibArray) {
            sum += fib;
        }
        return sum;
    }

    // Антипаттерн: Inappropriate Intimacy
    // Классы слишком тесно связаны, что затрудняет их раздельное тестирование и поддержку.
    public static class FibonacciHelper {
        public int[] generateFibonacciArray(int n) {
            int[] fibArray = new int[n];
            for (int i = 0; i < n; i++) {
                fibArray[i] = fibonacci(i);
            }
            return fibArray;
        }
    }

    // Антипаттерн: Refused Bequest
    // Класс наследует методы, которые ему не нужны.
    public static class ExtendedFibonacci extends Fibonacci {
        public void doSomethingElse() {
            System.out.println("Этот метод не имеет отношения к числам Фибоначчи.");
        }
    }

    // Антипаттерн: Shotgun Surgery
    // Изменение в одном месте требует изменений в множестве других местах.
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Число должно быть неотрицательным.");
            return;
        }

        if (n == 0) {
            System.out.println(0);
        } else if (n == 1) {
            System.out.println(1);
        } else {
            System.out.println(fibonacci(n));
        }
    }

    // Антипаттерн: Speculative Generality
    // Создание абстракций и обобщений, которые не нужны в текущем контексте.
    public interface FibonacciCalculator {
        int calculate(int n);
    }

    public static class RecursiveFibonacciCalculator implements FibonacciCalculator {
        @Override
        public int calculate(int n) {
            return fibonacci(n);
        }
    }

    // Антипаттерн: Temporary Field
    // Поле, которое используется только в одном методе и не имеет смысла в контексте класса.
    public static class FibonacciWithTempField {
        private int temp;

        public int calculateFibonacci(int n) {
            if (n == 0) {
                temp = 0;
            } else if (n == 1) {
                temp = 1;
            } else {
                temp = fibonacci(n - 1) + fibonacci(n - 2);
            }
            return temp;
        }
    }

    // Антипаттерн: Alternative Classes with Different Interfaces
    // Два класса выполняют одну и ту же задачу, но имеют разные интерфейсы.
    public static class AnotherFibonacciCalculator {
        public int computeFibonacci(int n) {
            return fibonacci(n);
        }
    }

    // Антипаттерн: Comments
    // Избыточные комментарии, которые не добавляют ценности и только загромождают код.
    public static void printFibonacciWithComments(int n) {
        // Этот метод печатает числа Фибоначчи
        for (int i = 0; i < n; i++) {
            // Вычисляем число Фибоначчи
            int fib = fibonacci(i);
            // Печатаем число Фибоначчи
            System.out.print(fib + " ");
        }
        System.out.println();
    }

    // Антипаттерн: Incomplete Library Class
    // Класс, который не предоставляет всех необходимых методов для выполнения своей задачи.
    public static class IncompleteFibonacciLibrary {
        public int getFibonacci(int n) {
            return fibonacci(n);
        }

        // Метод для вычисления факториала отсутствует, хотя он мог бы быть полезен.
    }

    // Антипаттерн: Lava Flow
    // Старый код, который больше не используется, но остается в проекте.
    public static void oldFibonacciMethod() {
        System.out.println("Этот метод больше не используется.");
    }

    // Антипаттерн: Message Chain
    // Цепочка вызовов методов, которая делает код трудно читаемым.
    public static void printFibonacciWithMessageChain(int n) {
        FibonacciHelper helper = new FibonacciHelper();
        int[] fibArray = helper.generateFibonacciArray(n);
        System.out.println(sumOfFibonacci(fibArray));
    }

    // Антипаттерн: Lazy Class
    // Класс, который практически ничего не делает, но добавляет сложность.
    public static class LazyClass {
        // Пустой класс, который в будущем может что-то делать, но сейчас не используется.
    }
}
