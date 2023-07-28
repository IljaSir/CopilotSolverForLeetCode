class Solution {
    public long sumScores(String s) {
        
        long sum = 0;
        int n = s.length();
        int[] dp = new int[n];
        dp[n-1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = s.charAt(i) == s.charAt(i + dp[i + 1]) ? 1 + dp[i + 1] : 1;
        }
        for (int i = 0; i < n; i++) {
            sum += dp[i];
        }
        return sum;
    }
}
    }
}