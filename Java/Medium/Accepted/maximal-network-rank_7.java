class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        
        int[] degree = new int[n];
        boolean[][] connected = new boolean[n][n];
        for (int i = 0; i < roads.length; i++) {
            int[] road = roads[i];
            degree[road[0]]++;
            degree[road[1]]++;
            connected[road[0]][road[1]] = true;
            connected[road[1]][road[0]] = true;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int rank = degree[i] + degree[j];
                if (connected[i][j]) {
                    rank--;
                }
                max = Math.max(max, rank);
            }
        }
        return max;
    }
}