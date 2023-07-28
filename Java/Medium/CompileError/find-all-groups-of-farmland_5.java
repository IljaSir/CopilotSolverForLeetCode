class Solution {
    public int[][] findFarmland(int[][] land) {
        
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1) {
                    int[] group = new int[4];
                    group[0] = i;
                    group[1] = j;
                    group[2] = i;
                    group[3] = j;
                    dfs(land, i, j, group);
                    ans.add(group);
                }
            }
        }
        return ans.toArray(new int[0][]);
    }
}