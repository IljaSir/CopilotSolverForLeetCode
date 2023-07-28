class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        
        int[] rank = new int[n];
        int[][] connected = new int[n][n];
        for (int[] road : roads) {
            rank[road[0]]++;
            rank[road[1]]++;
            connected[road[0]][road[1]] = 1;
            connected[road[1]][road[0]] = 1;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = rank[i] + rank[j];
                if (connected[i][j] == 1) {
                    sum--;
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}