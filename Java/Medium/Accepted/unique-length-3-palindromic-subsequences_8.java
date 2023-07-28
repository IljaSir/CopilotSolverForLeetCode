class Solution {
    public int countPalindromicSubsequence(String s) {
        
        int[] prev = new int[26];
        int[] next = new int[26];
        Arrays.fill(prev, -1);
        Arrays.fill(next, -1);
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';
            if (prev[ch] == -1) {
                prev[ch] = i;
            }
            next[ch] = i;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (prev[i] != -1) {
                int[] cnt = new int[26];
                for (int j = prev[i] + 1; j < next[i]; j++) {
                    cnt[s.charAt(j) - 'a']++;
                }
                for (int j = 0; j < 26; j++) {
                    if (cnt[j] > 0) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}