class Solution {
    public int findIntegers(int n) {
        
        String s = Integer.toBinaryString(n);
        int l = s.length();
        int[] dp = new int[l];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < l; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        int res = 0;
        int pre = 0;
        for (int i = l - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                res += dp[i];
                if (pre == 1) {
                    return res;
                }
                pre = 1;
            } else {
                pre = 0;
            }
        }
        return res + 1;
    }
}