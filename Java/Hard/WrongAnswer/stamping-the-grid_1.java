class Solution {
    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        
        int m = grid.length, n = grid[0].length;
        List<int[]> stamps = new ArrayList<>();
        for (int i = 0; i <= m - stampHeight; i++) {
            for (int j = 0; j <= n - stampWidth; j++) {
                if (grid[i][j] == 0) {
                    boolean isStamp = true;
                    for (int k = i; k < i + stampHeight; k++) {
                        for (int l = j; l < j + stampWidth; l++) {
                            if (grid[k][l] == 1) {
                                isStamp = false;
                                break;
                            }
                        }
                        if (!isStamp) break;
                    }
                    if (isStamp) stamps.add(new int[]{i, j});
                }
            }
        }
        if (stamps.size() == 0) return false;
        boolean[] visited = new boolean[stamps.size()];
        int count = 0;
        while (true) {
            int oldCount = count;
            for (int i = 0; i < stamps.size(); i++) {
                if (visited[i]) continue;
                int[] stamp = stamps.get(i);
                boolean isStamp = true;
                for (int k = stamp[0]; k < stamp[0] + stampHeight; k++) {
                    for (int l = stamp[1]; l < stamp[1] + stampWidth; l++) {
                        if (grid[k][l] == 1) {
                            isStamp = false;
                            break;
                        }
                    }
                    if (!isStamp) break;
                }
                if (isStamp) {
                    visited[i] = true;
                    count++;
                    for (int k = stamp[0]; k < stamp[0] + stampHeight; k++) {
                        for (int l = stamp[1]; l < stamp[1] + stampWidth; l++) {
                            grid[k][l] = 1;
                        }
                    }
                }
            }
            if (oldCount == count) break;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) return false;
            }
        }
        return true;
    }
}