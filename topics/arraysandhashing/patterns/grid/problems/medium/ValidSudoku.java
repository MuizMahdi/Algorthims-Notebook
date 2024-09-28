package topics.arraysandhashing.patterns.grid.problems.medium;

import utils.Problem;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku extends Problem {

    // Single HashSet with Strings
    public boolean isValidSudoku(char[][] board) {
        Set<String> boardSet = new HashSet<>();

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                char digit = board[i][j];
                boolean isBlank = digit == '.';
                boolean existsOnRow = !boardSet.add(digit + "in row" + i);
                boolean existsOnCol = !boardSet.add(digit + "in col" + j);
                boolean existsOnBlock = !boardSet.add(digit + "in block" + i/3 + "-" + j/3); // i/3, j/3 to get block
                if (!isBlank && (existsOnRow || existsOnCol || existsOnBlock) ) {
                    return false;
                }
            }
        }

        return true;
    }

    // TODO: Multiple HashSets:
    public boolean isValidSudokuB(char[][] board) {
        // 9 = num of rows/columns

        // Loop through rows
        for (int i=0; i<9; i++) {
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            HashSet<Character> cubes = new HashSet<>();

            // Loop through cols
            for (int j=0; j<9; j++) {
                char num = board[i][j];
                boolean isBlank = num == '.';

                if (!isBlank && !rows.add(num)) { // Num not blank & already existed in row
                    return false;
                }

                if (!isBlank && !cols.add(num)) { // Num not blank & already existed in column
                    return false;
                }

                int rowIndex = 3*(i/3);
                int colIndex = 3*(i%3);

//                if (board[rowIndex])
            }
        }

        return true;
    }

}
