class Solution {
    public boolean isPrintable(int[][] targetGrid) {
        
        int m = targetGrid.length;
        int n = targetGrid[0].length;
        int[][] colors = new int[61][4];
        for (int i = 0; i < colors.length; i++) {
            colors[i][0] = Integer.MAX_VALUE;
            colors[i][1] = Integer.MIN_VALUE;
            colors[i][2] = Integer.MAX_VALUE;
            colors[i][3] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int c = targetGrid[i][j];
                colors[c][0] = Math.min(colors[c][0], j);
                colors[c][1] = Math.max(colors[c][1], j);
                colors[c][2] = Math.min(colors[c][2], i);
                colors[c][3] = Math.max(colors[c][3], i);
            }
        }
        boolean[] used = new boolean[61];
        int[] visited = new int[61];
        while (true) {
            int color = 0;
            for (int i = 1; i < colors.length; i++) {
                if (used[i]) {
                    continue;
                }
                if (color == 0 || visited[i] < visited[color]) {
                    color = i;
                }
            }
            if (color == 0) {
                break;
            }
            used[color] = true;
            for (int i = colors[color][2]; i <= colors[color][3]; i++) {
                for (int j = colors[color][0]; j <= colors[color][1]; j++) {
                    if (targetGrid[i][j] != color) {
                        visited[targetGrid[i][j]]++;
                    }
                }
            }
        }
        for (int i = 1; i < colors.length; i++) {
            if (!used[i]) {
                return false;
            }
        }
        return true;
    }
}