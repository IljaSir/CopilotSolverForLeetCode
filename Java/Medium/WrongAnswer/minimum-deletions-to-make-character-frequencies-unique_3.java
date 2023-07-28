class Solution {
    public int minDeletions(String s) {
        
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        Arrays.sort(freq);
        int ans = 0;
        for (int i = freq.length - 1; i > 0; i--) {
            if (freq[i] > 0 && freq[i] == freq[i - 1]) {
                freq[i - 1]--;
                ans++;
                i++;
            }
        }
        return ans;
    }
}