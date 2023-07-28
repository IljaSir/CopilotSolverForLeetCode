class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        
        int[] pair = new int[n];
        for (int[] p: pairs) {
            pair[p[0]] = p[1];
            pair[p[1]] = p[0];
        }

        int unhappy = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                int x = preferences[i][j];
                if (preferences[x][0] != i) {
                    break;
                }
                int y = pair[x];
                for (int k = 0; k < n - 1; k++) {
                    int u = preferences[x][k];
                    if (preferences[u][0] != x) {
                        break;
                    }
                    if (preferences[u][0] == i) {
                        unhappy++;
                        break;
                    }
                }
            }
        }
        return unhappy;
    }
}