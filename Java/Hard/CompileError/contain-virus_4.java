class Solution {
    public int containVirus(int[][] isInfected) {
        
        int m = isInfected.length;
        int n = isInfected[0].length;
        int ans = 0;
        while (true) {
            boolean[][] visited = new boolean[m][n];
            int[][] area = new int[m][n];
            int[][] perim = new int[m][n];
            int t = 0;
            for (int i = 0; i < m; ++i)
                for (int j = 0; j < n; ++j)
                    if (isInfected[i][j] == 1 && !visited[i][j])
                        dfs(isInfected, visited, area, perim, i, j, ++t);

            if (t == 0)
                break;

            int[] prio = new int[t+1];
            for (int i = 0; i < m; ++i)
                for (int j = 0; j < n; ++j)
                    prio[area[i][j]] += perim[i][j];

            int wall = 0;
            int target = 0;
            for (int k = 1; k <= t; ++k)
                if (prio[k] > wall) {
                    wall = prio[k];
                    target = k;
                }

            ans += wall;
            for (int i = 0; i < m; ++i)
                for (int j = 0; j < n; ++j)
                    if (area[i][j] == 0)
                        isInfected[i][j] = 2;

            for (int i = 0; i < m; ++i)
                for (int j = 0; j < n; ++j)
                    if (isInfected[i][j] == 2)
                        isInfected[i][j] = 0;
        }

        return ans;
    }
}