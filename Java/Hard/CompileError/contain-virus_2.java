class Solution {
    public int containVirus(int[][] isInfected) {
        
        int m = isInfected.length;
        int n = isInfected[0].length;
        int ans = 0;
        while (true) {
            int[][] walls = new int[m][n];
            int[][] areas = new int[m][n];
            int t = 2;
            for (int i = 0; i < m; ++i)
                for (int j = 0; j < n; ++j)
                    if (isInfected[i][j] == 1)
                        t = Math.max(t, dfs(isInfected, walls, areas, i, j, t));
            if (t == 2)
                break;
            ans += buildWall(walls, areas);
        }
        return ans;
    }

    public int dfs(int[][] isInfected, int[][] walls, int[][] areas, int i, int j, int t) {
        int m = isInfected.length;
        int n = isInfected[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || isInfected[i][j] != 1)
            return 0;
        isInfected[i][j] = t;
        int area = 1;
        for (int[] d : new int[][]{{1,0},{-1,0},{0,1},{0,-1}}) {
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 0 && x < m && y >= 0 && y < n) {
                if (isInfected[x][y] == 0)
                    walls[x][y]++;
                else if (isInfected[x][y] == 1)
                    area += dfs(isInfected, walls, areas, x, y, t);
            }
        }
        areas[i][j] = area;
        return area;
    }
}