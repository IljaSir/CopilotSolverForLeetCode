class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        
        int[][] res = new int[n][n];
        for (int[] q : queries) {
            int r1 = q[0], c1 = q[1], r2 = q[2], c2 = q[3];
            res[r1][c1]++;
            if (r2 + 1 < n) res[r2 + 1][c1]--;
            if (c2 + 1 < n) res[r1][c2 + 1]--;
            if (r2 + 1 < n && c2 + 1 < n) res[r2 + 1][c2 + 1]++;
        }
        for (int i = 0; i < n; i++) {
            for at;
    }
}