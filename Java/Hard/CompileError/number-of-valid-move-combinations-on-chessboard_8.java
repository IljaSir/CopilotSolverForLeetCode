class Solution {
    public int countCombinations(String[] pieces, int[][] positions) {
        
        int n = pieces.length;
        int mod = 1_000_000_007;
        int[] dir = new int[]{-1, 0, 1, 0, -1};
        int[][][][] dp = new int[n + 1][8][8][8];
        dp[0][0][0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int x = 0; x < 8; x++) {
                for (int y = 0; y < 8; y++) {
                    for (int k = 0; k < 8; k++) {
                        if (dp[i][x][y][k] == 0) {
                            continue;
                        }
                        int[] p = positions[i];
                        if (pieces[i].equals("rook")) {
                            for (int d = 0; d < 4; d++) {
                                int nx = p[0] + dir[d];
                                int ny = p[1] + dir[d + 1];
                                if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8) {
                                    dp[i + 1][nx][ny][k] = (dp[i + 1][nx][ny][k] + dp[i][x][y][k]) % mod;
                                }
                            }
                        } else if (pieces[i].equals("bishop")) {
                            for (int d = 0; d < 4; d++) {
                                int nx = p[0] + dir[d];
                                int ny = p[1] + dir[d + 1];
                                if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8) {
                                    dp[i + 1][nx][ny][k] = (dp[i + 1][nx][ny][k] + dp[i][x][y][k]) % mod;
                                }
                            }
                        } else {
                            for (int d = 0; d < 4; d++) {
                                int nx = p[0] + dir[d];
                                int ny = p[1] + dir[d + 1];
                                if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8) {
                                    dp[i +
    }
}