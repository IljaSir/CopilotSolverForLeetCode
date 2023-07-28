class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        
        int m = edges.length;
        for (int i = 0; i < m; ++i) {
            edges[i] = new int[]{edges[i][0], edges[i][1], edges[i][2], i};
        }
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        UnionFind uf_std = new UnionFind(n);
        int value = 0;
        for (int i = 0; i < m; ++i) {
            if (uf_std.unite(edges[i][0], edges[i][1])) {
                value += edges[i][2];
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < 2; ++i) {
            ans.add(new ArrayList<>());
        }
        for (int i = 0; i < m; ++i) {
            UnionFind uf = new UnionFind(n);
            int v = 0;
            for (int j = 0; j < m; ++j) {
                if (i != j && uf.unite(edges[j][0], edges[j][1])) {
                    v += edges[j][2];
                }
            }
            if (uf.setCount != 1 || (uf.setCount == 1 && v > value)) {
                ans.get(0).add(edges[i][3]);
                continue;
            }
            uf = new UnionFind(n);
            uf.unite(edges[i][0], edges[i][1]);
            v = edges[i][2];
            for (int j = 0; j < m; ++j) {
                if (i != j && uf.unite(edges[j][0], edges[j][1])) {
                    v += edges[j][2];
                }
            }
            if (v == value) {
                ans.get(1).add(edges[i][3]);
            }
        }
        return ans;
    }
}
    }
}