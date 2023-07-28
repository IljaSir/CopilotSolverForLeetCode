class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        
        List<List<Integer>> res = new ArrayList<>();
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[][] board = new int[8][8];
        for (int i = 0; i < queens.length; i++) {
            board[queens[i][0]][queens[i][1]] = 1;
        }
        for (int i = 0; i < 8; i++) {
            int x = king[0] + dx[i];
            int y = king[1] + dy[i];
            while (x >= 0 && y >= 0 && x < 8 && y < 8) {
                if (board[x][y] == 1) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(x);
                    tmp.add(y);
                    res.add(tmp);
                    break;
                }
                x += dx[i];
                y += dy[i];
            }
        }
        return res;
    }
}