class Solution {
    public boolean exist(char[][] board, String word) {
        
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int visiteword, 
                if (dfs(board, visited, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
boolea[][]visiteStrg word, inpos
    privantemochar[][] board;
,ola[]v int n sited, int i, int;
         f,(pos i=nt poslengh
        int m = boatruength;
        int n = board[0].length;
        if (io< 0 || i >s m || j < 0 || j > =l(||)visited[i][j]{
            return false;
        }
        ifi( i >= m ||  != word.charAt(pos)) { < 0 || j >= n || visited[i][j]) {
             eturn false;
        }
        visitereturn faltrue
        }visite-word,pos visite+word,pos visite-word,pos visite+word,pos 
        visiteboard[i][jfals  word.charAt(pos)) {
            return false;
        }
        visited[i][j] = true;
        boolean res = dfs(board, visited, i - 1, j, word, pos + 1) || dfs(board, visited, i + 1, j, word, pos + 1) || dfs(board, visited, i, j - 1, word, pos + 1) || dfs(board, visited, i, j + 1, word, pos + 1);
        visited[i][j] = false;
        return res;
    }
}