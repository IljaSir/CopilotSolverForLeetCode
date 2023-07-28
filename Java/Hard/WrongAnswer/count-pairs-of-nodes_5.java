class Solution {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        
        int[] ans = new int[queries.length];
        int[] deg = new int[n+1];
        int[] cnt = new int[n+1];
        int[][] edgeCnt = new int[n+1][n+1];
        for (int[] e : edges) {
            deg[e[0]]++;
            deg[e[1]]++;
            edgeCnt[e[0]][e[1]]++;
            edgeCnt[e[1]][e[0]]++;
        }
        for (int i = 1; i <= n; i++) {
            cnt[deg[i]]++;
        }
        for (int i = n-1; i >= 0; i--) {
            cnt[i] += cnt[i+1];
        }
        for (int i = 0; i < queries.length; i++) {
            int q = queries[i];
            for (int j = 1; j <= n; j++) {
                int k = j+q;
                if (k > n) {
                    break;
                }
                ans[i] += cnt[k] - cnt[j];
                if (k == j) {
                    ans[i] -= cnt[k];
                }
                ans[i] -= edgeCnt[j][k];
            }
        }
        return ans;
    }
}