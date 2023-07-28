class Solution {
    public boolean isPrintable(int[][] targetGrid) {
        
        int m = targetGrid.length;
        int n = targetGrid[0].length;
        int[] color = new int[61];
        int[] x1 = new int[61];
        int[] x2 = new int[61];
        int[] y1 = new int[61];
        int[] y2 = new int[61];
        Arrays.fill(x1, Integer.MAX_VALUE);
        Arrays.fill(y1, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                color[targetGrid[i][j]]++;
                x1[targetGrid[i][j]] = Math.min(x1[targetGrid[i][j]], i);
                y1[targetGrid[i][j]] = Math.min(y1[targetGrid[i][j]], j);
                x2[targetGrid[i][j]] = Math.max(x2[targetGrid[i][j]], i);
                y2[targetGrid[i][j]] = Math.max(y2[targetGrid[i][j]], j);
            }
        }
        boolean[] visited = new boolean[61];
        while (true) {
            boolean changed = false;
            for (int i = 1; i <= 60; i++) {
                if (visited[i]) {
                    continue;
                }
                if (color[i] == 0) {
                    visited[i] = true;
                    changed = true;
                    continue;
                }
                boolean canPrint = true;
                for (int j = x1[i]; j <= x2[i]; j++) {
                    for (int k = y1[i]; k <= y2[i]; k++) {
                        if (targetGrid[j][k] != i && !visited[targetGrid[j][k]]) {
                            canPrint = false;
                            break;
                        }
                    }
                    if (!canPrint) {
                        break;
                    }
                }
                if (canPrint) {
                    for (int j = x1[i]; j <= x2[i]; j++) {
                        for (int k = y1[i]; k <= y2[i]; k++) {
                            color[targetGrid[j][k]]--;
                        }
                    }
                    visited[i] = true;
                    changed = true;
                }
            }
            if (!changed) {
                break;
            }
        }
        for (int i = 1; i <= 60;
    }
}