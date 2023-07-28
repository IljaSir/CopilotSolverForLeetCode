class Solution {
    public int minCost(int n, int[] cuts) {
        
        int[] cut = new int[cuts.length+2];
        cut[0] = 0;
        cut[cut.length-1] = n;
        for(int i=1;i<cut.length-1;i++){
            cut[i] = cuts[i-1];
        }
        Arrays.sort(cut);
        int[][] dp = new int[cut.length][cut.length];
        for(int i=2;i<cut.length;i++){
            for(int j=0;j+i<cut.length;j++){
                dp[j][j+i] = Integer.MAX_VALUE;
                for(int k=j+1;k<j+i;k++){
                    dp[j][j+i] = Math.min(dp[j][j+i],dp[j][k]+dp[k][j+i]+cut[j+i]-cut[j]);
                }
            }
        }
        return dp[0][cut.length-1];
    }
}