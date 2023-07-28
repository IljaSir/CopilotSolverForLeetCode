class Solution {
    public long countPairs(int n, int[][] edges) {
        
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int[] size = new int[n];
        Arrays.fill(size, 1);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int pu = find(u, parent);
            int pv = find(v, parent);
            if (pu != pv) {
                parent[pu] = pv;
                size[pv] += size[pu];
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                ans += (long) size[i] * (size[i] - 1) / 2;
            }
        }
        return ans;
    }

    private int find(int x, int[] parent) {
        if (x != parent[x]) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }
}