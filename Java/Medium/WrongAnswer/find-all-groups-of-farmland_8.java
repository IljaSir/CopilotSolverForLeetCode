class Solution {
    public int[][] findFarmland(int[][] land) {
        
        int m = land.length;
        int n = land[0].length;
        boolean[][] visited = new boolean[m][n];
        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j] || land[i][j] == 0) continue;
                int[] temp = new int[4];
                temp[0] = i;
                temp[1] = j;
                int x = i;
                int y = j;
                while(x < m && land[x][y] == 1){
                    x++;
                }
                temp[2] = x - 1;
                while(y < n && land[x - 1][y] == 1){
                    y++;
                }
                temp[3] = y - 1;
                res.add(temp);
            }
        }
        int[][] ans = new int[res.size()][4];
        for(int i = 0; i < res.size(); i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}