package neetcode150;

import java.util.HashSet;

class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];

                if (num != '.') {
                    String rowKey = "row" + i + num; System.out.println(rowKey);
                    String colKey = "col" + i + num; System.out.println(colKey);
                    String boxKey = "box" + (i/3) + (j/3) + num; System.out.println(boxKey);

                    if (
                        !seen.add(rowKey) ||
                        !seen.add(colKey) ||
                        !seen.add(boxKey)
                    ) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(isValidSudoku(board)); // true
    }
}