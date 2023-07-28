class Solution {
    public int uniqueLetterString(String s) {
        
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int n = s.length();
        int[] last = new int[26];
        int[] next = new int[26];
        Arrays.fill(last, -1);
        Arrays.fill(next, -1);
        int[] dp = new int[n];
        dp[0] = 1;
        last[s.charAt(0) - 'A'] = 0;
        for (int i = 1; i < n; i++) {
            int idx = s.charAt(i) - 'A';
            next[idx] = i;
            dp[i] = dp[i - 1] + i - last[idx] - (next[idx] - last[idx]) + 1;
            last[idx] = i;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += dp[i];
        }
        return ans;
    }
}