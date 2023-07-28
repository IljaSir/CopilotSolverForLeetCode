class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        
        int n = garbage.length;
        int[][] dp = new int[n][3];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], 100000);
        }
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = 0;
        for(int i=0; i<n-1; i++){
            for(int j=0; j<3; j++){
                for(int k=0; k<3; k++){
                    if(garbage[i].charAt(k) == 'M'){
                        dp[i+1][0] = Math.min(dp[i+1][0], dp[i][j] + travel[i] + (j==0?0:1));
                    }
                    if(garbage[i].charAt(k) == 'P'){
                        dp[i+1][1] = Math.min(dp[i+1][1], dp[i][j] + travel[i] + (j==1?0:1));
                    }
                    if(garbage[i].charAt(k) == 'G'){
                        dp[i+1][2] = Math.min(dp[i+1][2], dp[i][j] + travel[i] + (j==2?0:1));
                    }
                }
            }
        }
        int ans = 100000;
        for(int i=0; i<3; i++){
            ans = Math.min(ans, dp[n-1][i] + (garbage[n-1].charAt(i)=='M'?0:1));
        }
        return ans;
    }
}