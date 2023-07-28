class Solution {
    public int numRookCaptures(char[][] board) {
        
        int n = 8;
        int r = 0, c = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'R') {
                    r = i;
                    c = j;
                    break;
                }
            }
        }
        int count = 0;
        for (int i = r-1; i >= 0; i--) {
            if (board[i][c] == 'p') {
                count++;
                break;
            } else if (board[i][c] == 'B') {
                break;
            }
        }
        for (int i = r+1; i < n; i++) {
            if (board[i][c] == 'p') {
                count++;
                break;
            } else if (board[i][c] == 'B') {
                break;
            }
        }
        for (int j = c-1; j >= 0; j--) {
            if (board[r][j] == 'p') {
                count++;
                break;
            } else if (board[r][j] == 'B') {
                break;
            }
        }
        for (int j = c+1; j < n; j++) {
            if (board[r][j] == 'p') {
                count++;
                break;
            } else if (board[r][j] == 'B') {
                break;
            }
        }
        return count;
    }
}