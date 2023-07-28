class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        
        int[] parent = new int[n + 1];
        int[] size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        int count = 0;
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (union(edge[1], edge[2], parent, size)) {
                    count++;
                }
            }
        }
        int[] parentA = new int[n + 1];
        int[] sizeA = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parentA[i] = i;
            sizeA[i] = 1;
        }
        int[] parentB = new int[n + 1];
        int[] sizeB = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parentB[i] = i;
            sizeB[i] = 1;
        }
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (union(edge[1], edge[2], parentA, sizeA)) {
                    count++;
                }
            } else if (edge[0] == 2) {
                if (union(edge[1], edge[2], parentB, sizeB)) {
                    count++;
                }
            }
        }
        int root = find(1, parentA);
        for (int i = 2; i <= n; i++) {
            if (find(i, parentA) != root) {
                return -1;
            }
        }
        root = find(1, parentB);
        for (int i = 2; i <= n; i++) {
            if (find(i, parentB) != root) {
                return -1;
            }
        }
        return edges.length - count;
    }
    private int find(int x, int[] parent) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x], parent);
    }
}