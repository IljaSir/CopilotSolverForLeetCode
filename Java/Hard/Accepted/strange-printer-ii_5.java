class Solution {
    public boolean isPrintable(int[][] targetGrid) {
        
        int[] min = new int[61];
        int[] max = new int[61];
        int[] min2 = new int[61];
        int[] max2 = new int[61];
        Arrays.fill(min, 60);
        Arrays.fill(max, -1);
        Arrays.fill(min2, 60);
        Arrays.fill(max2, -1);
        int n = targetGrid.length;
        int m = targetGrid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int c = targetGrid[i][j];
                min[c] = Math.min(min[c], i);
                max[c] = Math.max(max[c], i);
                min2[c] = Math.min(min2[c], j);
                max2[c] = Math.max(max2[c], j);
            }
        }
        boolean[] visited = new boolean[61];
        while (true) {
            boolean any = false;
            for (int c = 1; c <= 60; c++) {
                if (visited[c]) {
                    continue;
                }
                boolean can = true;
                for (int i = min[c]; i <= max[c]; i++) {
                    for (int j = min2[c]; j <= max2[c]; j++) {
                        if (targetGrid[i][j] != 0 && targetGrid[i][j] != c) {
                            can = false;
                            break;
                        }
                    }
                    if (!can) {
                        break;
                    }
                }
                if (can) {
                    visited[c] = true;
                    for (int i = min[c]; i <= max[c]; i++) {
                        for (int j = min2[c]; j <= max2[c]; j++) {
                            targetGrid[i][j] = 0;
                        }
                    }
                    any = true;
                }
            }
            if (!any) {
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (targetGrid[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}