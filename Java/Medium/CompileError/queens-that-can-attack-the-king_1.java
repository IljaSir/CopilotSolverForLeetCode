class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] board = new boolean[8][8];
        for (int[] queen : queens) {
            board[queen[0]][queen[1]] = true;
        }
        // up
        for (int i = king[0] - 1; i >= 0; i--) {
            if (board[i][king[1]]) {
                res.add(Arrays.asList(i, king[1]));
                break;
            }
        }
        // down
        for (int i = king[0] + 1; i < 8; i++) {
            if (board[i][king[1]]) {
                res.add(Arrays.asList(i, king[1]));
                break;
            }
        }
        // left
        for (int j = king[1] - 1; j >= 0; j--) {
            if (board[king[0]][j]) {
                res.add(Arrays.asList(king[0], j));
                break;
            }
        }
        // right
        for (int j = king[1] + 1; j < 8; j++) {
            if (board[king[0]][j]) {
                res.add(Arrays.asList(king[0], j));
                break;
            }
        }
        // up-left
        for (int i = king[0] - 1, j = king[1] - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) {
                res.add(Arrays.asList(i, j));
                break;
            }
        }
        // up-right
        for (int i = king[0] - 1, j = king[1] + 1; i >= 0 && j < 8; i--, j++) {
            if (board[i][j]) {
                res.add(Arrays.asList(i, j));
                break;
            }
        }
        // down-left
        for (int i = king[0] + 1, j = king[1] - 1; i < 8 && j >= 0; i++, j--) {
            if (board[i][j]) {
                res.add(Arrays.asList(i, j));
                break;
            }
        }
        // down-right
        for (int i = king[0] + 1, j
    }
}