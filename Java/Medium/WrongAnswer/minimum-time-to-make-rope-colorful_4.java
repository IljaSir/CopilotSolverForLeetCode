class Solution {
    public int minCost(String colors, int[] neededTime) {
        
        int n = colors.length();
        int[][] dp = new int[n][3];
        for(int i=0; i<n; i++){
            for(int j=0; j<3; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i=0; i<n; i++){
            int c = colors.charAt(i)-'a';
            for(int j=0; j<3; j++){
                if(i==0){
                    if(c==j){
                        dp[i][j] = neededTime[i];
                    }
                }else{
                    if(c==j){
                        dp[i][j] = Math.min(dp[i-1][j], dp[i-1][(j+1)%3]+neededTime[i]);
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
    }
}