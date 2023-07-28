class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        
        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        int result = 0;
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                int p1 = find(parent, edge[1]);
                int p2 = find(parent, edge[2]);
                if (p1 != p2) {
                    union(parent, rank, p1, p2);
                } else {
                    result++;
                }
            }
        }
        int[] parent1 = Arrays.copyOf(parent, n + 1);
        int[] parent2 = Arrays.copyOf(parent, n + 1);
        int[] rank1 = Arrays.copyOf(rank, n + 1);
        int[] rank2 = Arrays.copyOf(rank, n + 1);
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                int p1 = find(parent1, edge[1]);
                int p2 = find(parent1, edge[2]);
                if (p1 != p2) {
                    union(parent1, rank1, p1, p2);
                } else {
                    result++;
                }
            } else if (edge[0] == 2) {
                int p1 = find(parent2, edge[1]);
                int p2 = find(parent2, edge[2]);
                if (p1 != p2) {
                    union(parent2, rank2, p1, p2);
                } else {
                    result++;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (find(parent1, 1) != find(parent1, i) || find(parent2, 1) != find(parent2, i)) {
                return -1;
            }
        }
        return result;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}