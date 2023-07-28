class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        
        UnionFind uf1 = new UnionFind(n), uf2 = new UnionFind(n);
        int result = 0;
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (!uf1.union(edge[1] - 1, edge[2] - 1)) {
                    result++;
                } else {
                    uf2.union(edge[1] - 1, edge[2] - 1);
                }
            }
        }
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (!uf1.union(edge[1] - 1, edge[2] - 1)) {
                    result++;
                }
            } else if (edge[0] == 2) {
                if (!uf2.union(edge[1] - 1, edge[2] - 1)) {
                    result++;
                }
            }
        }
        if (uf1.setCount != 1 || uf2.setCount != 1) {
            return -1;
        }
        return result;
    }
}
    }
}