class Solution {
    public int racecar(int target) {
        
        int[] dp = new int[target + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            int speed = 1;
            int pos = 0;
            for (int j = 0; j < dp.length; j++) {
                if (pos == i) {
                    dp[i] = Math.min(dp[i], j);
                    break;
                } else if (pos > i) {
                    break;
                }
                pos += speed;
                speed *= 2;
            }
            speed = 1;
            pos = 0;
            for (int j = 0; j < dp.length; j++) {
                if (pos == i) {
                    dp[i] = Math.min(dp[i], j + 1);
                    break;
                } else if (pos > i) {
                    break;
                }
                pos += speed;
                speed *= -2;
            }
        }
        return dp[target];
    }
}