class Solution {
    public boolean areOccurrencesEqual(String s) {
        
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int first = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) continue;
            if (first == 0) {
                first = count[i];
            } else {
                if (first != count[i]) return false;
            }
        }
        return true;
    }
}