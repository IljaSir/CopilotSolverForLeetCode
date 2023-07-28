class Solution {
    public int regionsBySlashes(String[] grid) {
        
        int n = grid.length;
        UnionFind uf = new UnionFind(4 * n * n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int index = 4 * (i * n + j);
                char c = grid[i].charAt(j);
                if (c == '/') {
                    uf.union(index, index + 3);
                    uf.union(index + 1, index + 2);
                } else if (c == '\\') {
                    uf.union(index, index + 1);
                    uf.union(index + 2, index + 3);
                } else {
                    uf.union(index, index + 1);
                    uf.union(index + 1, index + 2);
                    uf.union(index + 2, index + 3);
                }
                if (i < n - 1) {
                    uf.union(index + 2, index + 4 * n);
                }
                if (i > 0) {
                    uf.union(index, index - 4 * n + 2);
                }
                if (j < n - 1) {
                    uf.union(index + 1, index + 4 + 3);
                }
                if (j > 0) {
                    uf.union(index + 3, index - 4 + 1);
                }
            }
        }
        return uf.getCount();
    }
}
    }
}