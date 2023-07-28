class Solution {
    public void gameOfLife(int[][] board) {
        
        int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        int m = board.length;
        int n = board[0].length;
        int[][] temp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                temp[i][j] = board[i][j];
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int live = 0;
                for(int k=0;k<8;k++){
                    int x = i+dir[k][0];
                    int y = j+dir[k][1];
                    if(x>=0 && x<m && y>=0 && y<n && temp[x][y]==1){
                        live++;
                    }
                }
                if(temp[i][j]==0){
                    if(live==3){
                        board[i][j] = 1;
                    }
                }else{
                    if(live<2 || live>3){
                        board[i][j] = 0;
                    }
                }
            }
        }
    }
}