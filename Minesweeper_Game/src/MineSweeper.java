import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    int rowNum, colNum,size;
    boolean game=true;
    int[][] map;
    int[][] board;
    Random rand =new Random();
    Scanner inp = new Scanner(System.in);


    public MineSweeper(int row, int col) {
        this.rowNum = row;
        this.colNum = col;
        this.size = this.rowNum *this.colNum;
        this.map = new int[this.rowNum][this.colNum];
        this.board =new int[this.rowNum][this.colNum];
    }

    public void run(){
        int row,col;
        preparation();
        showMap(map);
        System.out.println("Game started!!");
        while (game){
            showMap(board);
            System.out.print("Give row: ");
            row = inp.nextInt();
            System.out.print("Give col: ");
            col = inp.nextInt();
            if (map[row][col] != -1){
                checkMine(row, col);
            }else {
                game = false;
                System.out.println("Game Over!!");
            }
        }


    }

    public void preparation(){
        int randRow,randCol,count=0;
        while (count != size/4){
            randRow = rand.nextInt(rowNum);
            randCol = rand.nextInt(colNum);
            if (map[randRow][randCol] != -1){ //-1 içinde mine var
                map[randRow][randCol]=-1;
                count++;
            }
        }
    }

    public void showMap(int[][] arr){
        for (int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if (arr[i][j]>=0){
                    System.out.print(" ");
                }
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public void checkMine(int r, int c){
        if (map[r][c]==0){
            if ((c < colNum -1 ) && (map[r][c+1] == -1)){
                board[r][c+1]++;
            }
            if ((c>0) && map[r][c-1] == -1){
                board[r][c-1]++;
            }
            if ((r< rowNum -1) && map[r+1][c] == -1){
                board[r+1][c]++;
            }
            if ((rowNum >0) && map[r-1][c] == -1){
                board[r-1][c]++;
            }
            if (board[r][c]==0){
                board[r][c]=-2;
            }
        }

    }

}
