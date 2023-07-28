class Solution {
    public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
        
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[] count = new int[2];
                count[0] = introvertsCount;
                count[1] = extrovertsCount;
                int[][] map = new int[m][n];
                int[] cur = new int[2];
                cur[0] = i;
                cur[1] = j;
                int num = 0;
                while (cur[0] != -1) {
                    int[] next = getNext(cur, m, n);
                    if (count[0] > 0) {
                        int[] countCopy = count.clone();
                        int[][] mapCopy = new int[m][n];
                        for (int k = 0; k < m; k++) {
                            mapCopy[k] = map[k].clone();
                        }
                        countCopy[0]--;
                        mapCopy[cur[0]][cur[1]] = 1;
                        mapCopy[next[0]][next[1]] = 1;
                        int score = dp[cur[0]][cur[1]] + 120 - getNeighbor(cur, mapCopy) * 30;
                        if (next[0] != -1) {
                            score += dp[next[0]][next[1]];
                        }
                        dp[i][j] = Math.max(dp[i][j], score);
                        count = countCopy;
                        map = mapCopy;
                    }
                    if (count[1] > 0) {
                        int[] countCopy = count.clone();
                        int[][] mapCopy = new int[m][n];
                        for (int k = 0; k < m; k++) {
                            mapCopy[k] = map[k].clone();
                        }
                        countCopy[1]--;
                        mapCopy[cur[0]][cur[1]] = 2;
                        mapCopy[next[0]][next[1]] = 2;
                        int score = dp[cur[0]][cur[1]] + 40 + getNeighbor(cur, mapCopy) * 20;
                        if (next[0] != -1) {
                            score += dp[next[0]][next[1]];
                        }
                        dp[i][j] = Math.max(dp[i][j], score);
    }
}