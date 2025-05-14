package tictactoe;
import java.util.Arrays;
import java.util.Scanner;
public class UserInterface {
    private final Scanner sc;
    private GameGrid gameGrid;

    public UserInterface() {
        this.sc = new Scanner(System.in);
        this.gameGrid = new GameGrid();
    }
    public void start() {
        getGridFromUser();
        printGrid();
    }


    private void getGridFromUser() {
        gameGrid.setGridArray(sc.nextLine());
    }

    private  void printGrid() {
        System.out.println("---------");

        for (String[] row : gameGrid.getGridArray()){
            System.out.print("| ");
           for (String element : row) {
               System.out.print(element + " ");
           }
            System.out.print("|");
            System.out.println();
        }

        System.out.println("---------");
    }
}
