package tictactoe;

public class GameGrid {
    private String[][] gridArray;
    private int[][] gridNumbers;
    private Players players;

    public GameGrid() {
        players = new Players();
    }

    public String[][] getGridArray() {
        return this.gridArray;
    }


    // creating 2D array with same num of columns and row, based on fieldSize

    public void setGridArray(int fieldSize) {
        this.gridArray = new String[fieldSize][fieldSize];

        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                gridArray[i][j] = "_";
            }
        }
        setGridNumbers();
    }


    // transfers values "X" and "O" to 1 or 10
    // needed for algorithm to decide who win

    private void setGridNumbers() {
        this.gridNumbers = new int[this.gridArray[0].length][this.gridArray[0].length];

        for (int i = 0; i < this.gridArray.length; i++) {
            for (int j = 0; j < this.gridArray[0].length; j++) {
                this.gridNumbers[i][j] = this.gridArray[i][j].equals("X")
                        ? 1
                        : this.gridArray[i][j].equals("O")
                        ? 10
                        : 0;
            }
        }
    }


    // sum all returning value from checking
    // 1 "X" wins, 2 "O" wins
    // 0 if finished "draw"
    //

    public boolean isThereWinner() {
        setGridNumbers();
        int sum = 0;
        sum = checkRowsForWiner() + checkColumnsForWinner()
                + checkLeftDiagonalForWinner() + checkRightDiagonalForWinner();
        if (sum == 1) {
            System.out.println("X wins");
            return true;
        } else if (sum == 2) {
            System.out.println("O wins");
            return true;
        } else if (sum == 0 && isGameFinished()) {
            System.out.println("Draw");
            return true;
        } else {
            return false;
        }

    }

    // if there are no more empty ("_") cells, game is done

    private boolean isGameFinished() {
        for (String[] row : this.gridArray) {
            for (String element : row) {
                if (element.equals("_")) {
                    return false;
                }
            }
        }
        return true;
    }


    // summing numbers in row, if it is 3 or 30 there is a winner

    private int checkRowsForWiner() {

        for (int[] row : this.gridNumbers) {
            int sum = 0;
            for (int element : row) {
                sum += element;
            }
            if (sum == 3) {
                return 1;
            } else if (sum == 30) {
                return 2;
            }
        }
        return 0;
    }

    //summing numbers in columns, if there is 3 or 30 there is winner
    // returning 1 for X and 2 for O
    // return 0 for no winner

    private int checkColumnsForWinner() {

        for (int i = 0; i < this.gridNumbers.length; i++) {
            int sum = 0;
            for (int j = 0; j < this.gridNumbers.length; j++) {
                sum += this.gridNumbers[j][i];
            }
            if (sum == 3) {
                return 1;
            } else if (sum == 30) {
                return 2;
            }
        }
        return 0;
    }

    // summing numbers in diagonal, if there is 3 or 30 there is a winner
    // returning 1 for X and 2 for O
    // return 0 for no winner

    private int checkRightDiagonalForWinner() {
        int sum = 0;
        for (int i = 0; i < this.gridNumbers.length; i++) {
            sum += this.gridNumbers[i][i];
        }

        if (sum == 3) {
            return 1;
        } else if (sum == 30) {
            return 2;
        } else {
            return 0;
        }
    }

    private int checkLeftDiagonalForWinner() {
        int sum = 0;

        int j = 2;
        for (int i = 0; i < this.gridNumbers.length; i++) {

            sum += this.gridNumbers[i][j];
            j -= 1;
        }
        if (sum == 3) {
            return 1;
        } else if (sum == 30) {
            return 2;
        } else {
            return 0;
        }
    }


    // checking if cell is occupied or empty
    public boolean checkCells(String[] coordinate) {
        int xCoordinate = Integer.parseInt(coordinate[0]);
        int yCoordinate = Integer.parseInt(coordinate[1]);
        String symbol = this.gridArray[xCoordinate - 1][yCoordinate - 1];
        if (symbol.equals("_")) {
            // if cell is empty set X/O to that position
            setXOtoGrid(xCoordinate, yCoordinate);
            return true;
        }
        return false;
    }

    // check whos turn it is and set X or O

    private void setXOtoGrid(int xCoordinate, int yCoordinate) {
        if (players.isPlayerXTurn()) {
            this.gridArray[xCoordinate - 1][yCoordinate - 1] = "X";
        } else {
            this.gridArray[xCoordinate - 1][yCoordinate - 1] = "O";
        }
        players.switchTurn();


    }

}
