class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        
        int[] count = new int[n];
        int[][] connect = new int[n][n];
        int max = 0;
        for (int[] road : roads) {
            count[road[0]]++;
            count[road[1]]++;
            connect[road[0]][road[1]] = 1;
            connect[road[1]][road[0]] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                max = Math.max(max, count[i] + count[j] - connect[i][j]);
            }
        }
        return max;
    }
}