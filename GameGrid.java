package tictactoe;

public class GameGrid {
    private String[][] gridArray;
    private int[][] gridNumbers;

    public GameGrid() {
    }

    public String[][] getGridArray() {
        return this.gridArray;
    }
    // creating 2D array each row has 3 columns

    public void setGridArray(String gridRepresentation) {
        this.gridArray = new String[gridRepresentation.length() / 3][gridRepresentation.length() / 3];

        int startIndex = 0;

        for (int i = 0; i < this.gridArray.length; i++) {
            for (int j = 0; j < this.gridArray[0].length; j++) {
                this.gridArray[i][j] = gridRepresentation.substring(startIndex, startIndex + 1);
                startIndex += 1;
            }
        }
        setGridNumbers();
    }



    // transfers values X and 0 to 1 or 10
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
    // 0 if not finished "game not finished"
    // 100 "impossible"

    public String chooseWinner() {
        int sum = checkRowsForWiner() + checkColumnsForWinner()
                + checkLeftDiagonalForWinner() + checkRightDiagonalForWinner()
                + checkNumberOfSymbols();
        if (sum == 1) {
            return "X wins";
        } else if (sum == 2) {
            return "O wins";
        } else if (sum == 0 && isGameFinished()) {
            return "Draw";
        } else if (sum == 0 && !isGameFinished()) {
            return "Game not finished";
        } else {
            return "Impossible";
        }

    }

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



    // checking if there is winner, return winner or draw if there is draw or empty string for no winner

    private int returnWinner(int sum) {
        if (sum == 3) {
            return 3;
        } else if (sum == 30) {
            return 30;
        } else {
            return 0;
        }
    }

    // summing numbers in row, if it is 3 or 30 there is a winner

    private int checkRowsForWiner() {
        /*
         * there should not be two winners, if winner number is not equal
         * to 3 or 30, game is not valid
         */
        int winner = 0;
        for (int[] row : this.gridNumbers) {
            int sum = 0;
            for (int element : row) {
                sum += element;
            }
            winner += returnWinner(sum);
        }

        if (winner == 3) {
            return 1;
        } else if (winner == 30) {
            return 2;
        } else if(winner != 0) {
            return 100;
        } else {
            return 0;
        }
    }

    //summing numbers in columns, if there is 3 or 30 there is winner

    private int checkColumnsForWinner() {
        /*
         * there should not be two winners, if winner number is not equal
         * to 3 or 30, game is not valid
         */
        int winner = 0;
        for (int i = 0; i < this.gridNumbers.length; i++) {
            int sum = 0;
            for (int j = 0; j < this.gridNumbers.length; j++) {
                sum += this.gridNumbers[j][i];
            }

            winner += returnWinner(sum);
        }
        if (winner == 3) {
            return 1;
        } else if (winner == 30) {
            return 2;
        } else if(winner != 0) {
            return 100;
        } else {
            return 0;
        }
    }

    // summing numbers in diagonal, if there is 3 or 30 there is a winner

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


    // checking if game is valid by checking number of X and O

    private int checkNumberOfSymbols() {
        int xCount = 0;
        int oCount = 0;
        for (String[] row : this.gridArray) {
            for (String element : row) {
                if (element.equals("X")) {
                    xCount += 1;
                }
                if (element.equals("O")) {
                    oCount += 1;
                }
            }
        }

        if (Math.abs(xCount - oCount) >= 2) {
           return 100;
        }
        return 0;
    }

    // checking if cell is occupied or empty
    public boolean checkCells(String[] coordinate) {
        int xCoordinate = Integer.parseInt(coordinate[0]);
        int yCoordinate = Integer.parseInt(coordinate[1]);
        String symbol = this.gridArray[xCoordinate - 1][yCoordinate - 1];
        if (symbol.equals("_")) {
            // if cell is empty setX to that position
            setXtoGrid(xCoordinate, yCoordinate);
            return true;
        }
        return false;
    }

    private void setXtoGrid(int xCoordinate, int yCoordinate) {
        this.gridArray[xCoordinate -1][yCoordinate -1] = "X";
    }

}
