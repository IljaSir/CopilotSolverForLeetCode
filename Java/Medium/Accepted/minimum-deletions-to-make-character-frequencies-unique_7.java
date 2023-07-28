class Solution {
    public int minDeletions(String s) {
        
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int[] cnt = new int[s.length() + 1];
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                cnt[freq[i]]++;
            }
        }
        int ans = 0;
        for (int i = cnt.length - 1; i > 0; i--) {
            if (cnt[i] > 1) {
                int t = cnt[i] - 1;
                ans += t;
                cnt[i - 1] += t;
            }
        }
        return ans;
    }
}