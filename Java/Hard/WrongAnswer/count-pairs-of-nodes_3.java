class Solution {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        
        int[] ans = new int[queries.length];
        int[] degree = new int[n+1];
        int[] count = new int[n+1];
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            count[degree[i]]++;
        }
        for (int i = n-1; i >= 0; i--) {
            count[i] += count[i+1];
        }
        for (int i = 0; i < queries.length; i++) {
            int q = queries[i];
            for (int j = 1; j <= n; j++) {
                int d = degree[j];
                if (d > q) {
                    ans[i] += count[d-q];
                }
            }
            for (int[] edge : edges) {
                if (edge[0] > edge[1]) {
                    int t = edge[0];
                    edge[0] = edge[1];
                    edge[1] = t;
                }
                int d = degree[edge[0]] + degree[edge[1]];
                if (d > q && d - degree[edge[1]] <= q) {
                    ans[i]--;
                }
            }
        }
        return ans;
    }
}