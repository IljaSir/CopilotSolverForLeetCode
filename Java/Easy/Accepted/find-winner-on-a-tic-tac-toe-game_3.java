class Solution {
    public String tictactoe(int[][] moves) {
        
        char[][] grid = new char[3][3];
        for (int i = 0; i < moves.length; i++) {
            int x = moves[i][0];
            int y = moves[i][1];
            if (i % 2 == 0) {
                grid[x][y] = 'X';
            } else {
                grid[x][y] = 'O';
            }
        }

        int[] xCount = new int[8];
        int[] oCount = new int[8];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == 'X') {
                    xCount[i]++;
                    xCount[j + 3]++;
                    if (i == j) {
                        xCount[6]++;
                    }
                    if (i + j == 2) {
                        xCount[7]++;
                    }
                } else if (grid[i][j] == 'O') {
                    oCount[i]++;
                    oCount[j + 3]++;
                    if (i == j) {
                        oCount[6]++;
                    }
                    if (i + j == 2) {
                        oCount[7]++;
                    }
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            if (xCount[i] == 3) {
                return "A";
            } else if (oCount[i] == 3) {
                return "B";
            }
        }
        if (moves.length < 9) {
            return "Pending";
        }
        return "Draw";
    }
}