class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        
        List<List<Integer>> result = new ArrayList<>();
        int[][] directions = new int[][]{{1, 1}, {1, -1}, {-1, 1}, {-1, -1}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] direction : directions) {
            int x = king[0], y = king[1];
            while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                x += direction[0];
                y += direction[1];
                for (int[] queen : queens) {
                    if (queen[0] == x && queen[1] == y) {
                        List<Integer> list = new ArrayList<>();
                        list.add(x);
                        list.add(y);
                        result.add(list);
                        break;
                    }
                }
            }
        }
        return result;
    }
}