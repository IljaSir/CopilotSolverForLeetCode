class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        
        int[][] pref = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                pref[i][preferences[i][j]] = j;
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
            int index = pref[x][y];
            for (int i = 0; i < index; i++) {
                int u = preferences[x][i];
                int v = pair[u];
                if (pref[u][x] < pref[u][v]) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}