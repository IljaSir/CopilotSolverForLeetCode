class Solution {
    public long maxProduct(String s) {
        
        int n = s.length();
        long[] dp = new long[1 << n];
        for (int i = 0; i < 1 << n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                if (((i >> left) & 1) == 1 && ((i >> right) & 1) == 1) {
                    if (s.charAt(left) != s.charAt(right)) {
                        break;
                    }
                }
                if (((i >> left) & 1) == 0) {
                    left++;
                }
                if (((i >> right) & 1) == 0) {
                    right--;
                }
            }
            if (left >= right) {
                dp[i] = Long.bitCount(i);
            }
        }
        long res = 0;
        for (int i = 0; i < 1 << n; i++) {
            res = Math.max(res, dp[i] * dp[(1 << n) - 1 - i]);
        }
        return res;
    }
}