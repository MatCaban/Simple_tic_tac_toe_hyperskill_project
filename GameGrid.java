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



    public boolean isGameFinished() {
        for (String[] row : this.gridArray) {
            for (String element : row) {
                if (element.equals("_")) {
                    return true;
                }
            }
        }
        return false;
    }

    public void checkRowsForWiner() {
        int sum = 0;
        for (int[] row : this.gridNumbers) {
            for (int element : row) {
                sum += element;
            }
            if (sum == 3 || sum == 30) {
                System.out.println("there is a winner");
            }
        }
    }
}
