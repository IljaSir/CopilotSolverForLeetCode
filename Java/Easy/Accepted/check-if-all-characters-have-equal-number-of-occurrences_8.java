class Solution {
    public boolean areOccurrencesEqual(String s) {
        
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int num = 0;
        for (int c : count) {
            if (c != 0) {
                if (num == 0) {
                    num = c;
                } else if (num != c) {
                    return false;
                }
            }
        }
        return true;
    }
}