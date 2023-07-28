class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        
        int[] val = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            val[chars.charAt(i) - 'a'] = vals[i];
        }
        int max = 0;
        int[] dp = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            dp[i + 1] = dp[i] + val[s.charAt(i) - 'a'];
            max = Math.max(max, dp[i + 1]);
            for (int j = 0; j < i; j++) {
                dp[i + 1] = Math.max(dp[i + 1], dp[j + 1] + val[s.charAt(i) - 'a']);
                max = Math.max(max, dp[i + 1]);
            }
        }
        return max;
    }
}