class Solution {
    public boolean equalFrequency(String word) {
        
        int[] freq = new int[26];
        for (int i = 0; i < word.length(); i++) {
            freq[word.charAt(i) - 'a']++;
        }
        int[] count = new int[word.length() + 1];
        for (int f : freq) {
            if (f > 0) {
                count[f]++;
            }
        }
        int n = word.length();
        if (count[1] == n) {
            return true;
        }
        if (count[1] == 1) {
            return count[n] == 1;
        }
        if (count[n] == 1) {
            return count[1] == 1;
        }
        return false;
    }
}