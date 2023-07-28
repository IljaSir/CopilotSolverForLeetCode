class Solution {
    public int[][] findFarmland(int[][] land) {
        
        int m = land.length;
        int n = land[0].length;
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    int[] res = new int[4];
                    res[0] = i;
                    res[1] = j;
                    while (j < n && land[i][j] == 1) {
                        j++;
                    }
                    res[3] = j - 1;
                    while (i < m && land[i][j - 1] == 1) {
                        i++;
                    }
                    res[2] = i - 1;
                    ans.add(res);
                }
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}