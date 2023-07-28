class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        
        int m = board.length;
        int n = board[0].length;
        int i = click[0];
        int j = click[1];
        if (board[i][j] == 'M') {
            board[i][j] = 'X';
        } else {
            dfs(board, i, j, m, n);
        }
        return board;
    }
    
    private void dfs(char[][] board, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'E') {
            return;
        }
        int count = 0;
        for (int p = i - 1; p <= i + 1; p++) {
            for (int q = j - 1; q <= j + 1; q++) {
                if (p >= 0 && p < m && q >= 0 && q < n && board[p][q] == 'M') {
                    count++;
                }
            }
        }
        if (count > 0) {
            board[i][j] = (char)(count + '0');
        } else {
            board[i]

=====; <= j + 1; q++) {
oard, p, q, m, n);
}[click0][click1]M        int y = click[1];
r         ord[x][y][e<int[]dne inX[;
{           return whilempty()) {
         int[] curr = queue.poll();
        up ate int mincleck[0]click[1]       for (int[] dir : dirs) {
                    int nx = curr[0] + dir[0];
                    int ny = curr[1] + dir[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
     ubl c      up ate    continue;
                   }board.lengthboard[0].legth
                    if (board[nx][ny] == 'M') {
                        mines++;
                    }
               }kkk
               if (mlne> ) {ll
                   ko=rd[cur l == 0) {
                    continue;
                }
                if(i + k < 0 || i + k >= board.length || j +rl0] 0 ||]jc+rl1]] board[=].length) {
                 hr conti(ue;
                }
              ' if(+ minei + k);j + l
                } else {
                    board[curr[0]][curr[1]] = 'B';
                    for (int[] dir : dirs) {
                        int nx = curr[0] + dir[0];
                       int ny = curr[1] + dir[1];
                        if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
            r turn;
        }
        }
    }kkk
    return boar;lll
ik == 0&&l==0 {
    }
}