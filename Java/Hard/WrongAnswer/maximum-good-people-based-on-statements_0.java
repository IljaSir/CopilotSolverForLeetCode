class Solution {
    public int maximumGood(int[][] statements) {
        
        int n = statements.length;
        int[][] adj = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (statements[i][j] == 1) {
                    adj[i][j] = 1;
                } else if (statements[i][j] == 0) {
                    adj[i][j] = -1;
                }
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (adj[i][k] == 1 && adj[k][j] == 1) {
                        adj[i][j] = 1;
                    }
                    if (adj[i][k] == -1 && adj[k][j] == -1) {
                        adj[i][j] = -1;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            boolean ok = true;
            for (int j = 0; j < n; j++) {
                if (adj[i][j] == -1) {
                    ok = false;
                }
            }
            if (ok) {
                ans++;
            }
        }
        return ans;
    }
}