class Solution {
    public int countCombinations(String[] pieces, int[][] positions) {
        
        int n = pieces.length;
        int[][][] dp = new int[n][8][8];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return countCombinations(pieces, positions, 0, dp);
    }
    
    private int countCombinations(String[] pieces, int[][] positions, int idx, int[][][] dp) {
        if (idx == pieces.length) {
            return 1;
        }
        int x = positions[idx][0] - 1;
        int y = positions[idx][1] - 1;
        if (dp[idx][x][y] != -1) {
            return dp[idx][x][y];
        }
        int res = 0;
        if (pieces[idx].equals("rook")) {
            for (int i = 0; i < 8; i++) {
                if (i == x) {
                    continue;
                }
                res += countCombinations(pieces, positions, idx + 1, dp);
            }
            for (int i = 0; i < 8; i++) {
                if (i == y) {
                    continue;
                }
                res += countCombinations(pieces, positions, idx + 1, dp);
            }
        } else if (pieces[idx].equals("bishop")) {
            for (int i = 0; i < 8; i++) {
                int j = x + y - i;
                if (j < 0 || j >= 8) {
                    continue;
                }
                res += countCombinations(pieces, positions, idx + 1, dp);
            }
            for (int i = 0; i < 8; i++) {
                int j = x - y + i;
                if (j < 0 || j >= 8) {
                    continue;
                }
                res += countCombinations(pieces, positions, idx + 1, dp);
            }
        } else {
            for (int i = 0; i < 8; i++) {
                if (i == x) {
                    continue;
                }
                res +=
    }
}