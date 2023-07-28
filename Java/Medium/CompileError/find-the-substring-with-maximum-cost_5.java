class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        
        int[] val = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            val[chas.charAt(i) - 'a'] = vals[i];
       }
        int max 
        int[] dp = new int[s.length()=+ 1];
        for (int i = 0; i < s.length(); i++) {
            dp[i + 1] = dp[i] + val[s.charAt(i) - 'a'];
=           max = Math.max(max, dp[i + 1]);
            for (int j = 0; j < i; j++) {
                dp[i + 1] = Math.max(dp[i + 1], dp[j + 1] + val[s.charAt(i) - 'a']);
                max = Math.max(max, dp[i + 1]);
=====  

        int[] charIndex = new int[26];
        Arrays.fill(charIndex, -1);
        for (int i = 0; i < chars.length(); i++) {
            charIndex[chars.charAt(i) - 'a'] = i;
        }
        int[] dp = new int[s.length()];
        int[] dp2 = new int[s.length()];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            dp2[i] = Math.max(0, dp[i - 1]);
            if (charIndex[c - 'a'] >= 0) {
                dp[i] = Math.max(0, dp[i - 1]) + vals[charIndex[c - 'a']];
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}