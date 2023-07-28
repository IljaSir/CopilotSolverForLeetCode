class Solution {
    public int[][] findFarmland(int[][] land) {
        
        int m = land.length;
        int n = land[0].length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    int[] res = new int[4];
                    res[0] = i;
                    res[1] = j;
                    int x = i;
                    int y = j;
                    while (x < m && land[x][y] == 1) {
                        x++;
                    }
                    while (y < n && land[x - 1][y] == 1) {
                        y++;
                    }
                    res[2] = x - 1;
                    res[3] = y - 1;
                    list.add(res);
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}