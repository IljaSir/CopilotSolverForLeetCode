class Solution {
    public int minDeletions(String s) {
        
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        Arrays.sort(freq);
        int res = 0;
        for (int i = 25; i > 0; i--) {
            if (freq[i] == 0) {
                continue;
            }
            if (freq[i] > freq[i - 1]) {
                continue;
            }
            res += freq[i - 1] - freq[i] + 1;
            freq[i - 1] = freq[i] - 1;
        }
        return res;
    }
}