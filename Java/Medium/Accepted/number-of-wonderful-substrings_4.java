class Solution {
    public long wonderfulSubstrings(String word) {
        
        long[] dp = new long[1024];
        dp[0] = 1;
        int mask = 0;
        long res = 0;
        for (int i = 0; i < word.length(); i++) {
            mask ^= 1 << (word.charAt(i) - 'a');
            res += dp[mask];
            for (int j = 0; j < 10; j++) {
                res += dp[mask ^ (1 << j)];
            }
            dp[mask]++;
        }
        return res;
    }
}