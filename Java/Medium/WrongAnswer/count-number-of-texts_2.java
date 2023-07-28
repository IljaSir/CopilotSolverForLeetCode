class Solution {
    public int countTexts(String pressedKeys) {
        
        if (pressedKeys == null || pressedKeys.length() == 0) {
            return 0;
        }
        int[] dp = new int[pressedKeys.length()];
        dp[0] = 1;
        for (int i = 1; i < pressedKeys.length(); i++) {
            int cur = pressedKeys.charAt(i) - '0';
            int pre = pressedKeys.charAt(i - 1) - '0';
            if (cur == pre) {
                dp[i] = dp[i - 1];
            } else if (cur > pre) {
                dp[i] = dp[i - 1] * (cur - pre + 1);
            } else {
                dp[i] = dp[i - 1] * (cur + 10 - pre + 1);
            }
        }
        return dp[pressedKeys.length() - 1];
    }
}