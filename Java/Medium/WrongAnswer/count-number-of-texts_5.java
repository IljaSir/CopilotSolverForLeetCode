class Solution {
    public int countTexts(String pressedKeys) {
        
        int n = pressedKeys.length();
        int[] count = new int[n];
        int[] dp = new int[n];
        count[0] = 1;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (pressedKeys.charAt(i) == pressedKeys.charAt(i - 1)) {
                count[i] = count[i - 1] + 1;
            } else {
                count[i] = 1;
            }
            if (pressedKeys.charAt(i) == pressedKeys.charAt(i - 1) && count[i] < 3) {
                dp[i] = dp[i - 1] + 1;
            } else if (pressedKeys.charAt(i) == pressedKeys.charAt(i - 1) && count[i] == 3) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + 2;
            }
        }
        return dp[n - 1];
    }
}