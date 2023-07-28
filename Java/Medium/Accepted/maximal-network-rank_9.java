class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        
        int[] roadCount = new int[n];
        boolean[][] road = new boolean[n][n];
        for (int[] r : roads) {
            roadCount[r[0]]++;
            roadCount[r[1]]++;
            road[r[0]][r[1]] = true;
            road[r[1]][r[0]] = true;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int count = roadCount[i] + roadCount[j];
                if (road[i][j]) {
                    count--;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}