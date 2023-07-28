class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        
        int[] pair = new int[n];
        for (int[] p : pairs) {
            pair[p[0]] = p[1];
            pair[p[1]] = p[0];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int x = pair[i];
            for (int u : preferences[i]) {
                if (u == x) break;
                int v = pair[u];
                for (int j : preferences[u]) {
                    if (j == v) break;
                    if (j == i) {
                        ans++;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}