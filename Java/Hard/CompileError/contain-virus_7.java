class Solution {
    public int containVirus(int[][] isInfected) {
        
        int m = isInfected.length;
        int n = isInfected[0].length;
        int ans = 0;
        Set<Integer> visited = new HashSet<>();
        while (true) {
            int[] wall = new int[m * n];
            int[] area = new int[m * n];
            int[] infect = new int[m * n];
            int maxArea = 0;
            int maxAreaId = -1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isInfected[i][j] == 1 && !visited.contains(i * n + j)) {
                        int[] res = dfs(isInfected, i, j, visited, wall, area, infect);
                        if (res[0] > maxArea) {
                            maxArea = res[0];
                            maxAreaId = res[1];
                        }
                    }
                }
            }
            if (maxArea == 0) {
                break;
            }
            ans += infect[maxAreaId];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isInfected[i][j] == 1 && !visited.contains(i * n + j)) {
                        isInfected[i][j] = 2;
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isInfected[i][j] == 2) {
                        isInfected[i][j] = 1;
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (wall[i * n + j] == 1) {
                        isInfected[i][j] = 2;
                    }
                }
            }
        }
        return ans;
    }
}