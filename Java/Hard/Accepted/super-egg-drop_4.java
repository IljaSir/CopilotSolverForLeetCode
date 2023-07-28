class Solution {
    public int superEggDrop(int k, int n) {
        
        int[][] dp = new int[k+1][n+1];
        for(int i=1; i<=n; i++){
            dp[1][i] = i;
        }
        for(int i=1; i<=k; i++){
            dp[i][1] = 1;
        }
        for(int i=2; i<=k; i++){
            for(int j=2; j<=n; j++){
                int min = Integer.MAX_VALUE;
                int low = 1;
                int high = j;
                while(low <= high){
                    int mid = (low + high) / 2;
                    int left = dp[i-1][mid-1];
                    int right = dp[i][j-mid];
                    min = Math.min(min, 1 + Math.max(left, right));
                    if(left < right){
                        low = mid + 1;
                    }
                    else{
                        high = mid - 1;
                    }
                }
                dp[i][j] = min;
            }
        }
        return dp[k][n];
    }
}