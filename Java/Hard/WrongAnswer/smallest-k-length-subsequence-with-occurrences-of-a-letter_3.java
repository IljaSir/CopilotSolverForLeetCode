class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        
        int n = s.length();
        int[] cnt = new int[n];
        cnt[n - 1] = s.charAt(n - 1) == letter ? 1 : 0;
        for (int i = n - 2; i >= 0; i--) {
            cnt[i] = cnt[i + 1] + (s.charAt(i) == letter ? 1 : 0);
        }
        int[] pos = new int[26];
        Arrays.fill(pos, -1);
        for (int i = 0; i < n; i++) {
            pos[s.charAt(i) - 'a'] = i;
        }
        char[] ans = new char[k];
        int p = 0;
        int r = repetition;
        for (int i = 0; i < k - repetition; i++) {
            for (int j = 0; j < 26; j++) {
                if (pos[j] < p) {
                    continue;
                }
                if (cnt[pos[j]] >= r && pos[j] + k - i <= n) {
                    ans[i] = (char) ('a' + j);
                    p = pos[j] + 1;
                    break;
                }
            }
        }
        for (int i = k - repetition; i < k; i++) {
            ans[i] = letter;
        }
        return new String(ans);
    }
}