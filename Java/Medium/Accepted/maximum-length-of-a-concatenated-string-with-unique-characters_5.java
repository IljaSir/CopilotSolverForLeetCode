class Solution {
    public int maxLength(List<String> arr) {
        
        int[] dp = new int[1];
        for (String s : arr) {
            int mask = 0;
            for (int i = 0; i < s.length(); i++) {
                int ch = s.charAt(i) - 'a';
                if (((mask >> ch) & 1) > 0) {
                    mask = 0;
                    break;
                }
                mask |= 1 << ch;
            }
            if (mask == 0) {
                continue;
            }
            for (int i = dp.length - 1; i >= 0; i--) {
                if ((dp[i] & mask) > 0) {
                    continue;
                }
                dp = Arrays.copyOf(dp, dp.length + 1);
                dp[dp.length - 1] = dp[i] | mask;
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, Integer.bitCount(dp[i]));
        }
        return res;
    }
}