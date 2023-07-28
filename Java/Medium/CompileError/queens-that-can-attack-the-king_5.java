class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] queenMap = new boolean[8][8];
        for (int[] queen : queens) {
            queenMap[queen[0]][queen[1]] = true;
        }
        for (int i = king[0] - 1; i >= 0; i--) {
            if (queenMap[i][king[1]]) {
                res.add(Arrays.asList(i, king[1]));
                break;
            }
        }
        for (int i = king[0] + 1; i < 8; i++) {
            if (queenMap[i][king[1]]) {
                res.add(Arrays.asList(i, king[1]));
                break;
            }
        }
        for (int i = king[1] - 1; i >= 0; i--) {
            if (queenMap[king[0]][i]) {
                res.add(Arrays.asList(king[0], i));
                break;
            }
        }
        for (int i = king[1] + 1; i < 8; i++) {
            if (queenMap[king[0]][i]) {
                res.add(Arrays.asList(king[0], i));
                break;
            }
        }
        int i = king[0] - 1, j = king[1] - 1;
        while (i >= 0 && j >= 0) {
            if (queenMap[i][j]) {
                res.add(Arrays.asList(i, j));
                break;
            }
            i--;
            j--;
        }
        i = king[0] - 1;
        j = king[1] + 1;
        while (i >= 0 && j < 8) {
            if (queenMap[i][j]) {
                res.add(Arrays.asList(i, j));
                break;
            }
            i--;
            j++;
        }
        i = king[0] + 1;
        j = king[1] - 1;
        while (i < 8 && j >= 0) {
            if (queenMap[i][j]) {
                res.add(Arrays.asList(i, j));
                break;
            }
            i++;
            j--;
        }
        i = king[0] + 1;
        j = king[1] + 1;
        while (i < 8 && j <
    }
}