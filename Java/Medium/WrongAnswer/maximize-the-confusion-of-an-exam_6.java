class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        
        int n = answerKey.length();
        int[] dp = new int[n];
        int[] dp2 = new int[n];
        
        dp[0] = 1;
        dp2[0] = 1;
        
        for (int i = 1; i < n; i++) {
            if (answerKey.charAt(i) == answerKey.charAt(i - 1)) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            
            if (answerKey.charAt(i) == (answerKey.charAt(i - 1) == 'T' ? 'F' : 'T')) {
                dp2[i] = dp2[i - 1] + 1;
            } else {
                dp2[i] = 1;
            }
        }
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
            max = Math.max(max, dp2[i]);
        }
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == max) {
                ans++;
            }
            if (dp2[i] == max) {
                ans++;
            }
        }
        return ans;
    }
}