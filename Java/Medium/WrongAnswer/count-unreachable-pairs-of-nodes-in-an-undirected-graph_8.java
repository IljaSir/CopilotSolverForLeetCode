class Solution {
    public long countPairs(int n, int[][] edges) {
        
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int[] rank = new int[n];
        int[] size = new int[n];
        Arrays.fill(size, 1);
        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            union(u, v, parent, rank, size);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += ((long)size[i] * (n - size[i] - 1));
        }
        return ans / 2;
    }
    int find(int x, int[] parent) {
        if (x != parent[x]) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }
    void union(int x, int y, int[] parent, int[] rank, int[] size) {
        int xRoot = find(x, parent);
        int yRoot = find(y, parent);
        if (xRoot == yRoot) {
            return;
        }
        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
            size[yRoot] += size[xRoot];
        } else if (rank[xRoot] > rank[yRoot]) {
            parent[yRoot] = xRoot;
            size[xRoot] += size[yRoot];
        } else {
            parent[yRoot] = xRoot;
            size[xRoot] += size[yRoot];
            rank[xRoot]++;
        }
    }
}