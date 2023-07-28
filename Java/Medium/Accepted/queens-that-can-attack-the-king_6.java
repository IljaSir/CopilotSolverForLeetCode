class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        
        List<List<Integer>> result = new ArrayList<>();
        int[][] chessboard = new int[8][8];
        for (int i = 0; i < queens.length; i++) {
            chessboard[queens[i][0]][queens[i][1]] = 1;
        }
        int[] direction = new int[]{-1, 0, 1};
        for (int i = 0; i < direction.length; i++) {
            for (int j = 0; j < direction.length; j++) {
                if (direction[i] == 0 && direction[j] == 0) {
                    continue;
                }
                int x = king[0];
                int y = king[1];
                while (x + direction[i] >= 0 && x + direction[i] < 8 && y + direction[j] >= 0 && y + direction[j] < 8) {
                    x += direction[i];
                    y += direction[j];
                    if (chessboard[x][y] == 1) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(x);
                        temp.add(y);
                        result.add(temp);
                        break;
                    }
                }
            }
        }
        return result;
    }
}