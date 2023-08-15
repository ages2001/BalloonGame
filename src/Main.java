import java.util.Scanner;

public class Main {
    public static void findBalloonPosition(int N, int K) {
        CircularLinkedList balloonList = new CircularLinkedList(N);

        System.out.print("\nPosition: ");
        System.out.println(balloonList.remove(K).getData());
    }

    public static void main(String[] args) {
        int N, K;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of balloons (N): ");
        N = scanner.nextInt();
        System.out.print("Enter the number of balloons to pop in each round (K): ");
        K = scanner.nextInt();

        findBalloonPosition(N, K);
    }
}
