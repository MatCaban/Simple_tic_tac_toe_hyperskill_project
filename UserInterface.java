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
        printGrid();


    }


    private void getGridFromUser() {
        gameGrid.setGridArray(sc.nextLine());
    }

    private void printGrid() {
        System.out.println("---------");

        for (String[] row : gameGrid.getGridArray()) {
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
            String[] coordinates = sc.nextLine().split(" ");

            // if coordinates are number, check if it is in range
            if (isCoordinateNumber(coordinates)) {
                if (isCoordinateInRange(coordinates)) {

                    // if it is in range check if that cell is not empty
                    if (gameGrid.checkCells(coordinates)) {

                        shouldContinue = false;
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                }
            }
        }

    }

    private boolean isCoordinateNumber(String[] coordinates) {
        try {
            Integer.parseInt(coordinates[0]);
            Integer.parseInt(coordinates[1]);
            return true;
        } catch (Exception e) {
            System.out.println("You should enter numbers!");
            return false;
        }
    }


    // checking if coordinates are in valid range 1 - 3

    private boolean isCoordinateInRange(String[] coordinate) {
        int xCoordinate = Integer.parseInt(coordinate[0]);
        int yCoordinate = Integer.parseInt(coordinate[1]);
        if ((xCoordinate >= 1 && xCoordinate <= 3)
                && (yCoordinate >= 1 && yCoordinate <= 3)) {
            return true;
        } else {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }
    }

}
