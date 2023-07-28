class Solution {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        
        int[] ans = new int[queries.length];
        int[] degree = new int[n+1];
        int[][] cnt = new int[n+1][n+1];
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            degree[u]++;
            degree[v]++;
            if (u > v) {
                int tmp = u;
                u = v;
                v = tmp;
            }
            cnt[u][v]++;
        }
        int[] sum = new int[n+1];
        for (int i=1; i<=n; i++) {
            for (int j=i+1; j<=n; j++) {
                sum[degree[i]+degree[j]-cnt[i][j]]++;
            }
        }
        for (int i=n-1; i>=0; i--) {
            sum[i] += sum[i+1];
        }
        for (int i=0; i<queries.length; i++) {
            ans[i] = sum[queries[i]+1];
        }
        return ans;
    }
}