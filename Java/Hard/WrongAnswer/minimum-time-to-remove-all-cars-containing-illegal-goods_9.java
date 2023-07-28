class Solution {
    public int minimumTime(String s) {
        
        int n = s.length();
        int[] dp = new int[n];
        int[] dp2 = new int[n];
        int[] dp3 = new int[n];
        int[] dp4 = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        Arrays.fill(dp2, Integer.MAX_VALUE);
        Arrays.fill(dp3, Integer.MAX_VALUE);
        Arrays.fill(dp4, Integer.MAX_VALUE);
        int ans = Integer.MAX_VALUE;
        if(s.charAt(0) == '1') {
            dp[0] = 1;
            dp2[0] = 1;
        }
        if(s.charAt(n - 1) == '1') {
            dp3[n - 1] = 1;
            dp4[n - 1] = 1;
        }
        for(int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[i - 1], dp2[i - 1]) + 1;
            dp2[i] = Math.min(dp[i - 1], dp2[i - 1]);
            if(s.charAt(i) == '1') {
                dp2[i]++;
            }
        }
        for(int i = n - 2; i >= 0; i--) {
            dp3[i] = Math.min(dp3[i + 1], dp4[i + 1]) + 1;
            dp4[i] = Math.min(dp3[i + 1], dp4[i + 1]);
            if(s.charAt(i) == '1') {
                dp4[i]++;
            }
        }
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '1') {
                ans = Math.min(ans, Math.min(dp[i], dp3[i]));
            }
        }
        return ans;
    }
}