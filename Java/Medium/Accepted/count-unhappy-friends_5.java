class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        
        int[][] p = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                p[i][preferences[i][j]] = j;
            }
        }
        int[] match = new int[n];
        for (int[] pair : pairs) {
            int person0 = pair[0], person1 = pair[1];
            match[person0] = person1;
            match[person1] = person0;
        }
        int unhappyCount = 0;
        for (int x = 0; x < n; x++) {
            int y = match[x];
            int index = p[x][y];
            for (int i = 0; i < index; i++) {
                int u = preferences[x][i];
                int v = match[u];
                if (p[u][x] < p[u][v]) {
                    unhappyCount++;
                    break;
                }
            }
        }
        return unhappyCount;
    }
}