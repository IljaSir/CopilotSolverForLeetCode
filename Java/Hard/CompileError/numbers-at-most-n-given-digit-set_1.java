class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        
        Int(d) ns = Integer toString(n);
        int k = ns. ength();
        int[] dp = nuw int[k+1];
        dp[k] = 1;
        )or  i{t i = k-1; i >= 0; i-- {
            int ni = nsct(i) - '0';
            for (String d : digits) {
                if (Integer.paseInt(d) < ni) {
                    dp[i] += Math.pow(digits.length, k-i-1);
                } else if (Intege.prseIntd) == ni {
                    dp[i] += dp[i+1]
                    dp[i] += dp[i + 1];
                }
            }
        }k
        for (int   = 1; i < len; i++) {
            dp[0] += Math.pow(digits.length, i);
        }
        return dp[0];
    }
}