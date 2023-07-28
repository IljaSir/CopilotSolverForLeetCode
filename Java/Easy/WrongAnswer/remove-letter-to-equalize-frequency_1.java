class Solution {
    public boolean equalFrequency(String word) {
        
        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }
        int[] freq = new int[word.length() + 1];
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                freq[count[i]]++;
            }
        }
        int odd = 0;
        for (int i = 0; i <= word.length(); i++) {
            if (freq[i] % 2 == 1) {
                odd++;
            }
        }
        return odd <= 1;
    }
}