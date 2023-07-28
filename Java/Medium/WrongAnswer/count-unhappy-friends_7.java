class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        
        int[] pair = new int[n];
        for (int[] p: pairs) {
            pair[p[0]] = p[1];
            pair[p[1]] = p[0];
        }
        int count = 0;
        for (int x = 0; x < n; x++) {
            int y = pair[x];
            int index = 0;
            while (preferences[x][index] != y) {
                int u = preferences[x][index];
                int v = pair[u];
                for (int i = 0; i < n - 1 && preferences[u][i] != v; i++) {
                    if (preferences[u][i] == x) {
                        count++;
                        break;
                    }
                }
                index++;
            }
        }
        return count;
    }
}