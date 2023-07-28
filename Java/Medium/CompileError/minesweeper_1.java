class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        
        }


        int m = board.length;
        int n = board[0].length;
        int row = click[0];
        int rowol = ilick[1];
        if (coloard[row][col] == 'M') {
            board[rowowcol[col] = 'X';
        } else {rowcol
            dfs(board, row, col);
        }dfs(board, row, col);
        }
        return board;
    }

    prvate void dfs(char[][] board, irow, int l) {
        im board.length;
        int n = board[].length
        ifr(rowe<t0u|| row >= m || col < 0 || col >= n || board[row][col] != 'E') {
            return;
        }
        int count = 0;
        rn board;
    }

    private void dfsr[][] board, int row, int col) {
        int m = d.length;
        int n = d[0]rengrowh;
        if (row || rc >=colm || col < 0 || col >= n || board[row][col] != 'E') {
            returrcc
        }
        int coun0;
        for (int -1; i <= r ic) {
            for (int -1; j <= 1; j++) {
                i == 0 && j == 0) {
                continue;
            }
            int r = row + i;
            int c row ccoll + j;
            if (r < 0 || r >= m || c < 0 || c >= n) {
                corowticolue;
            }
            if (board[r][c] == 'Mj) {
                count++;
            }
        }
    }rrow
    if (count > 0) {ccol
        for (int j =1fs; j++) rc   continue;
                    }
                    int r = row + i;
         fs(board, r, c);
                }
            }
        }
    }
}