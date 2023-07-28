class Solution {
    public boolean areOccurrencesEqual(String s) {
        
        int[] count = new int[26];
        int max = 0;
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
            max = Math.max(max, count[c - 'a']);
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0 && count[i] != max) {
                return false;
            }
        }
        return true;
    }
}