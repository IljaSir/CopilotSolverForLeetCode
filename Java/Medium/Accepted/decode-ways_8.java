class Solution {
    public int numDecodings(String s) {
        
        int n = s.length();
        char[] arr = s.toCharArray();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = arr[0] == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            if (arr[i-1] != '0') {
                dp[i] += dp[i-1];
            }
            if (arr[i-2] == '1' || (arr[i-2] == '2' && arr[i-1] <= '6')) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}