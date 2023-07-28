class Solution {
    public int minSwaps(String s) {
        
        int n = s.length();
        int[] dp = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += s.charAt(i) == '[' ? 1 : -1;
            dp[i] = sum;
        }
        if (sum != 0) {
            return -1;
        }
        int res = n;
        for (int i = 0; i < n; i++) {
            if (dp[i] < 0) {
                res = Math.min(res, -dp[i]);
            }
        }
        return res;
    }
}