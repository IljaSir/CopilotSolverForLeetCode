class Solution {
    public void gameOfLife(int[][] board) {
        
        int m = board.length;
        int n = board[0].length;
        int[][] copy = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                copy[i][j] = board[i][j];
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int count = 0;
                if(i-1>=0 && j-1>=0 && copy[i-1][j-1]==1) count++;
                if(i-1>=0 && copy[i-1][j]==1) count++;
                if(i-1>=0 && j+1<n && copy[i-1][j+1]==1) count++;
                if(j-1>=0 && copy[i][j-1]==1) count++;
                if(j+1<n && copy[i][j+1]==1) count++;
                if(i+1<m && j-1>=0 && copy[i+1][j-1]==1) count++;
                if(i+1<m && copy[i+1][j]==1) count++;
                if(i+1<m && j+1<n && copy[i+1][j+1]==1) count++;
                if(copy[i][j]==1 && (count<2 || count>3)) board[i][j] = 0;
                if(copy[i][j]==0 && count==3) board[i][j] = 1;
            }
        }
    }
}