class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        
        int n = s.length();
        int[] cnt = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        int p = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == letter) {
                cnt2[c - 'a']++;
                cnt[c - 'a']--;
                p++;
            }
            if (p == repetition) {
                break;
            }
        }
        int m = n - p;
        char[] res = new char[k];
        int t = 0;
        int[] cnt3 = new int[26];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (cnt2[c - 'a'] > 0) {
                cnt2[c - 'a']--;
                cnt3[c - 'a']++;
                continue;
            }
            if (cnt[c - 'a'] > 0) {
                while (t > 0 && res[t - 1] > c && cnt[res[t - 1] - 'a'] + cnt3[res[t - 1] - 'a'] > 0) {
                    cnt3[res[t - 1] - 'a']--;
                    t--;
                }
                res[t++] = c;
                cnt[c - 'a']--;
            }
        }
        return new String(res);
    }
}