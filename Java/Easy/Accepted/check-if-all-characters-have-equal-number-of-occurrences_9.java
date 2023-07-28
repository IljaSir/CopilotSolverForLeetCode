class Solution {
    public boolean areOccurrencesEqual(String s) {
        
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int prev = 0;
        for (int n : count) {
            if (n != 0) {
                if (prev == 0) {
                    prev = n;
                } else if (prev != n) {
                    return false;
                }
            }
        }
        return true;
    }
}