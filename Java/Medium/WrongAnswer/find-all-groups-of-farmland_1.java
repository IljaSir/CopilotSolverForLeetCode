class Solution {
    public int[][] findFarmland(int[][] land) {
        
        List<int[]> res = new ArrayList<>();
        int m = land.length;
        int n = land[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    int[] tmp = new int[4];
                    tmp[0] = i;
                    tmp[1] = j;
                    tmp[2] = i;
                    tmp[3] = j;
                    while (j < n && land[i][j] == 1) {
                        tmp[3] = j;
                        j++;
                    }
                    while (i < m && land[i][j - 1] == 1) {
                        tmp[2] = i;
                        i++;
                    }
                    res.add(tmp);
                    j--;
                }
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}