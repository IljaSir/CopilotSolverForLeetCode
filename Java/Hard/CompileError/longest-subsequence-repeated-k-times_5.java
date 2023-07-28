class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        
        int n = s.length();
        int[] dp = new int[n];
        int[] last = new int[26];
        Arrays.fill(last, -1);
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            dp[i] = (i > 0 ? dp[i - 1] : 0) + 1;
            if (last[c] >= 0) {
                dp[i] = Math.max(dp[i], dp[last[c]] + 1);
            }
            last[c] = i;
        }
        int total = dp[n - 1];
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }
        int[] next = new int[26];
        int[] prev = new int[26];
        for (int i = 0; i < 26; i++) {
            next[i] = (i + 1) % 26;
            prev[i] = (i + 25) % 26;
        }
        int[] idx = new int[26];
        for (int i = 0; i < 26; i++) {
            idx[i] = n;
        }
        for (int i = n - 1; i >= 0; i--) {
            int c = s.charAt(i) - 'a';
            if (count[c] > 0) {
                idx[c] = i;
                count[c]--;
            }
        }
        int[] ans = new int[total];
        int ansLen = 0;
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (dp[i] == total && count[c] % k == 0) {
                while (ansLen > 0 && ans[ansLen - 1] < c) {
                    int d = ans[ansLen - 1];
                    next[prev[d]] = next[d];
                    prev[next[d]] = prev[d];
                    ansLen--;
                }
                ans[ansLen++] = c;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ansLen; i++) {
    }
}