class Solution {
    public int maxLength(List<String> arr) {
        
        int[] dp = new int[]{};
        for (String s : arr) {
            int mask = 0;
            for (char c : s.toCharArray()) {
                int bit = c - 'a';
                if ((mask & (1 << bit)) > 0) {
                    mask = 0;
                    break;
                }
                mask |= (1 << bit);
            }

            if (mask == 0) {
                continue;
            }

            int[] dp2 = new int[dp.length + 1];
            for (int i = 0; i < dp.length; i++) {
                if ((dp[i] & mask) == 0) {
                    dp2[i] = dp[i];
                    dp2[dp.length] = dp[i] | mask;
                }
            }
            dp2[dp.length] = mask;
            dp = dp2;
        }
        int max = 0;
        for (int x : dp) {
            max = Math.max(max, Integer.bitCount(x));
        }
        return max;
    }
}