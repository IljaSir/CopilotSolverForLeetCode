class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        
        int[] count = new int[n];
        boolean[][] connected = new boolean[n][n];
        for (int[] road : roads) {
            count[road[0]]++;
            count[road[1]]++;
            connected[road[0]][road[1]] = true;
            connected[road[1]][road[0]] = true;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = count[i] + count[j];
                if (connected[i][j]) tmp--;
                res = Math.max(res, tmp);
            }
        }
        return res;
    }
}