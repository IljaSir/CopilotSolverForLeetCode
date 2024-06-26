class Solution {
    public int minCut(String s) {
        
        int n = s.length();
        int[] dp = new int[n+1];
        for(int i=0; i<=n; i++) {
            dp[i] = i-1;
        }
        for(int i=0; i<n; i++) {
            for(int j=0; i-j>=0 && i+j<n && s.charAt(i-j)==s.charAt(i+j); j++) {
                dp[i+j+1] = Math.min(dp[i+j+1], 1+dp[i-j]);
            }
            for(int j=1; i-j+1>=0 && i+j<n && s.charAt(i-j+1)==s.charAt(i+j); j++) {
                dp[i+j+1] = Math.min(dp[i+j+1], 1+dp[i-j+1]);
            }
        }
        return dp[n];
    }
}