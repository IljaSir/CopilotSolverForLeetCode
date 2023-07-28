class Solution {
    public boolean areOccurrencesEqual(String s) {
        
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int num = -1;
        for (int i : count) {
            if (i == 0) {
                continue;
            }
            if (num == -1) {
                num = i;
                continue;
            }
            if (i != num) {
                return false;
            }
        }
        return true;
    }
}