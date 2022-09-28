import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("**** Welcome to the Minesweeper Game!! ****");
        Scanner inp = new Scanner(System.in);
        System.out.print("Number of Rows: ");
        int row = inp.nextInt();
        System.out.print("Number of Columns: ");
        int col = inp.nextInt();

        MineSweeper mineSweeper = new MineSweeper(row,col);
        mineSweeper.run();
    }
}
