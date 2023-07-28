class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            map.put(chars.charAt(i), vals[i]);
        }
        int ans = 0;
        int[] dp = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int cur = map.getOrDefault(c, c - 'a' + 1);
            dp[i + 1] = Math.max(dp[i] + cur, cur);
            ans = Math.max(ans, dp[i + 1]);
        }
        return ans;
    }
}