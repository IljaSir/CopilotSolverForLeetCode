class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        
        List<List<Integer>> result = new ArrayList<>();
        int n = queens.length;
        int[][] board = new int[8][8];
        for (int i = 0; i < n; i++) {
            board[queens[i][0]][queens[i][1]] = 1;
        }
        for (int i = 0; i < 8; i++) {
            int x = king[0];
            int y = king[1];
            while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                if (board[x][y] == 1) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(x);
                    temp.add(y);
                    result.add(temp);
                    break;
                }
                if (i == 0) {
                    x--;
                } else if (i == 1) {
                    x++;
                } else if (i == 2) {
                    y--;
                } else if (i == 3) {
                    y++;
                } else if (i == 4) {
                    x--;
                    y--;
                } else if (i == 5) {
                    x--;
                    y++;
                } else if (i == 6) {
                    x++;
                    y--;
                } else if (i == 7) {
                    x++;
                    y++;
                }
            }
        }
        return result;
    }
}