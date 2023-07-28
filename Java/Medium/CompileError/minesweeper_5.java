class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        
 f(cou0 }
> =)     {  = -1; j <= 1; j++) {
                  i ij(x < ch)(count+'0'
           lre 
           orcB  fir(jnt j = -1; j <= 1; j++) {
                     p   i   f(xp< 0 i +  >=pm || y < 0 || y >= n) continue;
                         q  ijx-y 'Eqp<ne+1 q,{
        int   if(m =ddsylen=g,p(]{q,}mn0}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
int x = clic}
    int y = click[1];
    if (b   board[x][y] = 'X';
        } else {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{x, y});
            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                int mines = 0;
                for (int[] dir : dirs) {
                    int nx = curr[0] + dir[0];
                    int ny = curr[1] + dir[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        continue;
                    }
                    if (board[nx][ny] == 'M') {
                        mines++;
                    }
                }
                if (mines > 0) {
                    board[curr[0]][curr[1]] = (char) ('0' + mines);
                } else {
                    board[curr[0]][curr[1]] = 'B';
                    for (int[] dir : dirs) {
                        int nx = curr[0] + dir[0];
                        int ny = curr[1] + dir[1];
                        if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                            continue;
                        }
                        if (board[nx][ny] == 'E') {
                            queue.add(new int[]{nx, ny});
                            board[nx][ny] = 'B';
                        }
                    }
                }
            }
        }
        return board;               int ny = y + j;
                        if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                            continue;
                        }
                        if (board[nx][ny] == 'E') {
                            updateBoard(board, new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        return board;
    }
}