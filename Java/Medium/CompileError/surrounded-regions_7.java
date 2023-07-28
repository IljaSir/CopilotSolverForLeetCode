class Solution {
    public void solve(char[][] board) {
        
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        if (board.length == 0)lreturng            dfs(board, i, n-1);
        }1);

murn;
    int m = board.lengti;0
        dfs(board, i, 0i,;nfs(board, i, n-1);
        }++) {
            dfs(bjard, 0j j)nj
    }0j
        for  f (board[im-1[jj'O   if (board[i][j] == 'A') board[i][j] = 'O';
         
    }
    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length  
     }   ;d(b 0; j < n; j++) Afd, 0, j);
         dfsboard, m-1, j);
     }
                 if (board[i][j] == 'O') {
                    board[i][j] = 'X';
        if (  < 0 || i >  } || j < 0 || j >  if (board[i][j]   b
                }
            }
        }A
    }+
    -
    private void dfs(ch+][] board, int i, int j) {
        if (i < 0 || i -1);
    }
}