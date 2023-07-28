class Solution {
    public int longestStrChain(String[] words) {
        
        int[] dp = new int[17];
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for (String word : words) {
            int best = 0;
            for (int i = 0; i < word.length(); ++i) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                best = Math.max(best, dp[prev.length()]);
            }
            dp[word.length()] = best + 1;
        }
        int ans = 0;
        for (int x : dp) ans = Math.max(ans, x);
        return ans;
    }
}