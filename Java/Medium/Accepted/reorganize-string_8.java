class Solution {
    public String reorganizeString(String s) {
        
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        int maxCnt = 0;
        for (int i = 0; i < 26; i++) {
            maxCnt = Math.max(maxCnt, cnt[i]);
        }
        if (maxCnt > (s.length() + 1) / 2) {
            return "";
        }
        char[] ans = new char[s.length()];
        int even = 0, odd = 1;
        int halfLen = s.length() / 2;
        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 'a');
            while (cnt[i] > 0 && cnt[i] <= halfLen && odd < s.length()) {
                ans[odd] = c;
                cnt[i]--;
                odd += 2;
            }
            while (cnt[i] > 0) {
                ans[even] = c;
                cnt[i]--;
                even += 2;
            }
        }
        return String.valueOf(ans);
    }
}