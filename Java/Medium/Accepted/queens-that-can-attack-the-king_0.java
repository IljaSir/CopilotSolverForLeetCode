class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        
        List<List<Integer>> result = new ArrayList<>();
        int[][] board = new int[8][8];
        for (int[] queen : queens) {
            board[queen[0]][queen[1]] = 1;
        }
        int[] direction = new int[]{-1, 0, 1};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(direction[i] == 0 && direction[j] == 0)) {
                    int x = king[0] + direction[i];
                    int y = king[1] + direction[j];
                    while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                        if (board[x][y] == 1) {
                            List<Integer> list = new ArrayList<>();
                            list.add(x);
                            list.add(y);
                            result.add(list);
                            break;
                        }
                        x += direction[i];
                        y += direction[j];
                    }
                }
            }
        }
        return result;
    }
}