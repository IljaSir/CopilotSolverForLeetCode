class Solution {
    public int minDeletions(String s) {
        
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        Arrays.sort(freq);
        int ans = 0;
        for (int i = 24; i >= 0; i--) {
            if (freq[i] == 0) {
                break;
            }
            if (freq[i] > freq[i + 1]) {
                ans += freq[i] - freq[i + 1];
                freq[i] = freq[i + 1];
            }
            if (freq[i] == freq[i + 1]) {
                ans += freq[i];
                freq[i] = 0;
            }
        }
        return ans;
    }
}