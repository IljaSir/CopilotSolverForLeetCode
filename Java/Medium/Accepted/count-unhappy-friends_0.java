class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        
        int[][] order = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                order[i][preferences[i][j]] = j;
            }
        }
        int[] pair = new int[n];
        for (int[] p : pairs) {
            pair[p[0]] = p[1];
            pair[p[1]] = p[0];
        }
        int ans = 0;
        for (int x = 0; x < n; x++) {
            int y = pair[x];
            int index = order[x][y];
            for (int i = 0; i < index; i++) {
                int u = preferences[x][i];
                int v = pair[u];
                if (order[u][x] < order[u][v]) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}