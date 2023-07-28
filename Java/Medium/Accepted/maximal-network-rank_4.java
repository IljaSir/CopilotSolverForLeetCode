class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        
        int[] degree = new int[n];
        int[][] connected = new int[n][n];
        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
            connected[road[0]][road[1]] = 1;
            connected[road[1]][road[0]] = 1;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                max = Math.max(max, degree[i] + degree[j] - connected[i][j]);
            }
        }
        return max;
    }
}