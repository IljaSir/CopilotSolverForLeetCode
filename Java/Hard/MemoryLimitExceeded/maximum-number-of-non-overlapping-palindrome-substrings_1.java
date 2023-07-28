class Solution {
    public int maxPalindromes(String s, int k) {
        
        int n = s.length();
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }
        int odd = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) {
                odd++;
            }
        }
        if (odd > k) {
            return 0;
        }
        int[] dp = new int[1 << 26];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int mask = 0;
            for (int j = i; j < n; j++) {
                mask ^= 1 << (s.charAt(j) - 'a');
                if (Integer.bitCount(mask) <= k) {
                    dp[mask] = Math.max(dp[mask], j - i + 1);
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int mask = 0; mask < (1 << 26); mask++) {
                if ((mask & (1 << i)) == 0) {
                    dp[mask] = Math.max(dp[mask], dp[mask | (1 << i)]);
                }
            }
        }
        int ans = 0;
        for (int mask = 0; mask < (1 << 26); mask++) {
            int mask2 = ((1 << 26) - 1) ^ mask;
            ans = Math.max(ans, dp[mask] + dp[mask2]);
        }
        return ans;
    }
}