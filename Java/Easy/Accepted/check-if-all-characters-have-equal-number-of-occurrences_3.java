class Solution {
    public boolean areOccurrencesEqual(String s) {
        
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        int first = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                first = count[i];
                break;
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0 && count[i] != first) {
                return false;
            }
        }
        return true;
    }
}