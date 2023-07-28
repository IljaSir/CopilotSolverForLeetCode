class Solution {
    public int numberOfCombinations(String num) {
        
        int n = cells.length;
        int l = 1, r = n;
        while (l < r) {
            int m = (l + r + 1) / 2;
            if (check(row, col, cells, m)) l = m;
            else r = m - 1;
        }
        return l;
    }
    int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean check(int row, int col, int[][] cells, int m) {
        boolean[][] vis = new boolean[row + 1][col + 1];
        for (int i = 0; i < m; i++) {
            vis[cells[i][0]][cells[i][1]] = true;
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i = 1; i <= col; i++) {
            if (!vis[1][i]) {
                q.offer(new int[]{1, i});
                vis[1][i] = true;
            }
        }
        while (!q.isEmpty()) {
            int[] t = q.poll();
            if (t[0] == row) return true;
            for (int[] dd : d) {
                int x = t[0] + dd[0], y = t[1] + dd[1];
                if (x >= 1 && x <= row && y >= 1 && y <= col && !vis[x][y]) {
                    q.offer(new int[]{x, y});
                    vis[x][y] = true;
                }
            }
        }
        return false;
    }
}