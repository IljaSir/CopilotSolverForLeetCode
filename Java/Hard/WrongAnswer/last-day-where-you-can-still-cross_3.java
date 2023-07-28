class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        
        int[] parent = new int[row * col];
        int[] size = new int[row * col];
        for (int i = 0; i < row * col; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        int[][] mat = new int[row][col];
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int ans = 0;
        for (int i = cells.length - 1; i >= 0; i--) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            mat[r][c] = 1;
            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr >= 0 && nr < row && nc >= 0 && nc < col && mat[nr][nc] == 1) {
                    int p1 = find(r * col + c, parent);
                    int p2 = find(nr * col + nc, parent);
                    if (p1 != p2) {
                        parent[p1] = p2;
                        size[p2] += size[p1];
                    }
                }
            }
            if (size[find(0, parent)] == row * col) {
                ans = i;
                break;
            }
        }
        return ans;
    }
    private int find(int x, int[] parent) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x], parent);
    }
}