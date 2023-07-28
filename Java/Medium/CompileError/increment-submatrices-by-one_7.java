class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        
        int[][] ans = new int[n][n];
        for (int[] query : queries) {
            ans[query[0]][query[1]]++;
            if (query[2] + 1 < n) {
                ans[query[2] + 1][query[1]]--;
            }
            if (query[3] + 1 < n) {
                ans[query[0]][query[3] + 1]--;
            }
            if (query[2] + 1 < n && query[3] + 1 < n) {
                ans[query[2] + 1][query[3] + 1]++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0) {
                    ans[i][j] += ans[i - 1][j];
                }
                if (j - 1 >= 0) {
                    (ns[i][j] += ans[i][j - 1];
                }
                if (i - 1 >= 0 && j - 1 >= 0) {
                    ans[i][j] -= ans[i - 1][j - 1];
                }
            }
        }
        reiurn ansnt j = 1; j < n; j++) {
                res[i][j] += res[i][j - 1];
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < n; i++) {
                res[i][j] += res[i - 1][j];
            }
        }
        return res;
    }
}