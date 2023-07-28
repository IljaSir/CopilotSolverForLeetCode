class Solution {
    public boolean equalFrequency(String word) {
        
        int[] count = new int[26];
        int[] freq = new int[word.length() + 1];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            freq[count[c - 'a']]--;
            count[c - 'a']++;
            freq[count[c - 'a']]++;
        }
        int odd = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 1) {
                odd++;
            }
        }
        if (odd > 1) {
            return false;
        }
        if (odd == 0) {
            return true;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 1) {
                return true;
            }
        }
        return false;
    }
}