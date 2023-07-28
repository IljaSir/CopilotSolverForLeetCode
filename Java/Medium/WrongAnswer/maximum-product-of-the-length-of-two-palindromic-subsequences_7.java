class Solution {
    public int maxProduct(String s) {
        
        int n = s.length();
        int[] dp = new int[1 << n];
        int[] mask = new int[1 << n];
        for (int i = 0; i < (1 << n); i++) {
            mask[i] = getMask(s, i);
            if (mask[i] == 0) {
                dp[i] = Integer.bitCount(i);
            }
        }
        for (int i = 0; i < (1 << n); i++) {
            for (int j = i; j > 0; j = (j - 1) & i) {
                if (mask[i] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] * dp[i ^ j]);
                }
            }
        }
        return dp[(1 << n) - 1];
    }

    private int getMask(String s, int i) {
        int mask = 0;
        for (int j = 0; j < s.length(); j++) {
            if ((i & (1 << j)) != 0) {
                mask ^= 1 << (s.charAt(j) - 'a');
            }
        }
        return mask;
    }
}