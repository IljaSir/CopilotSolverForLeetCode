class Solution {
    public String kthSmallestPath(int[] destination, int k) {
        
        int row = destination[0];
        int col = destination[1];
        
        // create a 2d array to store the number of paths to reach a certain point
        int[][] dp = new int[row + 1][col + 1];
        
        // base case - there is only 1 path to reach a point in the first column
        for (int i = 0; i <= row; i++) {
            dp[i][0] = 1;
        }
        
        // base case - there is only 1 path to reach a point in the first row
        for (int i = 0; i <= col; i++) {
            dp[0][i] = 1;
        }
        
        // fill the dp array
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        
        // create a string builder to store the path
        StringBuilder sb = new StringBuilder();
        
        // start at the beginning
        int i = 0;
        int j = 0;
        
        // loop until we reach the destination
        while (i < row || j < col) {
            
            // if we are at the bottom, we can only go right
            if (i == row) {
                sb.append('H');
                j++;
            }
            
            // if we are at the right, we can only go down
            else if (j == col) {
                sb.append('V');
                i++;
            }
            
            // otherwise, we can go either right or down
            else {
                
                // if there are more paths to reach the destination if we go right, we go right
                if (dp[i][j + 1] >= k) {
                    sb.append('H');
                    j++;
                }
                
                // otherwise, we go down
                else {
                    sb.append('V');
                    i++;
                    k -= dp[i][j];
                }
            }
        }
        
        return sb.toString();
    }
}