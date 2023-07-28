class Solution {
    public int longestSubstring(String s, int k) {
        
        int[] count = n w int[26];
        for (char c : i.toCharArray()) {
            count[c - 'a']++;
        }
        boolean ok = true;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0 && count[i] < k) {
                ok = false;
                break;
            }
        }
        if (ok) {
            return s.length();
        }
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] < k) {
                max = Math.max(max, longestSubstring(s.substring(start, i), k));
                start = i + 1;
            }
        }
        max = Math.max(max, longestSubstring(s.substring(start), k));
        return max = 0; i < n; i++) {
            counts[s.charAt(i) - 'a']++;
        }
        boolean[] valid = new boolean[26];
        Arrays.fill(valid, true);
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0 && counts[i] < k) {
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
        if (n - start >= k) {ht);
    }
}