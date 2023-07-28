class Solution {
    public int uniqueLetterString(String s) {
        
        int N = s.length();
        int[] last = new int[26];
        int[] dp = new int[N + 1];
        int[] dp2 = new int[N + 1];
        for (int i = 0; i < 26; ++i) last[i] = -1;
        for (int i = 0; i < N; ++i) {
            int x = s.charAt(i) - 'A';
            dp[i + 1] = dp[i] + (i + 1) - last[x];
            last[x] = i + 1;
        }
        for (int i = 0; i < 26; ++i) last[i] = N + 1;
        for (int i = N - 1; i >= 0; --i) {
            int x = s.charAt(i) - 'A';
            dp2[i] = dp2[i + 1] + last[x] - (i + 1);
            last[x] = i + 1;
        }
        int ans = 0;
        for (int i = 0; i < N; ++i) {
            int x = s.charAt(i) - 'A';
            ans += dp[i + 1] * dp2[i + 1];
        }
        return ans;
    }
}