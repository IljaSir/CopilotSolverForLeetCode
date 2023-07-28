class Solution {
    public int maximumDetonation(int[][] bombs) {
        
        int n = bombs.length;
        int[] x = new int[n];
        int[] y = new int[n];
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = bombs[i][0];
            y[i] = bombs[i][1];
            r[i] = bombs[i][2];
        }
        
        int[] max = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (Math.sqrt(Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2)) <= r[i] + r[j]) {
                    cnt++;
                }
            }
            max[i] = cnt;
            ans = Math.max(ans, cnt);
        }
        return ans + 1;
    }
}