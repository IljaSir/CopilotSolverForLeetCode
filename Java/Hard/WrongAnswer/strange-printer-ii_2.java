class Solution {
    public boolean isPrintable(int[][] targetGrid) {
        
        int m = targetGrid.length;
        int n = targetGrid[0].length;
        int[] minR = new int[61];
        int[] minC = new int[61];
        int[] maxR = new int[61];
        int[] maxC = new int[61];
        int[] count = new int[61];
        Arrays.fill(minR, Integer.MAX_VALUE);
        Arrays.fill(minC, Integer.MAX_VALUE);
        Arrays.fill(maxR, Integer.MIN_VALUE);
        Arrays.fill(maxC, Integer.MIN_VALUE);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int color = targetGrid[i][j];
                minR[color] = Math.min(minR[color], i);
                minC[color] = Math.min(minC[color], j);
                maxR[color] = Math.max(maxR[color], i);
                maxC[color] = Math.max(maxC[color], j);
                count[color]++;
            }
        }
        int[] color = new int[61];
        int[] visited = new int[61];
        for (int i = 1; i <= 60; i++) {
            if (count[i] == 0) {
                continue;
            }
            for (int j = 1; j <= 60; j++) {
                if (count[j] == 0) {
                    continue;
                }
                if (minR[i] >= minR[j] && minC[i] >= minC[j] && maxR[i] <= maxR[j] && maxC[i] <= maxC[j]) {
                    color[i] = j;
                }
            }
        }
        boolean[] visitedColor = new boolean[61];
        for (int i = 1; i <= 60; i++) {
            if (count[i] == 0) {
                continue;
            }
            int c = i;
            while (color[c] != 0) {
                if (visitedColor[color[c]]) {
                    return false;
                }
                visitedColor[color[c]] = true;
                c = color[c];
            }
            Arrays.fill(visitedColor, false);
        }
        return true;
    }
}