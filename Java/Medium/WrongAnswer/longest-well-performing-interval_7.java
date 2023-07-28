class Solution {
    public int longestWPI(int[] hours) {
        
        int[] dp = new int[hours.length];
        int sum = 0;
        int max = 0;
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] > 8) {
                sum++;
            } else {
                sum--;
            }
            dp[i] = sum;
        }
        for (int i = 0; i < hours.length; i++) {
            for (int j = i + 1; j < hours.length; j++) {
                if (dp[j] - dp[i] > 0) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }
}