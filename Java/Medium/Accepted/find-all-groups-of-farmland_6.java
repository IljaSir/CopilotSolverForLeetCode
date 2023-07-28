class Solution {
    public int[][] findFarmland(int[][] land) {
        
        int m = land.length;
        int n = land[0].length;
        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(land[i][j] == 1){
                    int[] r = new int[4];
                    r[0] = i;
                    r[1] = j;
                    r[2] = i;
                    r[3] = j;
                    int x = i;
                    int y = j;
                    while(x < m && land[x][y] == 1){
                        x++;
                    }
                    x--;
                    while(y < n && land[x][y] == 1){
                        y++;
                    }
                    y--;
                    r[2] = x;
                    r[3] = y;
                    res.add(r);
                    for(int k = i; k <= x; k++){
                        for(int l = j; l <= y; l++){
                            land[k][l] = 0;
                        }
                    }
                }
            }
        }
        int[][] r = new int[res.size()][4];
        for(int i = 0; i < res.size(); i++){
            r[i] = res.get(i);
        }
        return r;
    }
}