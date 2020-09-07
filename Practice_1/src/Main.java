import java.util.*;

public class Main {

    public static void main(String[] args) {
        Ex1();
        Ex2(args);
        Ex3();
        Ex4();
        Ex5();
    }

    public static void Ex1() {
        System.out.println("_Ex1_");
        int[] array = {1, 2, 3, 4, 5};
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        System.out.println("Сумма элементов через for: " + sum);

        sum = 0;
        int i = 0;
        while (i < array.length) {
            sum += array[i];
            i++;
        }
        System.out.println("Сумма элементов через while: " + sum);

        sum = 0;
        do {
            i--;
            sum += array[i];
        } while (i > 0);
        System.out.println("Сумма элементов через do while: " + sum);
    }

    public static void Ex2(String[] args) {
        System.out.println("_Ex2_");
        for (int i = 0; i < args.length; i++)
            System.out.println("args[" + i + "] : " + args[i]);
    }

    public static void Ex3() {
        System.out.println("_Ex3_");
        for (float i = 1; i <= 10; i++) {
            float res = 1 / i;
            System.out.printf("%.3f \n", res);
        }
    }

    public static void Ex4()
    {
        System.out.println("_Ex4_");
        int[] array = new int[10];
        System.out.println("Math.random():");
        for (int i = 0; i < 10; i++)
        {
            array[i] = 1 + (int) (Math.random()*10);
            System.out.print(array[i] + " ");
        }
        Arrays.sort(array);
        System.out.println("\nSorted array:");
        for (int i = 0; i < 10; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println("\nRandom:");
        for (int i = 0; i < 10; i++)
        {
            Random n = new Random();
            array[i] = n.nextInt(10);
            System.out.print(array[i] + " ");
        }
        Arrays.sort(array);
        System.out.println("\nSorted array:");
        for (int i = 0; i < 10; i++)
        {
            System.out.print(array[i] + " ");
        }
    }

    public static void Ex5(){
        System.out.println("_Ex5_");
        int res = 1;
        for (int i = 1; i < 8; i++)
        {
            res += res*i;
        }
        System.out.print("Факториал 8 = " + res);
    }
}
