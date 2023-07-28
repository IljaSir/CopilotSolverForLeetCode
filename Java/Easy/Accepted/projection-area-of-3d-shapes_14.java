class Solution {
    public int projectionArea(int[][] grid) {
        
        int n = grid.length;
        int xz = 0;
        int yz = 0;
        int xy = 0;
        int[] xzArray = new int[n];
        int[] yzArray = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int v = grid[i][j];
                if (v > 0) {
                    xy++;
                }
                if (v > xzArray[i]) {
                    xzArray[i] = v;
                }
                if (v > yzArray[j]) {
                    yzArray[j] = v;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            xz += xzArray[i];
            yz += yzArray[i];
        }
        return xz + yz + xy;
    }
}