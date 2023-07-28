class Solution {
    public int[][] findFarmland(int[][] land) {
        
        int m = land.length;
        int n = land[0].length;
        int[][] res = new int[m * n][4];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1 && (i == 0 || land[i - 1][j] == 0) && (j == 0 || land[i][j - 1] == 0)) {
                    int x = i;
                    int y = j;
                    while (x < m && land[x][j] == 1) {
                        x++;
                    }
                    while (y < n && land[i][y] == 1) {
                        y++;
                    }
                    res[index++] = new int[]{i, j, x - 1, y - 1};
                }
            }
        }
        return Arrays.copyOf(res, index);
    }
}
    }
}