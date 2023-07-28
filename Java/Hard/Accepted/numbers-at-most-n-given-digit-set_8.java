class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        
        char[] digit = String.valueOf(n).toCharArray();
        int k = digit.length;
        int[] dp = new int[k+1];
        dp[k] = 1;
        for (int i = k - 1; i >= 0; --i) {
            int si = digit[i] - '0';
            for (String d: digits) {
                if (Integer.parseInt(d) < si)
                    dp[i] += Math.pow(digits.length, k - i - 1);
                else if (Integer.parseInt(d) == si)
                    dp[i] += dp[i+1];
            }
        }
        for (int i = 1; i < k; ++i)
            dp[0] += Math.pow(digits.length, i);
        return dp[0];
    }
}