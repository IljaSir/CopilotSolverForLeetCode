class Solution {
    public boolean areOccurrencesEqual(String s) {
        
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        int freq = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                if (freq == 0) {
                    freq = count[i];
                } else if (freq != count[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}