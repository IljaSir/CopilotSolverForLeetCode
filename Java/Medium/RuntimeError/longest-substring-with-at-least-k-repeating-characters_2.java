class Solution {
    public int longestSubstring(String s, int k) {
        
        int n = s.length();
        if (n < k) return 0;
        int[] counts = new int[26];
        for (int i = 0; i < n; i++) {
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
        if (n - start >= k) {
            ans = Math.max(ans, longestSubstring(s.substring(start), k));
        }
        return ans;
    }
}