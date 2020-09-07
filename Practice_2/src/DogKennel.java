import java.util.Scanner;
public class DogKennel {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Dog[] doge = new Dog[3];
        for (int i = 0; i<3; i++)
        {
            doge[i] = new Dog(in.next(), in.nextInt());
            System.out.println(doge[i].ToString());
        }
    }
}
