class Solution {
    public long maxOutput(int n, int[][] edges, int[] price) {
        
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (parent[u] == -1) {
                parent[u] = v;
            } else {
                parent[v] = u;
            }
        }
        int root = 0;
        while (parent[root] != -1) {
            root = parent[root];
        }
        long[] sums = new long[n];
        long[] maxSums = new long[n];
        long[] minSums = new long[n];
        Arrays.fill(maxSums, Long.MIN_VALUE);
        Arrays.fill(minSums, Long.MAX_VALUE);
        dfs(root, parent, sums, maxSums, minSums, price);
        long max = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, maxSums[i] - minSums[i]);
        }
        return max;
    }
    private void dfs(int u, int[] parent, long[] sums, long[] maxSums, long[] minSums, int[] price) {
        sums[u] = price[u];
        maxSums[u] = price[u];
        minSums[u] = price[u];
        for (int v = 0; v < parent.length; v++) {
            if (parent[v] == u) {
                dfs(v, parent, sums, maxSums, minSums, price);
                sums[u] += sums[v];
                maxSums[u] = Math.max(maxSums[u], maxSums[v]);
                minSums[u] = Math.min(minSums[u], minSums[v]);
            }
        }
    }
}