class Solution {
    public boolean isPrintable(int[][] targetGrid) {
        
        int m = targetGrid.length;
        int n = targetGrid[0].length;
        int[] minRow = new int[61];
        int[] minCol = new int[61];
        int[] maxRow = new int[61];
        int[] maxCol = new int[61];
        Arrays.fill(minRow, Integer.MAX_VALUE);
        Arrays.fill(minCol, Integer.MAX_VALUE);
        Arrays.fill(maxRow, Integer.MIN_VALUE);
        Arrays.fill(maxCol, Integer.MIN_VALUE);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int color = targetGrid[i][j];
                minRow[color] = Math.min(minRow[color], i);
                minCol[color] = Math.min(minCol[color], j);
                maxRow[color] = Math.max(maxRow[color], i);
                maxCol[color] = Math.max(maxCol[color], j);
            }
        }
        boolean[] visited = new boolean[61];
        boolean[] printed = new boolean[61];
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int color = 1; color <= 60; color++) {
                if (visited[color]) {
                    continue;
                }
                if (printed[color]) {
                    changed = true;
                    visited[color] = true;
                    continue;
                }
                boolean canPrint = true;
                for (int i = minRow[color]; i <= maxRow[color]; i++) {
                    for (int j = minCol[color]; j <= maxCol[color]; j++) {
                        if (targetGrid[i][j] != color && !printed[targetGrid[i][j]]) {
                            canPrint = false;
                            break;
                        }
                    }
                }
                if (canPrint) {
                    changed = true;
                    for (int i = minRow[color]; i <= maxRow[color]; i++) {
                        for (int j = minCol[color]; j <= maxCol[color]; j++) {
                            printed[targetGrid[i][j]] = true;
                        }
                    }
                }
            }
        }
        for (int i = 1; i <= 60; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
}