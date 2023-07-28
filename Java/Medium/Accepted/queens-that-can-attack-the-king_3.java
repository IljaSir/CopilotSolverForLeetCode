class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        
        List<List<Integer>> result = new ArrayList<>();
        int[][] map = new int[8][8];
        for (int[] queen : queens) {
            map[queen[0]][queen[1]] = 1;
        }
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        for (int[] direction : directions) {
            int x = king[0];
            int y = king[1];
            while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                if (map[x][y] == 1) {
                    List<Integer> list = new ArrayList<>();
                    list.add(x);
                    list.add(y);
                    result.add(list);
                    break;
                }
                x += direction[0];
                y += direction[1];
            }
        }
        return result;
    }
}