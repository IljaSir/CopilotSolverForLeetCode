class Solution {
    public int[][] findFarmland(int[][] land) {
        
        int m = land.length;
        int n = land[0].length;
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    int[] arr = new int[4];
                    arr[0] = i;
                    arr[1] = j;
                    land[i][j] = 0;
                    int x = i;
                    int y = j;
                    while (x < m && land[x][j] == 1) {
                        land[x][j] = 0;
                        x++;
                    }
                    while (y < n && land[i][y] == 1) {
                        land[i][y] = 0;
                        y++;
                    }
                    arr[2] = x - 1;
                    arr[3] = y - 1;
                    result.add(arr);
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}