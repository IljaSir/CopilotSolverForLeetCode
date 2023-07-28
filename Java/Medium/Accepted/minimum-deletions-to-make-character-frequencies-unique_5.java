class Solution {
    public int minDeletions(String s) {
        
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        int ans = 0;
        boolean[] used = new boolean[s.length() + 1];
        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0 && used[freq[i]]) {
                freq[i]--;
                ans++;
            }
            used[freq[i]] = true;
        }
        return ans;
    }
}