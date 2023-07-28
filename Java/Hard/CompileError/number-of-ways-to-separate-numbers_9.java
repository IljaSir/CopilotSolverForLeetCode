class Solution {
    public int numberOfCombinations(String num) {
        
        // union find
        int n = row * col;
        UnionFind uf = new UnionFind(n + 2);
        int[] dx = new int[] {1, -1, 0, 0};
        int[] dy = new int[] {0, 0, 1, -1};
        int top = n;
        int bottom = n + 1;
        for (int i = 0; i < col; i++) {
            uf.union(top, i);
            uf.union(bottom, n - col + i);
        }
        for (int i = cells.length - 1; i >= 0; i--) {
            int x = cells[i][0] - 1;
            int y = cells[i][1] - 1;
            int pos = x * col + y;
            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];
                int npos = nx * col + ny;
                if (nx < 0 || nx >= row || ny < 0 || ny >= col) {
                    continue;
                }
                if (uf.find(npos) == uf.find(bottom)) {
                    uf.union(pos, bottom);
                }
            }
            if (uf.find(top) == uf.find(bottom)) {
                return i;
            }
        }
        return -1;
    }
}
    }
}