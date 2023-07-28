class Solution {
    public int maxProduct(String s) {
        
        int n = s.length();
        int[] dp = new int[1 << n];
        for (int mask = 0; mask < 1 << n; mask++) {
            if (isPalindrome(s, mask)) {
                dp[mask] = Integer.bitCount(mask);
            }
            for (int submask = mask; submask > 0; submask = (submask - 1) & mask) {
                dp[mask] = Math.max(dp[mask], dp[submask] * dp[mask - submask]);
            }
        }
        return dp[(1 << n) - 1];
    }

    private boolean isPalindrome(String s, int mask) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && ((mask >> i) & 1) == 0) i++;
            while (i < j && ((mask >> j) & 1) == 0) j--;
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}