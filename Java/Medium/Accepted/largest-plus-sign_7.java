class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        
        int[][] grid = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                grid[i][j]=1;
            }
        }
        for(int i=0;i<mines.length;i++){
            grid[mines[i][0]][mines[i][1]]=0;
        }
        int[][] left = new int[n][n];
        int[][] right = new int[n][n];
        int[][] top = new int[n][n];
        int[][] bottom = new int[n][n];
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    left[i][j]=1;
                    if(j>0){
                        left[i][j]+=left[i][j-1];
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=n-1;j>=0;j--){
                if(grid[i][j]==1){
                    right[i][j]=1;
                    if(j<n-1){
                        right[i][j]+=right[i][j+1];
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[j][i]==1){
                    top[j][i]=1;
                    if(j>0){
                        top[j][i]+=top[j-1][i];
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=n-1;j>=0;j--){
                if(grid[j][i]==1){
                    bottom[j][i]=1;
                    if(j<n-1){
                        bottom[j][i]+=bottom[j+1][i];
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int temp = Math.min(left[i][j],right[i][j]);
                    temp = Math.min(temp,top[i][j]);
                    temp = Math.min(temp,bottom[i][j]);
                    max = Math.max(max,temp);
                }
            }
        }
        return max;
    }
}