class Solution {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] copy = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                copy[i][j] = grid[i][j];
            }
        }
        for(int[] hit: hits){
            copy[hit[0]][hit[1]] = 0;
        }
        UnionFind uf = new UnionFind(m*n+1);
        for(int i=0; i<n; i++){
            if(copy[0][i] == 1){
                uf.union(i, m*n);
            }
        }
        for(int i=1; i<m; i++){
            for(int j=0; j<n; j++){
                if(copy[i][j] == 1){
                    if(copy[i-1][j] == 1){
                        uf.union(i*n+j, (i-1)*n+j);
                    }
                    if(j>0 && copy[i][j-1] == 1){
                        uf.union(i*n+j, i*n+j-1);
                    }
                }
            }
        }
        int[] res = new int[hits.length];
        for(int i=hits.length-1; i>=0; i--){
            int x = hits[i][0];
            int y = hits[i][1];
            if(grid[x][y] == 0){
                continue;
            }
            int origin = uf.getSize(m*n);
            if(x == 0){
                uf.union(y, m*n);
            }
            if(x>0 && copy[x-1][y] == 1){
                uf.union(x*n+y, (x-1)*n+y);
            }
            if(x<m-1 && copy[x+1][y] == 1){
                uf.union(x*n+y, (x+1)*n+y);
            }
            if(y>0 && copy[x][y-1] == 1){
                uf.union(x*n+y, x*n+y-1);
            }
            if(y<n-1 && copy[x][y+1] == 1){
                uf.union(x*n+y, x*n+y+1);
            }
            int cur = uf.getSize(m*n);
            res[i] = Math.max(0, cur-origin-1);
            copy[x][y] = 1
    }
}