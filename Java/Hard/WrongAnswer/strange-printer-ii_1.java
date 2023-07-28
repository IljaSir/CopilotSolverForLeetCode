class Solution {
    public boolean isPrintable(int[][] targetGrid) {
        
        int m = targetGrid.length;
        int n = targetGrid[0].length;
        int[] minR = new int[61];
        int[] maxR = new int[61];
        int[] minC = new int[61];
        int[] maxC = new int[61];
        Arrays.fill(minR, Integer.MAX_VALUE);
        Arrays.fill(minC, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int c = targetGrid[i][j];
                minR[c] = Math.min(minR[c], i);
                maxR[c] = Math.max(maxR[c], i);
                minC[c] = Math.min(minC[c], j);
                maxC[c] = Math.max(maxC[c], j);
            }
        }
        boolean[] visited = new boolean[61];
        while (true) {
            boolean changed = false;
            for (int c = 1; c <= 60; c++) {
                if (visited[c]) {
                    continue;
                }
                if (minR[c] == Integer.MAX_VALUE) {
                    continue;
                }
                boolean canPrint = true;
                for (int i = minR[c]; i <= maxR[c]; i++) {
                    for (int j = minC[c]; j <= maxC[c]; j++) {
                        if (targetGrid[i][j] != c && !visited[targetGrid[i][j]]) {
                            canPrint = false;
                            break;
                        }
                    }
                }
                if (canPrint) {
                    for (int i = minR[c]; i <= maxR[c]; i++) {
                        for (int j = minC[c]; j <= maxC[c]; j++) {
                            targetGrid[i][j] = 0;
                        }
                    }
                    visited[c] = true;
                    changed = true;
                }
            }
            if (!changed) {
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (targetGrid[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}