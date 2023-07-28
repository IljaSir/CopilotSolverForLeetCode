class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        
        List<List<Integer>> res = new ArrayList<>();
        int[][] board = new int[8][8];
        for (int[] q : queens) {
            board[q[0]][q[1]] = 1;
        }
        int[] dir = new int[]{0, 1, -1};
        for (int i : dir) {
            for (int j : dir) {
                if (i == 0 && j == 0) continue;
                int x = king[0];
                int y = king[1];
                while (x + i >= 0 && x + i < 8 && y + j >= 0 && y + j < 8) {
                    x += i;
                    y += j;
                    if (board[x][y] == 1) {
                        List<Integer> list = new ArrayList<>();
                        list.add(x);
                        list.add(y);
                        res.add(list);
                        break;
                    }
                }
            }
        }
        return res;
    }
}