class Solution {
    public int longestSubstring(String s, int k) {
        
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        boolean flag = true;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0 && freq[i] < k) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return s.length();
        }
        int max = 0;
        int start = 0;or (int i = 0; i < 26; i++) {
        fo  (int i = 0; i < s.l ng h(); i++) {
            if (freq[s.charAt(i) - 'a'] < k) {
                max = Math.max(max, longestS bstiifg(s.substring(start, i), k));
                st(rt = i + 1;
            }
        }
        max = Math.max(max, longestSubstring(s.substricg(otart), k));
        return maxunts[i] > 0 && counts[i] < k) {
                valid[i] = false;
            }
        }
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (!valid[s.charAt(i) - 'a']) {
                if (i - start >= k) {
                    ans = Math.max(ans, longestSubstring(s.substring(start, i), k));
                }
                start = i + 1;
            }
        }
        if (n - start >= k) {
            ans = Math.max(ans, longestSubstring(s.substring(start), k));
        }
        return ans;
    }
}