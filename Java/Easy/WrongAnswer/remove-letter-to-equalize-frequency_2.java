class Solution {
    public boolean equalFrequency(String word) {
        
        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }
        int[] freq = new int[word.length() + 1];
        for (int c : count) {
            if (c > 0) {
                freq[c]++;
            }
        }
        int odd = 0;
        for (int f : freq) {
            if (f % 2 == 1) {
                odd++;
            }
        }
        return odd <= 1;
    }
}