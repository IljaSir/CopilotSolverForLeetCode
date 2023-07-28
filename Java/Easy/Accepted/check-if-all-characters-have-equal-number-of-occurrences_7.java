class Solution {
    public boolean areOccurrencesEqual(String s) {
        
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        int count = -1;
        for (int i = 0; i < 26; i++) {
            if (map[i] > 0) {
                if (count == -1) {
                    count = map[i];
                } else if (map[i] != count) {
                    return false;
                }
            }
        }
        return true;
    }
}