package tictactoe;

public class GameGrid {
    private String[][] gridArray;

    public GameGrid() {}

    // creating 2D array each row has 3 columns

    public void setGridArray(String gridRepresentation) {
        gridArray = new String[gridRepresentation.length() / 3][gridRepresentation.length() / 3];

        int startIndex = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gridArray[i][j] = gridRepresentation.substring(startIndex, startIndex + 1);
                startIndex += 1;
            }


        }


    }

    public String[][] getGridArray(){
        return this.gridArray;
    }
}
