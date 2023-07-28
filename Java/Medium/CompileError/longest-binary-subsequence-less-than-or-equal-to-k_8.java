class Solution {
    public int longestSubsequence(String s, int k) {
        
        int n = s.length();
        int[] dp = new int[n];
        int[] last = new int[n];
        int[] first = new int[n];
        int[] next = new int[n];
        int[] prev = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(next, n);
        Arrays.fill(prev, -1);
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                cnt[i] = 1;
                if (i > 0) {
                    cnt[i] += cnt[i - 1];
                }
            }
            if (i > 0 && s.charAt(i - 1) == '0') {
                prev[i] = i - 1;
            } else {
                prev[i] = prev[i - 1];
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && s.charAt(i + 1) == '0') {
                next[i] = i + 1;
            } else {
                next[i] = next[i + 1];
            }
        }
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                first[i] = i;
                if (i > 0) {
                    first[i] = first[i - 1];
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                last[i] = i;
                if (i < n - 1) {
                    last[i] = last[i + 1];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                int j = i;
                int sum = 0;
                while (j < n) {
                    sum = sum * 2 + s.charAt(j) - '0';
                    if (sum > k) {
                        break;
                    }
                    int len = j - i + 1;
                    if (i > 0) {
                        len += dp[i - 1];
                    }
    }
}