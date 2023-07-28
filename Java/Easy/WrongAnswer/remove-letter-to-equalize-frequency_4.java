class Solution {
    public boolean equalFrequency(String word) {
        
        int[] freq = new int[26];
        for (int i = 0; i < word.length(); i++) {
            freq[word.charAt(i) - 'a']++;
        }
        int[] freq2 = new int[26];
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                freq2[freq[i]]++;
            }
        }
        int count = 0;
        int index = 0;
        for (int i = 0; i < 26; i++) {
            if (freq2[i] > 0) {
                count++;
                index = i;
            }
        }
        if (count == 1 && index == 1) {
            return true;
        }
        if (count == 2) {
            for (int i = 0; i < 26; i++) {
                if (freq[i] == index) {
                    freq[i]--;
                }
            }
            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0 && freq[i] != index - 1) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}