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

    public int[][] getGridNumbers() {
        return this.gridNumbers;
    }

    // transfers values X and 0 to 1 or 10
    // needed for algorithm to decide who win

    public void setGridNumbers() {
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


    public void chooseWinner() {

    }

    public boolean isGameFinished() {
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
            return 1;
        }
    }

    // summing numbers in row, if it is 3 or 30 there is a winner

    public String checkRowsForWiner() {
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
            return "X";
        } else if (winner == 30) {
            return "O";
        } else if(winner != 0) {
            return "impossible";
        } else {
            return "neither";
        }
    }

    //summing numbers in columns, if there is 3 or 30 there is winner

    public String checkColumnsForWinner() {
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
            return "X";
        } else if (winner == 30) {
            return "O";
        } else if(winner != 0) {
            return "impossible";
        } else {
            return "neither";
        }
    }

    // summing numbers in diagonal, if there is 3 or 30 there is a winner

    public String checkRightDiagonalForWinner() {
        int sum = 0;
        for (int i = 0; i < this.gridNumbers.length; i++) {
            sum += this.gridNumbers[i][i];
        }

        if (sum == 3) {
            return "X";
        } else if (sum == 30) {
            return "O";
        } else {
            return "neither";
        }
    }

    public String checkLeftDiagonalForWinner() {
        int sum = 0;

        int j = 2;
        for (int i = 0; i < this.gridNumbers.length; i++) {

            sum += this.gridNumbers[i][j];
            j -= 1;
        }
        if (sum == 3) {
            return "X";
        } else if (sum == 30) {
            return "O";
        } else {
            return "neither";
        }
    }


    // checking if game is valid by checking number of X and O

    public String checkNumberOfSymbols() {
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
           return "Impossible";
        }
        return "valid";
    }
}
