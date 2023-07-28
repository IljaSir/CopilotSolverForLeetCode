class Solution {
    public String largestNumber(int[] cost, int target) {
        
        String[] dp = new String[target + 1];
        dp[0] = "";
        for (int i = 1; i <= target; i++) {
            dp[i] = "0";
            for (int j = 0; j < cost.length; j++) {
                if (i >= cost[j]) {
                    String prev = dp[i - cost[j]];
                    if (prev.equals("0")) {
                        continue;
                    }
                    String cur = String.valueOf(j + 1);
                    if (prev.length() < dp[i].length() || (prev.length() == dp[i].length() && prev.compareTo(dp[i]) < 0)) {
                        continue;
                    }
                    dp[i] = prev + cur;
                }
            }
        }
        return dp[target];
    }
}