class Solution {
    public int minFlipsMonoIncr(String s) {
        
        int n = s.length();
        int[] dp = new int[n];
        int zero = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                zero++;
            }
            dp[i] = zero;
        }
        int one = 0;
        int min = n;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                one++;
            }
            if (i == 0) {
                min = Math.min(min, one);
            } else {
                min = Math.min(min, one + dp[i - 1]);
            }
        }
        return min;
    }
}