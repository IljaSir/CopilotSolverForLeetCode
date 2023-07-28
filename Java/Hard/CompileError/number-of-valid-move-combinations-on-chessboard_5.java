class Solution {
    public int countCombinations(String[] pieces, int[][] positions) {
        
        int n = pieces.length;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] dirs2 = new int[][]{{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int[][][] dp = new int[n][8][8];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    dp[i][j][k] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int x = positions[i][0] - 1;
            int y = positions[i][1] - 1;
            if (pieces[i].equals("rook")) {
                for (int j = 0; j < 4; j++) {
                    int dx = dirs[j][0];
                    int dy = dirs[j][1];
                    int nx = x + dx;
                    int ny = y + dy;
                    while (nx >= 0 && nx < 8 && ny >= 0 && ny < 8) {
                        dp[i][nx][ny] = 0;
                        nx += dx;
                        ny += dy;
                    }
                }
            }
            if (pieces[i].equals("bishop")) {
                for (int j = 0; j < 4; j++) {
                    int dx = dirs2[j][0];
                    int dy = dirs2[j][1];
                    int nx = x + dx;
                    int ny = y + dy;
                    while (nx >= 0 && nx < 8 && ny >= 0 && ny < 8) {
                        dp[i][nx][ny] = 0;
                        nx += dx;
                        ny += dy;
                    }
                }
            }
            if (pieces[i].equals("queen")) {
                for (int j = 0; j < 8; j++) {
                    int dx = dirs[j][0];
                    int dy = dirs[j][1];
                    int nx = x + dx;
                    int ny = y + dy;
                    while (nx >= 0 && nx <
    }
}