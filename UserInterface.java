package tictactoe;
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
       // System.out.println(gameGrid.chooseWinner());
        getCoordinates();


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

    // check for valid user input
    // if input is not valid repeat until valid input is entered

    private void getCoordinates() {
        boolean shouldContinue = true;
        while (shouldContinue) {
           shouldContinue = isCoordinateValid();
        }
    }

    // checking if user input is valid number in range 1-3
    // get user know that input is invalid

    private boolean isCoordinateValid() {

        try {
            String[] coordinates = sc.nextLine().split(" ");
            int xCoordinate = Integer.parseInt(coordinates[0]);
            int yCoordinate = Integer.parseInt(coordinates[1]);
            if (checkCoordinateRange(xCoordinate,yCoordinate)) {
                return false;
            } else {
                System.out.println("Coordinates should be from 1 to 3!");

                return true;
            }

        } catch (Exception e) {
            System.out.println("You should enter numbers!");

            return true;
        }

    }

    // checking if coordinates are in valid range 1 - 3

    private boolean checkCoordinateRange(int xCoordinate, int yCoordinate) {
        return (xCoordinate >= 1 && xCoordinate <=3)
                && (yCoordinate >=1 && yCoordinate <= 3);
    }

}
