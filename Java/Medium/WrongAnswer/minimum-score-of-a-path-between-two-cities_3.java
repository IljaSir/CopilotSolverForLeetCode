class Solution {
    public int minScore(int n, int[][] roads) {
        
        int[][] map = new int[n][n];
        for (int i = 0; i < roads.length; i++) {
            int a = roads[i][0] - 1;
            int b = roads[i][1] - 1;
            int d = roads[i][2];
            map[a][b] = map[b][a] = d;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        boolean[] visited = new boolean[n];
        visited[0] = true;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && dp[j] < min) {
                    min = dp[j];
                    minIndex = j;
                }
            }
            visited[minIndex] = true;
            if (minIndex == n - 1) {
                break;
            }
            for (int j = 0; j < n; j++) {
                if (map[minIndex][j] != 0) {
                    dp[j] = Math.min(dp[j], Math.min(dp[minIndex], map[minIndex][j]));
                }
            }
        }
        return dp[n - 1];
    }
}