class Solution {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        
        int[] ans = new int[queries.length];
        int[] degree = new int[n + 1];
        int[][] cnt = new int[n + 1][n + 1];
        for (int[] e: edges) {
            degree[e[0]]++;
            degree[e[1]]++;
            cnt[e[0]][e[1]]++;
            cnt[e[1]][e[0]]++;
        }
        for (int i = 0; i < queries.length; i++) {
            int q = queries[i];
            int res = 0;
            for (int j = 1; j <= n; j++) {
                for (int k = j + 1; k <= n; k++) {
                    if (degree[j] + degree[k] - cnt[j][k] > q) {
                        res++;
                    }
                }
            }
            ans[i] = res;
        }
        return ans;
    }
}