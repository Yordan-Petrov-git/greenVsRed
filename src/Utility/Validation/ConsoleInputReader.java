package Utility.Validation;

import Data.Models.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ConsoleInputReader {

    /**
     * @author Yordan Petrov
     * @param bufferedReader Buffered reader that reads the input from the console.
     * @param gridValidation Validator  for the input.
     * @readTheSizeOfTheGrid Method for reading the input from the console,
     * for the coordinates:(width(row(x)),height(column(y))) of the Grid.
     * @readTheTheGrid Method for reading the input from the console, for
     * the values for each coordinates:(width(row(x)),height(column(y))) of the grid.
     * @readCoordinatesOfTheElementAndGenerationsToIterate Method for
     * reading the input from the console,
     * for the Element(cell from the input's array three values(0,0(row);0,1(column);0,2(NumberOfGenerations)))'s
     * position coordinates:(width(row(x(0,0)),height(column(y(0,1)))) of the Grid that the Number of times
     * that it was with value 1(Green)
     * and the number of Generations(N) that have to pass witch is cell(0,2).
     * @arrayIntParser Parses the input array from String to Integer.
     */

    public BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));

    public GridValidation gridValidation = new GridValidation();


    public int[] readTheSizeOfTheGrid() throws IOException {
        String[] inputArray = bufferedReader.readLine().split(",\\s*");
        System.out.println();
        try {
            gridValidation.isTheInputGridValidHeightAnWithNumbers(inputArray);
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        return arrayIntParser(inputArray);
    }

    public int[][] readTheTheGrid(final int rows, final int columns) throws IOException {

        int[][] gridInput = new int[rows][columns];

        for (int i = 0; i < gridInput.length; i++) {
            String[] inputArray = this.bufferedReader.readLine().split("");

            try {
                Boolean ff =  gridValidation.isTheInputGridValid(inputArray);
                System.out.println();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.exit(-1);
            }

            int[] line = arrayIntParser(inputArray);
            for (int j = 0; j < gridInput[i].length; j++) {
                gridInput[i][j] = line[j];
            }
        }
        return gridInput;
    }

    public int[] readCoordinatesOfTheElementAndGenerationsToIterate() throws IOException {
        String[] inputArray = bufferedReader.readLine().split(",\\s*");
        try {
            //Todo fix validation for cells coordinates generation vlidation works fina
        Boolean ff =    gridValidation.isTheInputResultCellAndGenerationsValid(inputArray);
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        return arrayIntParser(inputArray);
    }


    public int[] arrayIntParser(String[] arrayToBeParsedToInteger) {
        return Arrays.stream(arrayToBeParsedToInteger).mapToInt(Integer::parseInt).toArray();
    }

}
