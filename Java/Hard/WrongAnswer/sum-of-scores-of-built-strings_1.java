class Solution {
    public long sumScores(String s) {
        
        int n = s.length();
        int[] dp = new int[n];
        int i = 0, j = 1;
        while (j < n) {
            if (s.charAt(i) == s.charAt(j)) {
                dp[j] = i + 1;
                i++;
                j++;
            } else if (i > 0) {
                i = dp[i - 1];
            } else {
                j++;
            }
        }
        long sum = 0;
        for (int k = 0; k < n; k++) {
            sum += dp[k];
        }
        return sum;
    }
}