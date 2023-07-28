class Solution {
    public long countPairs(int n, int[][] edges) {
        
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            int pa = find(parent, a), pb = find(parent, b);
            if (pa != pb) {
                parent[pa] = pb;
            }
        }
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            size[find(parent, i)]++;
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (long) size[i] * (size[i] - 1) / 2;
        }
        return ans;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}